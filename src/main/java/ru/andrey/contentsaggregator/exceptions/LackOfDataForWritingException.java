package ru.andrey.contentsaggregator.exceptions;

public class LackOfDataForWritingException extends RuntimeException{
    public LackOfDataForWritingException(String message) {
        super(message);
    }
}
