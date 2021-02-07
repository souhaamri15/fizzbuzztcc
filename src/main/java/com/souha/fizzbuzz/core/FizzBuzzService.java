package com.souha.fizzbuzz.core;

import com.souha.fizzbuzz.chain.AbstractFizzBuzzHandler;
import com.souha.fizzbuzz.chain.impl.BuzzHandler;
import com.souha.fizzbuzz.chain.impl.FizzBuzzHandler;
import com.souha.fizzbuzz.chain.impl.FizzHandler;
import com.souha.fizzbuzz.chain.impl.NumberHandler;
import com.souha.fizzbuzz.domain.FizzBuzzType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    AbstractFizzBuzzHandler handlerChain;

    public FizzBuzzService(
            @Autowired FizzHandler fizzHandler,
            @Autowired BuzzHandler buzzHandler,
            @Autowired FizzBuzzHandler fizzBuzzHandler,
            @Autowired NumberHandler numberHandler
    ) {
        fizzHandler.setNextHandler(buzzHandler);
        buzzHandler.setNextHandler(fizzBuzzHandler);
        fizzBuzzHandler.setNextHandler(numberHandler);
        this.handlerChain = fizzHandler;
    }

    public FizzBuzzType evalNumber(int number) {
        return handlerChain.receiveRequest(number);
    }
}
