package source;

import com.clouway.Endpointers.Endpoint;
import com.clouway.Endpointers.EndpointFilter;
import com.clouway.Endpointers.StartsWithKeyword;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JMock.class)
public class Testing {
    private Mockery context = new JUnit4Mockery();
    private final Endpoint endpoint = context.mock(Endpoint.class);
    private final String gitUrl = "https://github.com/clouway/courses/blob/master/docs/java/Testing-with-mocks.md";

    @Test
    public void endPointFilterFilters() {
        context.checking(new Expectations(){{
            oneOf(endpoint).matches(gitUrl);
            will(returnValue(true));
        }});

        assertTrue(new EndpointFilter(endpoint).shouldFilter(gitUrl));
    }

    @Test
    public void endPointFilterDoesNotFilter() {
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("what");
            will(returnValue(false));
        }});
        assertFalse(new EndpointFilter(endpoint).shouldFilter("what"));
    }

    @Test
    public void startsWithKeywordTrue() {
        assertTrue(new EndpointFilter(new StartsWithKeyword("clo")).shouldFilter(gitUrl));
    }

    @Test
    public void startsWithKeywordFalse() {
        assertFalse(new EndpointFilter(new StartsWithKeyword("https")).shouldFilter(gitUrl));
    }

    //    @Test
//    public void babySteps() {
//        context.checking(new Expectations() {{
//            oneOf(endpoint).matches("asd");
//            will(returnValue(true));
//
//            }});
//        assertTrue(new EndpointFilter(endpoint).shouldFilter("asd"));
//
//    }
}
