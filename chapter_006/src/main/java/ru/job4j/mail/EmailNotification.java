package ru.job4j.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void emailTo(User user) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                String subject = "Notification " + user.getUserName() + " to email " + user.getEmail() + ".";
                String body = "Add a new event to " + user.getUserName();
                String email = user.getEmail();
                send(subject, body, email);
            }
        });
    }

    public void close() {
        pool.shutdown();
    }

    public void send(String subject, String body, String email) {
    }
}
