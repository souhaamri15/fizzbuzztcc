package com.souha.fizzbuzz.chain.impl;

import com.souha.fizzbuzz.chain.AbstractFizzBuzzHandler;
import com.souha.fizzbuzz.chain.IFizzBuzzEvaluator;
import com.souha.fizzbuzz.domain.FizzBuzzType;
import org.springframework.stereotype.Component;

import static com.souha.fizzbuzz.core.FizzBuzzSpecifications.isFizzBuzz;

/**
 * Third handler in chain of responsability.
 */
@Component
public class FizzBuzzHandler extends AbstractFizzBuzzHandler implements IFizzBuzzEvaluator {

    @Override
    protected FizzBuzzType handleRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return isFizzBuzz.test(number) ? FizzBuzzType.FIZZBUZZ : null;
    }
}