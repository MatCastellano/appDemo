package com.company.appdemo.screen.calendar;

import com.company.appdemo.entity.Order_Tab;
import io.jmix.core.Messages;
import io.jmix.ui.Screens;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.calendar.SimpleCalendarEvent;
import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@UiController("Calendar_1.browse")
@UiDescriptor("calendar_1-browse.xml")
public class Calendar1Browse extends StandardLookup<Calendar> {

        @Autowired
        private io.jmix.ui.component.Calendar<Date> calendar;


        @Autowired
        private DateField<Date> startDateField;

        @Autowired
        private DateField<Date> endDateField;

        @Autowired
        protected io.jmix.ui.component.TextField<String> descriptionField;
        @Autowired
        protected io.jmix.ui.component.TextField<String> captionField;

        @Autowired
        protected Messages messages;

        private Order_Tab order;
        protected SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        @Subscribe
        protected void onInit(InitEvent event) {
            startDateField.setValue(df.parse("2023-07-17 00:00", new ParsePosition(0)));
            endDateField.setValue(df.parse("2023-07-31 00:00", new ParsePosition(0)));
            captionField.setValue(messages.getMessage("com.company.appdemo.entity", "Calendar"));
            descriptionField.setValue(messages.getMessage("com.company.appdemo.entity", "Calendar"));
            generateEvents();
        }

        @Subscribe("addEvent")
        protected void onAddEventClick(io.jmix.ui.component.Button.ClickEvent event) {
            generateEvent(
                    captionField.getValue(),
                    descriptionField.getValue(),
                    startDateField.getValue(),
                    endDateField.getValue()
            );
        }

        protected void generateEvents() {
            String captions = "Order";
            String[] descriptions = {
                    "Student training",
                    "Platform development",
                    "UI development",
                    "Weekend",
                    "Party with friends"
            };

            generateEvent(captions, descriptions[0], startDateField.getValue(), endDateField.getValue());
        /*generateEvent(captions, descriptions[1], "2020-07-17 15:00", "2020-07-17 18:00");
        generateEvent(captions, descriptions[2], "2020-07-18 08:00", "2020-07-18 12:00");
        generateEvent(captions, descriptions[1], "2020-07-18 13:00", "2020-07-18 18:00");
        generateEvent(captions, descriptions[3], "2020-07-19 00:00", "2020-07-19 23:59");
        generateEvent(captions, descriptions[2], "2020-07-20 08:00", "2020-07-20 12:00");
        generateEvent(captions, descriptions[1], "2020-07-20 13:00", "2020-07-20 18:00");
        generateEvent(captions, descriptions[4], "2020-07-20 19:00", "2020-07-21 07:59");
        generateEvent(captions, descriptions[0], "2020-07-21 09:00", "2020-07-21 14:00");
        generateEvent(captions, descriptions[1], "2020-07-21 15:00", "2020-07-21 18:00");
        generateEvent(captions, descriptions[2], "2020-07-22 08:00", "2020-07-22 12:00");
        generateEvent(captions, descriptions[1], "2020-07-22 13:00", "2020-07-22 18:00");
        generateEvent(captions, descriptions[0], "2020-07-23 09:00", "2020-07-23 14:00");
        generateEvent(captions, descriptions[1], "2020-07-23 15:00", "2020-07-23 18:00");*/
        }

        protected void generateEvent(String caption, String description, String start, String end) {
            generateEvent(
                    caption,
                    description,
                    df.parse(start, new ParsePosition(0)),
                    df.parse(end, new ParsePosition(0))
            );
        }

        protected void generateEvent(String caption, String description, Date start, Date end) {
            SimpleCalendarEvent<Date> calendarEvent = new SimpleCalendarEvent<>();
            calendarEvent.setCaption(caption);
            calendarEvent.setDescription(description);
            calendarEvent.setStart(start);
            calendarEvent.setEnd(end);

            calendar.getEventProvider().addEvent(calendarEvent);
        }

}