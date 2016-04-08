package net.openhft.exceptionhandler;

/**
 * @author Frank Dietrich
 */
public class LetMeGoogleThatForYouHandler extends WebExceptionHandler {
    public static final ExceptionHandler INSTANCE = new LetMeGoogleThatForYouHandler(LoggerExceptionHandler.INSTANCE);

    public LetMeGoogleThatForYouHandler(ExceptionHandler fallBack) {
        super("LetMeGoogleThatForYou.properties", fallBack);
    }
}
