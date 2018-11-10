package ru.job4j.mail;

import org.junit.Test;
import java.util.concurrent.RejectedExecutionException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EmailNotificationTest {

    @Test
    public void whenSendEmailThenIt() throws InterruptedException {
        EmailTest emailTest = new EmailTest();
        User user = new User("Mike", "Mike@gmail.com");
        emailTest.emailTo(user);
        Thread.sleep(1000);
        assertThat(emailTest.getValue(), is("Notification Mike to email Mike@gmail.com."));
    }

    @Test(expected = RejectedExecutionException.class)
    public void whenSendEmailAfterClosePoolThenExeption() {
        EmailNotification emailNotification = new EmailNotification();
        User user = new User("Mike", "Mike@gmail.com");
        emailNotification.close();
        emailNotification.emailTo(user);
    }

    private class EmailTest extends EmailNotification {
        private String value;

        @Override
        public void send(String subject, String body, String email) {
            value = subject;
            super.send(subject, body, email);
        }

        public String getValue() {
            return value;
        }
    }
}