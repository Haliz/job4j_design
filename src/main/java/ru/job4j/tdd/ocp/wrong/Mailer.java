package ru.job4j.tdd.ocp.wrong;
 /**Класс Mailer не закрыт для модификации.
 При добавлении нового логера например в базу данных,
придется изменять сам класс Mailer.*/

public class Mailer {
    private final Logger logger;

    public Mailer() {
        logger = new Logger();
    }

    public void sendMessage(String message) {
        logger.log(String.format("Отправлено '{0}'", message));
    }
}
 class Logger {
    public void log(String logText) {
    }
}
