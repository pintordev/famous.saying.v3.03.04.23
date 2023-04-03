package application.sytem.controller;

import application.Container;

public class SystemController {

    public void init() {
        System.out.println("== Famous Saying Application ==");
        System.out.println("1. register");
        System.out.println("2. list");
        System.out.println("3. delete");
        System.out.println("4. modify");
        System.out.println("0. terminate");
    }

    public String getCommand() {
        System.out.println("=".repeat(31));
        System.out.printf("Command: ");
        return Container.getScanner().nextLine().trim().toLowerCase();
    }

    public void terminate() {
        System.out.println("=".repeat(31));
        System.out.println("Application has been terminated.");
    }

    public void help() {
        System.out.println("=".repeat(31));
        System.out.println("1. register");
        System.out.println("2. list");
        System.out.println("3. delete");
        System.out.println("4. modify");
        System.out.println("0. terminate");
    }

    public void error() {
        System.out.println("Please enter the valid command. If you want to know about commands, then enter \"help\".");
    }
}
