package ru.gr0550x.lec6.application;

import ru.gr0550x.lec6.domain.Calculation;
import ru.gr0550x.lec6.domain.MethodRealisation;

public class CalculateCommand implements Command {
    private final CalculationService service;
    private final String formula;
    private final double lower;
    private final double upper;
    private final int intervals;
    private final MethodRealisation method;
    private Calculation calculation;
    public CalculateCommand(
            CalculationService service,
            String formula,
            double lower,
            double upper,
            int intervals,
            MethodRealisation method
    ){
        this.service = service;
        this.formula = formula;
        this.lower = lower;
        this.upper = upper;
        this.intervals = intervals;
        this.method = method;
    }

    @Override
    public void execute() {
        calculation = service.calculate(formula, lower, upper, intervals, method);
    }

    @Override
    public void undo() {
        service.delete(calculation);
    }
}
