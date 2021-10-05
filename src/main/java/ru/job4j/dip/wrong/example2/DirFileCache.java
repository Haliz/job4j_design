package ru.job4j.dip.wrong.example2;

import ru.job4j.cache.AbstractCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Здесь есть прямая зависимость  логгирования от реализации,
 * в данном случае оно напрямую зависит от консольного вывода.
 * */

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
