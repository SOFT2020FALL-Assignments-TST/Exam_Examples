package unit.servicelayer.notifications;

import dto.SmsMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.notifications.SmsService;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SmsMessageTest {

    // SUT (System Under Test)
    private SmsService smsServiceMock;

    @BeforeAll
    public void beforeAll(){
        smsServiceMock = mock(SmsService.class);
    }

    @Test
    public void mustSendSmsWhenRecipientStartsWithDKCountryCode() {
        // Arrange
        var recipient = "+4512345678";
        var message = "Hello World!";
        SmsMessage sms = new SmsMessage(recipient, message);

        // Act
        smsServiceMock.sendSms(sms);

        // Assert
        verify(smsServiceMock).sendSms(argThat(x -> x.getRecipient().startsWith("+45")));
    }

}
