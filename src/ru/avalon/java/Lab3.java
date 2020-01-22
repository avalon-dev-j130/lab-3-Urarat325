package ru.avalon.java;

import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.actions.FileCreateAction;
import ru.avalon.java.actions.FileDeleteAction;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // new FileMoveAction("README2.md","README3.md").start();
//        Commands c = null;
//        try {
//            c = new Commands("cepy f1.txt f2.txt");
//        } catch (IllegalCommand ex) {
//            System.out.println("Искл:" + ex.getMessage());
//        }
//        System.out.println("c = " + c.toString());
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
//    Lab3() {
//        super(Commands.class);
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) {
        switch (command.comm) {
            case copy:
                new FileCopyAction(command.param[0],
                        command.param[1]).start();
                System.out.println("Запущена команда copy");
                break;
            case move:
                new FileMoveAction(command.param[0],
                        command.param[1]).start();
                System.out.println("Запущена команда move");
                break;
            case exit:
                close();
                break;
            case create:
                new FileCreateAction(command.param[0]).start();
                System.out.println("Запущена команда create");
                break;
            case delete:
                new FileDeleteAction(command.param[0]).start();
                System.out.println("Запущена команда delete");
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
