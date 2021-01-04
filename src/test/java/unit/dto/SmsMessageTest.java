package unit.dto;

import dto.SmsMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmsMessageTest {

    @Test
    public void testSmsMessageDTO(){
        String recipient = "+4512345";
        String message = "Hello World";

        SmsMessage sms = new SmsMessage(recipient, message);

        assertNotNull(sms);
        assertEquals(sms.getRecipient(), recipient);
        assertEquals(sms.getMessage(), message);
    }

    @Test
    public void testSmsMessageEqualDTO(){
        String recipient = "+4512345";
        String message = "Hello World";

        SmsMessage sms1 = new SmsMessage(recipient, message);
        SmsMessage sms2 = new SmsMessage(recipient, message);

        assertTrue(sms1.equals(sms2));
    }

    @Test
    public void testSmsMessageNotEqualDTO(){
        String recipient1 = "+4512345";
        String message1 = "Hello World";
        String recipient2 = "12345678";
        String message2 = "Hello World2";

        SmsMessage sms1 = new SmsMessage(recipient1, message1);
        SmsMessage sms2 = new SmsMessage(recipient2, message2);

        assertFalse(sms1.equals(sms2));
    }

    @Test
    public void testSmsMessageNotEqualRecipientDTO(){
        String recipient1 = "+4512345";
        String message1 = "Hello World";
        String recipient2 = "12345678";
        String message2 = "Hello World";

        SmsMessage sms1 = new SmsMessage(recipient1, message1);
        SmsMessage sms2 = new SmsMessage(recipient2, message2);

        assertFalse(sms1.equals(sms2));
    }

    @Test
    public void testSmsMessageNotEqualMessageDTO(){
        String recipient1 = "+4512345";
        String message1 = "Hello World";
        String recipient2 = "+4512345";
        String message2 = "Hello World2";

        SmsMessage sms1 = new SmsMessage(recipient1, message1);
        SmsMessage sms2 = new SmsMessage(recipient2, message2);

        assertFalse(sms1.equals(sms2));
    }

    @Test
    public void testSmsMessageNotEqualNULLDTO(){
        String recipient1 = "+4512345";
        String message1 = "Hello World";

        SmsMessage sms1 = new SmsMessage(recipient1, message1);

        assertFalse(sms1.equals(null));
    }

}
