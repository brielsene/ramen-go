package br.com.ramen_go.infra.exceptions;

public class NoSuchElementOrderException extends RuntimeException{

    public NoSuchElementOrderException(String msg){
        super(msg);
    }
}
