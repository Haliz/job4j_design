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
    private boolean isAnswer = true;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String question = null;
        getAnswers();
        while (!Objects.equals(question, OUT)) {
            System.out.println("Введите фразу:");
            question = input.nextLine();
            log.add("USER: " + question);
            if (Objects.equals(question, OUT)) {
                continue;
            }
            if (Objects.equals(question, STOP)) {
                isAnswer = false;
                continue;
            }
            if (Objects.equals(question, CONTINUE)) {
                isAnswer = true;
            }
            if (isAnswer) {
                int answer = new Random().nextInt(answers.size() - 1);
                log.add("БOT: " + answers.get(answer));
                System.out.println(answers.get(answer));
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String line : log) {
                writer.write(line + '\n');
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
        ConsoleChat cc = new ConsoleChat("ChatLog.txt", "Answers.txt");
        cc.run();
    }
}
