package lesson1;

import bsh.Interpreter;

import java.util.Scanner;

/**
 * Реализовать простой калькулятор
 */
public class ThirdTask {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        var expr = scanner.nextLine();
        try {
            Interpreter interpreter = new Interpreter();
            interpreter.eval("result = " + expr);
            System.out.println(interpreter.get("result"));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
