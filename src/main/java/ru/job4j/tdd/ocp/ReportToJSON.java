package ru.job4j.tdd.ocp;

import com.google.gson.GsonBuilder;
import ru.job4j.tdd.srp.Employee;
import ru.job4j.tdd.srp.Report;
import ru.job4j.tdd.srp.Store;
import java.util.function.Predicate;

public class ReportToJSON implements Report {
    private Store store;

    public ReportToJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var gson = new GsonBuilder().create();
        return gson.toJson(store.findBy(filter));
    }
}
