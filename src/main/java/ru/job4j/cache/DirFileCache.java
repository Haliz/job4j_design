package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    public final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path pathToFile = Path.of(cachingDir + "\\" + key);
        String rsl = null;
        try {
        rsl = Files.readString(pathToFile);
        } catch (IOException e) {
            System.out.println("Проблема с загрузкой файла: " + pathToFile);
        }
        return rsl;
    }
}
