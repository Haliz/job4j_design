package ru.job4j.tdd.ocp;

import org.junit.Test;
import ru.job4j.tdd.srp.Employee;
import ru.job4j.tdd.srp.MemStore;
import ru.job4j.tdd.srp.Report;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportToXMLTest {

    @Test
    public void whenReportXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Василий", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportToXML(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(dateFormat.format(worker1.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(dateFormat.format(worker1.getHired().getTime())).append("</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100.0</salary>\n")
                .append("    </employee>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(dateFormat.format(worker1.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(dateFormat.format(worker1.getHired().getTime())).append("</hired>\n")
                .append("        <name>Василий</name>\n")
                .append("        <salary>200.0</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}