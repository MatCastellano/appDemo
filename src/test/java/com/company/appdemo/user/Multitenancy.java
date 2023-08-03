package com.company.appdemo.user;


import com.company.appdemo.entity.User;
import com.company.appdemo.security.FullAccessRole;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.multitenancy.entity.Tenant;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Scope("prototype")
@Component("Multitenancy")
public class Multitenancy {

    private final DataManager dataManager;

    private final SystemAuthenticator systemAuthenticator;

    private final User user;

    private final Tenant tenant;

    public Multitenancy(DataManager dataManager, SystemAuthenticator systemAuthenticator) {
        this.dataManager = dataManager;
        this.systemAuthenticator = systemAuthenticator;
        tenant= initTenant();
        user= createUserForTenant(tenant, FullAccessRole.CODE);
    }

    public User getUser() {
        return user;
    }

    public Tenant getTenant() {
        return tenant;
    }

    private User createUserForTenant(Tenant tenant, String roleCode) {
        return systemAuthenticator.withSystem(() -> {
            User user= createUser(tenant);
            dataManager.save(user, createRoleAssignement(roleCode, user));

            return dataManager.load(Id.of(user)).one();
        });
    }

    private RoleAssignmentEntity createRoleAssignement(String roleCode, User user) {
        RoleAssignmentEntity userRoleAssignement = dataManager.create(RoleAssignmentEntity.class);
        userRoleAssignement.setUsername(user.getUsername());
        userRoleAssignement.setRoleCode(roleCode);
        userRoleAssignement.setRoleType(RoleAssignmentRoleType.RESOURCE);
        return userRoleAssignement;
    }


    @NotNull
    private User createUser(Tenant tenant) {

        User user=dataManager.create(User.class);
        user.setTenant(tenant.getTenantId());
        user.setUsername(tenant.getTenantId()+ "-user");
        return user;
    }

    @NotNull
    private Tenant initTenant() {
        
        return systemAuthenticator.withSystem(() -> dataManager.save(createTenant()));
    }
    
    @NotNull
    private Tenant createTenant(){
        Tenant entity = dataManager.create(Tenant.class);
        String tenantID= uniqueString();
        entity.setTenantId("tenant-" + tenantID);
        entity.setName("Tenant " + tenantID);
        return entity;
    }

    private String uniqueString() {
        return UUID.randomUUID().toString();
    }

    public void setup() {
       systemAuthenticator.begin(user.getUsername());
    }

    public void end() {
        systemAuthenticator.end();
    }
}
