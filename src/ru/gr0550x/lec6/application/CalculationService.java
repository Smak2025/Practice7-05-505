package ru.gr0550x.lec6.application;

import ru.gr0550x.lec6.domain.Calculation;
import ru.gr0550x.lec6.domain.CalculationRepository;
import ru.gr0550x.lec6.domain.FormulaParser;
import ru.gr0550x.lec6.domain.IntegrationMethod;
import ru.gr0550x.lec6.domain.Integrator;

import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class CalculationService {
    private final CalculationRepository repository;
    private final FormulaParser parser;

    public CalculationService(CalculationRepository repository, FormulaParser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    // Разбирает формулу, вычисляет интеграл и сохраняет расчёт
    public Calculation calculate(String formula, double lower, double upper,
                                 int intervals, IntegrationMethod method) {
        DoubleUnaryOperator f = parser.parse(formula);
        double result = Integrator.integrate(f, lower, upper, intervals, method);
        Calculation calculation = new Calculation(formula, lower, upper, intervals, method, result);
        repository.save(calculation);
        return calculation;
    }

    public void delete(Calculation calculation) {
        repository.delete(calculation);
    }

    public List<Calculation> getAll() {
        return repository.findAll();
    }
}