import ru.gr0550x.lec6.application.CalculationService;
import ru.gr0550x.lec6.application.CommandHistory;
import ru.gr0550x.lec6.infrastructure.Exp4jFormulaParser;
import ru.gr0550x.lec6.infrastructure.InMemoryCalculationRepository;
import ru.gr0550x.lec6.ui.CalculatorWindow;

void main() {
    CalculationService service = new CalculationService(
            new InMemoryCalculationRepository(),
            new Exp4jFormulaParser()
    );
    CommandHistory history = new CommandHistory();
    new CalculatorWindow(service, history).setVisible(true);
}