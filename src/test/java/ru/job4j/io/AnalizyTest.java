package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoPeriod() throws IOException {
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01-10:59:01" + "11:01:02-11:02:02"));
    }
}


