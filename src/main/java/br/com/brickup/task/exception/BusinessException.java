package br.com.brickup.task.exception;

public class BusinessException extends CustomServiceException {

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

