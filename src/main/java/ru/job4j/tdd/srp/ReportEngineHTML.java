package ru.job4j.tdd.srp;

import java.util.function.Predicate;

public class ReportEngineHTML implements Report {

    private Store store;

    public ReportEngineHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h1>Name; Hired; Fired; Salary;</h1>")
                .append(System.lineSeparator())
                .append("<p>");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        text.append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
