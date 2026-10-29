// Main.java
import ru.gr0550x.lec6.application.CalculationService;
import ru.gr0550x.lec6.infrastructure.Exp4jFormulaParser;
import ru.gr0550x.lec6.infrastructure.InMemoryCalculationRepository;
import ru.gr0550x.lec6.ui.CalculatorWindow;

void main() {
    // Окно создаётся в потоке диспетчеризации событий Swing
    CalculationService service = new CalculationService(
            new InMemoryCalculationRepository(), new Exp4jFormulaParser()
    );
    new CalculatorWindow(service).setVisible(true);
}