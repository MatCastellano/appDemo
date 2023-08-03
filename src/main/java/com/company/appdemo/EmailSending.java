package com.company.appdemo;


import javax.mail.Session;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class EmailSending extends Authenticator {

    private String user;

    private String pw;

    private Properties prop;

    public EmailSending(String username, String password, Properties prop ) {
        super();
        this.user = username;
        this.pw= password;
        this.prop= new Properties();
    }


    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user, pw.toCharArray());
    }

    Session session= Session.getInstance(prop);
}
