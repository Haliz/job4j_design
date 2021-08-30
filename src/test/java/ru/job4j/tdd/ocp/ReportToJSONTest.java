package ru.job4j.tdd.ocp;

import com.google.gson.GsonBuilder;
import org.junit.Test;
import ru.job4j.tdd.srp.Employee;
import ru.job4j.tdd.srp.MemStore;
import ru.job4j.tdd.srp.Report;
import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportToJSONTest {

    @Test
    public void whenReportJSONT() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Василий", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportToJSON(store);
        StringBuilder expect = new StringBuilder();
        var gson = new GsonBuilder().create();
        expect.append("[")
                .append(gson.toJson(worker1))
                .append(",")
                .append(gson.toJson(worker2))
                .append("]");


        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}