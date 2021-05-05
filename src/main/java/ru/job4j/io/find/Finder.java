package ru.job4j.io.find;

import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;

public class Finder {
    private static final Map<String, String> VALUES = new HashMap<>();

    public static void validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Incorrect arguments \n"
                    + "Введите аргументы поиска, например: -d=c:/ -n=.txt -t=mask -o=log.txt \n"
                    + "-d - директория, в которой начинать поиск.\n"
                    + "-n - имя файла (полностью), маска.\n"
                    + "-t - тип поиска: mask - искать по маске, name - по полному совпадение имени.\n"
                    + "-o - результат записать в файл."
            );
        }
        for (String elem : args) {
            String[] splitElem = elem.substring(1).split("=");
            if (splitElem.length != 2) {
                throw new IllegalArgumentException(String.format("Incorrect argument -%s", splitElem));
            }
            VALUES.put(splitElem[0], splitElem[1]);
        }
        String[] arrKeys = {"d", "n", "t", "o" };
        for (String key : arrKeys) {
            if (!VALUES.containsKey(key)) {
                throw new IllegalArgumentException(String.format("Incorrect argument -%s", key));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Finder.validate(args);
        Path start = Paths.get(VALUES.get("d"));
        List<Path> found = search(start, selectingCondition(VALUES.get("t")));
        writingToFile(found);
    }

    public static Predicate<Path> selectingCondition(String t) {
        Map<String, Predicate<Path>> conditionMap = new HashMap<>();
        conditionMap.put("mask", p -> p.toFile().getName().contains((VALUES.get("n"))));
        conditionMap.put("name", p -> p.toFile().getName().equals((VALUES.get("n"))));
        if (!conditionMap.containsKey(t)) {
            throw new IllegalArgumentException("Incorrect argument -t");
        }
        return conditionMap.get(t);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void writingToFile(List<Path> paths) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(VALUES.get("o")))) {
            if (paths.isEmpty()) {
                writer.write("File(s) NOT FOUND!");
            }
            for (Path path : paths) {
                writer.write(path.toString());
                writer.newLine();
            }
            System.out.println("DONE!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
