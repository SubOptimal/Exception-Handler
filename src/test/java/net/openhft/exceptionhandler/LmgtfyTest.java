package net.openhft.exceptionhandler;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * @author Frank Dietrich
 */
public class LmgtfyTest {

    @Test
    public void testDemo() {
        ExceptionHandler handler = new DebugExceptionHandler(
                LoggerExceptionHandler.INSTANCE, 
                LetMeGoogleThatForYouHandler.INSTANCE
        );
        try {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
            format.parse("fortytwo");
            assertTrue(true);
        } catch (ParseException ex) {
            handler.onException(toAnonymizedMessage(ex), ex);
            fail(ex.getMessage());
        }
    }

    /**
     * Removes the <code>source</code> part of the exception message. To ensure
     * that no confidential information is revealed to the search engine.
     *
     * @param e the exception
     * @return the exception message with the <code>source</code> part stripped
     */
    String toAnonymizedMessage(ParseException e) {
        // example to identify the pattern
        int indexColon = e.getMessage().indexOf(':');
        // if the pattern is not found an empty string is returned
        return indexColon < 0 ? "" : e.getMessage().substring(0, indexColon);
    }
}
