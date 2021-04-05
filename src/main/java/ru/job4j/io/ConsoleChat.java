package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private List<String> answers;
    private static boolean isAnswer = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run(Map condition) {
        List<String> log = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String question = null;
        getAnswers();
        boolean run = true;
        while (run) {
            System.out.println("Введите фразу:");
            question = input.nextLine();
            log.add("USER: " + question);
            Conditions action = (Conditions) condition.get(question);
            if (action != null) {
                run = action.execute();
            }
            if (isAnswer) {
                int answer = new Random().nextInt(answers.size() - 1);
                log.add("БOT: " + answers.get(answer));
                System.out.println(answers.get(answer));
            }
        }
        writeLog(log);
    }

    public void writeLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String line : log) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswers() {
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("cp1251")))) {
            answers = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map mapConditions = new HashMap();
        mapConditions.put("закончить", new Out());
        mapConditions.put("стоп", new Stop());
        mapConditions.put("продолжить", new Continue());
        ConsoleChat cc = new ConsoleChat("ChatLog.txt", "Answers.txt");
        cc.run(mapConditions);
    }

    public static void setIsAnswer(boolean isAnswer) {
        ConsoleChat.isAnswer = isAnswer;
    }
}
