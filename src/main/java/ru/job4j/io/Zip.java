package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
           for (Path path : sources) {
               File file = path.toFile();
               zip.putNextEntry(new ZipEntry(file.getPath()));
               try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                   zip.write(out.readAllBytes());
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Incorrect argument");
        }
        ArgsName param = ArgsName.of(args);
        File target = new File(param.get("o"));
        Path start = Paths.get(param.get("d"));
        String exclude = param.get("e");
        new Zip().packFiles(Search.search(start, (p -> !(p.toFile().getName().endsWith(exclude)))), target);
    }
}
