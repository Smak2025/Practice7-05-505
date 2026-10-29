package ru.gr0550x.lec6.domain;

import java.util.function.DoubleUnaryOperator;

public interface IntegrationMethod {
    double calculate(DoubleUnaryOperator f, double a, double b, int n);

}