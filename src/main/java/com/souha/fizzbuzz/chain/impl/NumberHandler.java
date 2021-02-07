package com.souha.fizzbuzz.chain.impl;

import com.souha.fizzbuzz.chain.AbstractFizzBuzzHandler;
import com.souha.fizzbuzz.chain.IFizzBuzzEvaluator;
import com.souha.fizzbuzz.domain.FizzBuzzType;
import org.springframework.stereotype.Component;

import static com.souha.fizzbuzz.core.FizzBuzzSpecifications.isNotFizzBuzz;

/**
 * Last handler in chain of responsability.
 */
@Component
public class NumberHandler extends AbstractFizzBuzzHandler implements IFizzBuzzEvaluator {

    @Override
    protected FizzBuzzType handleRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return isNotFizzBuzz.test(number) ? FizzBuzzType.NUMBER : null;
    }
}
