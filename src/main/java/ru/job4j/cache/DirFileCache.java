package ru.job4j.cache;

import java.io.*;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {

    public final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        File pathToFile = new File(cachingDir + "\\" + key);
        String rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader(pathToFile))) {
        rsl = in.lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл: " + pathToFile + " не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rsl;
    }
}
