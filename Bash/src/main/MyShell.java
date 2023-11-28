package main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import commands.Cd;
import commands.Ls;
import commands.Mkdir;
import commands.Rm;

public class MyShell {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("MyShell (Type 'exit' to exit)");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            processCommand(input);
        }

        System.out.println("Exiting MyShell...");
        scanner.close();
    }

    private static void processCommand(String input) throws IOException {
        String[] commands = input.split(" ");
        
        String command = commands[0];
        String currentDirectory = System.getProperty("user.dir");
        

        switch (command) {
            case "ls":
                Ls.ls(currentDirectory);
                break;

            case "cd":
                if (commands.length > 1) {
                    Cd.cd(commands[1], currentDirectory);
                } else {
                    System.out.println("cd: missing argument");
                }
                break;

            case "mkdir":
                if (commands.length > 1) {
                    Mkdir.mkdir(commands[1]);
                } else {
                    System.out.println("mkdir: missing argument");
                }
                break;

            case "rm":
            System.out.println("in rm");
                if (commands.length > 1) {
                    boolean recursive = Arrays.asList(commands).contains("-r");
                    Rm.rm(commands[1], recursive, currentDirectory);
                } else {
                    System.out.println("rm: missing argument");
                }
                break;

            default:
                System.out.println("Unknown command");
        }
    }

}
