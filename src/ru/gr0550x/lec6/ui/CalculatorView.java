// ui/CalculatorView.java
package ru.gr0550x.lec6.ui;

import ru.gr0550x.lec6.domain.Calculation;
import ru.gr0550x.lec6.domain.IntegrationMethod;

import java.util.List;

// Контракт между презентерами и окном
public interface CalculatorView {
    String getFormula();
    String getLowerText();
    String getUpperText();
    String getIntervalsText();
    IntegrationMethod getMethod();
    Calculation getSelected();

    void clearForm();
    void showCalculations(List<Calculation> calculations);
    void showError(String message);
}