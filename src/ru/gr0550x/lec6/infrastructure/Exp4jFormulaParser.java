// infrastructure/Exp4jFormulaParser.java
package ru.gr0550x.lec6.infrastructure;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import ru.gr0550x.lec6.domain.FormulaParser;
import ru.gr0550x.lec6.domain.FunctionDefinition;

import java.util.function.DoubleUnaryOperator;

// Разбор формулы выполняет библиотека exp4j; переменная называется x
public class Exp4jFormulaParser implements FormulaParser {

    @Override
    public DoubleUnaryOperator parse(FunctionDefinition definition) {
        Expression expression = buildExpression(definition);
        return x -> evaluateAt(
                expression,
                definition.getVariable(),
                x
        ); // функция: подставляем x и вычисляем
    }

    private Expression buildExpression(FunctionDefinition definition) {
        try {
            var builder = new ExpressionBuilder(definition.getFormula());
            builder.variable(definition.getVariable());
            builder.variables(definition.getParameters().keySet());
            var expression = builder.build();
            for (var params: definition.getParameters().entrySet()){
                expression.setVariable(params.getKey(), params.getValue());
            }
            return expression;
        } catch (RuntimeException ex) {
            // Ошибки библиотеки переводим в IllegalArgumentException, который показывает окно
            throw new IllegalArgumentException("Не удалось разобрать формулу: " + ex.getMessage(), ex);
        }
    }

    private double evaluateAt(
            Expression expression,
            String variable,
            double value
    ) {
        try {
            return expression.setVariable(variable, value).evaluate();
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException(
                    "Не удалось вычислить формулу при "
                    + variable
                    + " = "
                    + value, ex);
        }
    }
}