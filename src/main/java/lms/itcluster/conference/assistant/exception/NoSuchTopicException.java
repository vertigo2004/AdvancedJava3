package lms.itcluster.conference.assistant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Topic")
public class NoSuchTopicException extends NoSuchElementException {
}
