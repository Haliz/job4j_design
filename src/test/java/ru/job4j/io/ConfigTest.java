package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "app1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "app2.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.password"),
                is("password")
        );
    }

    @Test (expected = IllegalArgumentException.class)
    public void wheNoValue() {
        String path = "app3.properties";
        Config config = new Config(path);
        config.load();
    }
}
