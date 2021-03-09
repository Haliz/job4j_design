package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenTwoPeriod() throws IOException {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "target.txt");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("target.txt"))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01-10:59:01" + "11:01:02-11:02:02"));
    }
}


