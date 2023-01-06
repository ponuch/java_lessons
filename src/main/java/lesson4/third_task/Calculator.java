package lesson4.third_task;

import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        LinkedList<Oper> opers = new LinkedList<>();
        Oper currentOperation = null;
        System.out.println("Supported operations: \n" +
                "1) solve - solve current operation \n" +
                "2) undo - erase current and make current previous operation \n" +
                "3) solvep - solve operation after undo \n" +
                "4) exit - stop this program");
        while(true) {
            String command;
            double num1;
            double num2;
            double ans;
            char op;
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter command: ");
            command = reader.nextLine();
            switch (command) {
                //solve previous
                case "solvep":
                    ans = solve(currentOperation);
                    System.out.println(currentOperation.num1() + " " + currentOperation.op() + " " + currentOperation.num2() + " = " + ans);
                    continue;
                case "solve":
                    break;
                case "undo":
                    System.out.println("Undo operation");
                    opers.removeLast();
                    currentOperation = opers.peekLast();
                    System.out.println(String.format("Current operation is %s", currentOperation));
                    continue;
                case "exit":
                    return;
            }
            System.out.println("Enter two numbers: ");
            num1 = reader.nextDouble();
            num2 = reader.nextDouble();
            System.out.println("\nEnter an operator (+, -, *, /): ");
            op = reader.next().charAt(0);
            final var operation = new Oper(num1, num2, op);
            ans = solve(operation);
            opers.add(operation);
            System.out.println("The result is given as follows:\n");
            System.out.println(operation.num1() + " " + operation.op() + " " + operation.num2() + " = " + ans);
        }
    }

    private static double solve (Oper oper) {
        switch(oper.op()) {
            case '+': return oper.num1() + oper.num2();
            case '-': return oper.num1() - oper.num2();
            case '*': return oper.num1() * oper.num2();
            case '/': return oper.num1() / oper.num2();
            default:  System.out.printf("Error! Enter correct operator");
                return 0.0;
        }
    }
}

record Oper (Double num1, Double num2, Character op){}
