package ru.gr0550x.lec6.domain;

import java.util.function.DoubleUnaryOperator;

public class TimedIntegrationMethod implements IntegrationMethod{
    private final IntegrationMethod inner;
    private long elapsed;

    public TimedIntegrationMethod(IntegrationMethod inner){
        this.inner = inner;
    }

    @Override
    public double calculate(DoubleUnaryOperator f, double a, double b, int n) {
        var start = System.nanoTime();
        double result = inner.calculate(f, a, b, n);
        var end = System.nanoTime();
        elapsed = end - start;
        return result;
    }

    public long getElapsed() {
        return elapsed;
    }
}
