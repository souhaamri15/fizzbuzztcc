package com.souha.fizzbuzz.chain;

import com.souha.fizzbuzz.domain.FizzBuzzType;

public abstract class AbstractFizzBuzzHandler {

    protected AbstractFizzBuzzHandler nextHandler;

    protected abstract FizzBuzzType handleRequest(int number);

    public FizzBuzzType receiveRequest(int number) {
        FizzBuzzType fizzBuzzType = handleRequest(number);
        return (fizzBuzzType != null) ? fizzBuzzType : nextHandler.receiveRequest(number);
    }

    public void setNextHandler(AbstractFizzBuzzHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
