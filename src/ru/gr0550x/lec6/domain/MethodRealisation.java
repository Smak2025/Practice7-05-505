package ru.gr0550x.lec6.domain;

public record MethodRealisation(String name, IntegrationMethod method) {
    @Override
    public String toString() { return name; }
}
