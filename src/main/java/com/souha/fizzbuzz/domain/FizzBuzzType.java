package com.souha.fizzbuzz.domain;

public enum FizzBuzzType {
    NUMBER, BUZZ, FIZZBUZZ, FIZZ;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
