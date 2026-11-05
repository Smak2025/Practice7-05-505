// ui/CalculationListPresenter.java
package ru.gr0550x.lec6.ui;

import ru.gr0550x.lec6.application.CalculationService;
import ru.gr0550x.lec6.application.CommandHistory;
import ru.gr0550x.lec6.application.DeleteCommand;
import ru.gr0550x.lec6.domain.Calculation;

public class CalculationListPresenter {
    private final CalculatorView view;
    private final CalculationService service;
    private final CommandHistory history;

    public CalculationListPresenter(
            CalculatorView view,
            CalculationService service,
            CommandHistory history
    ) {
        this.view = view;
        this.service = service;
        this.history = history;
    }

    public void start() {
        refresh();
    }

    public void refresh() {
        view.showCalculations(service.getAll());
    }

    public void deleteSelected() {
        Calculation calculation = view.getSelected();
        if (calculation == null) {
            view.showError("Выберите расчёт в списке");
            return;
        }
        //service.delete(calculation);
        history.execute(new DeleteCommand(service, calculation));
        refresh();
    }
}