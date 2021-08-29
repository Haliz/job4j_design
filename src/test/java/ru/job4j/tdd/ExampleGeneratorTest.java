package ru.job4j.tdd;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ExampleGeneratorTest {
    @Test
    @Ignore
    public void whenGeneratorOk() {
        Generator generator = new ExampleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String exp = "I am a Petr Arsentev, Who are you? ";
        String rsl = generator.produce(template, map);
        Assert.assertEquals(exp, rsl);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasNotKey() {
        Generator generator = new ExampleGenerator();
        String template = "I am a ${lastName}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String rsl = generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExcessKey() {
        Generator generator = new ExampleGenerator();
        String template = "I am a ${name}. ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String rsl = generator.produce(template, map);
    }
}