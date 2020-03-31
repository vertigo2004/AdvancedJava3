package lms.itcluster.conference.assistant.exception.handler;

import lms.itcluster.conference.assistant.exception.NoSuchConferenceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchConferenceException.class)
    public String noSuchConfExceptionHandler() {

        return "conferenceError";
    }

}
