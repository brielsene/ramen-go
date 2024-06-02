package br.com.ramen_go.infra.exceptions;

public class ErrorApiKeyException extends RuntimeException{
    public ErrorApiKeyException(String msg){
        super(msg);

    }
}
