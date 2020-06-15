package utils;

import org.junit.*;

import javax.mail.Message;

public class EmailUtilsTest {

    private static EmailUtils emailUtils;

    @BeforeClass
    public static void connectToEmail() {
        try {
            emailUtils = new EmailUtils("basjavamailtest@gmail.com", "JavaMailTest", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testTextContained() {
        try{
            Message email = emailUtils.getMessagesBySubject("Subject", false, 5)[0];
            Assert.assertTrue("Subject message is not in email", emailUtils.isTextInMessage(email, "BODY"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
