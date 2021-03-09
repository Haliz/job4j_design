package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            String line;
            boolean serverIsStopped = false;
            while ((line = read.readLine()) != null) {
                if (!(line.isEmpty())) {
                    String[] splitLine = line.split(" ");
                    if (!serverIsStopped && (splitLine[0].equals("400") || splitLine[0].equals("500"))) {
                        writer.print(splitLine[1] + "-");
                        serverIsStopped = true;
                    } else if (serverIsStopped && (splitLine[0].equals("200") || splitLine[0].equals("300"))) {
                        writer.println(splitLine[1]);
                        serverIsStopped = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
