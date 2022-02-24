package edu.pdx.cs410J.oneteam;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");

    init(args[0]);

    System.exit(1);
  }

  public static int init(String arg) {
    String[] tokens = arg.split(" ");

    Stack<Integer> stack = new Stack<>();

    try {
      for (String current : tokens) {
        int a,b;

        switch (current) {
          case "*":
            // TODO: check if the stack is too small - done!
            a = stack.pop();
            b = stack.pop();
            System.out.println(stack);
            stack.push(a*b);
            break;

          case "+":
            a = stack.pop();
            b = stack.pop();
            stack.push(b+a);
            break;

          case "-":
            a = stack.pop();
            b = stack.pop();
            stack.push(b-a);
            break;

          case "/":
            a = stack.pop();
            b = stack.pop();
            stack.push(b/a);
            break;

          case "SQRT":
            a = stack.pop();
            stack.push((int) Math.round(Math.sqrt((float) a)));
            break;

          case "MAX":
            int result = stack.pop();
            while (!stack.empty()) {
              int top = stack.pop();
              result = Math.max(result, top);
            }
            stack.push(result);
            break;

          default:
            try {
              stack.push(Integer.parseInt(current));
            } catch (Exception ex) {
              System.err.println("You done messed up A-A-Ron!: " + ex.getMessage());
            }
        }
      }

      return stack.pop();
    } catch (EmptyStackException ex) {
      System.err.println("stack shouldn't be empty but it is");
      System.exit(1);
      return 0; // not actually possible
    } catch(ArithmeticException ex) {
      System.err.println("cannot divide by zero!");
      System.exit(1);
      return 0;
    }
  }
}

/*
Pseudocode:
when encountering argument:
arg1 = pop
arg2 = pop
calculation = operation(arg1, arg2)
push(calculation)

when encountering number:
push(number)

MAX operation gets max of everything on the stack?
 */