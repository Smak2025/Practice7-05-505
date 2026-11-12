package ru.gr0550x.lec6.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionDefinition {
    private final String formula;
    private final String variable;
    private final Map<String, Double> parameters;

    private FunctionDefinition(Builder builder){
        this.formula = builder.formula;
        this.variable = builder.variable;
        this.parameters = Collections.unmodifiableMap(
                new LinkedHashMap<>(builder.parameters)
        );
    }

    public String getFormula() {
        return formula;
    }

    public String getVariable() {
        return variable;
    }

    public Map<String, Double> getParameters() {
        return parameters;
    }

    public static Builder builder(String formula){
        return new Builder(formula);
    }

    public static class Builder{
        private final String formula;

        private String variable = "x";
        private final Map<String, Double> parameters = new LinkedHashMap<>();
        private Builder(String formula){
            this.formula = formula;
        }

        public Builder variable(String variable){
            this.variable = variable;
            return this;
        }

        public Builder parameter(String name, double value){
            parameters.put(name, value);
            return this;
        }

        public FunctionDefinition build(){
            return new FunctionDefinition(this);
        }
    }
}
