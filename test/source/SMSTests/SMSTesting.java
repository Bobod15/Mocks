package source.SMSTests;

import com.clouway.Exceptions.InvalidSMSInput;
import com.clouway.SMSPackage.Person;
import com.clouway.SMSPackage.SMS;
import com.clouway.SMSPackage.SMSReceiver;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SMSTesting {
    private final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Nam ullamcorper elit et tortor finibus, vitae semper purus amet. ";

    private Mockery context = new JUnit4Mockery();
    private SMSReceiver receiver = context.mock(SMSReceiver.class);


    @Test(expected = InvalidSMSInput.class)
    public void sendFailureDueIncorrectTitle() throws InvalidSMSInput {
        new SMS().send(receiver,null,"a");
    }

    @Test(expected = InvalidSMSInput.class)
    public void sendFailureDueIncorrectMessage() throws InvalidSMSInput {
        new SMS().send(receiver,"this is sms","");
    }

    @Test(expected = InvalidSMSInput.class)
    public void sendFailureDueLongMessage() throws InvalidSMSInput {
        new SMS().send(receiver,"lorem ipsum",lorem);
    }

    @Test
    public void SMSContentIsSent() throws InvalidSMSInput {
        List<String> SMSContent = new LinkedList<>();
        SMSContent.add("New SMS Title");
        SMSContent.add("Very moderate message");

        assertEquals(SMSContent,new SMS().send(receiver,SMSContent.get(0),SMSContent.get(1)));
    }

    @Test
    public void SMSIsSent() throws InvalidSMSInput {
        context.checking(new Expectations(){{
            oneOf(receiver).receiveSMS("title","message");
        }});

        new SMS().send(receiver,"title","message");
    }
    /*
        @Test
    public void endPointFilterDoesNotFilter() {
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("what");
            will(returnValue(false));
        }});
        assertFalse(new EndpointFilter(endpoint).shouldFilter("what"));
    }
     */
}
