import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class HW5 {

    static private int precedenceCalc(char c) {
        switch (c) {
            case '+': return 1;
            case '-': return 1;
            case '/': return 2;
            case '*': return 2;
            case '^': return 3;
        }
        return 0;
    }
    static private String infixToPostfix(Stack stack, String operation) {
        String finalOperation = "";
        for(int i = 0; i < operation.length(); i++) {
            if(((operation.charAt(i) != '+') && (operation.charAt(i) != '-')
                    && (operation.charAt(i) != '*') && (operation.charAt(i) != '/') && (operation.charAt(i) != '/')
                    && (operation.charAt(i) != '^')) && (operation.charAt(i) != '(') && (operation.charAt(i) != ')') ){

                finalOperation += operation.charAt(i);
            }
            else if ((operation.charAt(i) != '(') && (operation.charAt(i) != ')')){
                if( (stack.isEmpty()) || (precedenceCalc(operation.charAt(i)) > precedenceCalc(stack.top().charAt(0))) ){
                    stack.add(String.valueOf(operation.charAt(i)));
                }
                else {
                    while (!stack.isEmpty() && (precedenceCalc(operation.charAt(i)) <= precedenceCalc(stack.top().charAt(0))) ) {
                        //System.out.println(stack.pop());
                        finalOperation += stack.pop();
                       // System.out.println("test");
                    }
                    stack.add(String.valueOf(operation.charAt(i)));
                  //  System.out.println("test2");
                }
            }
            if ( operation.charAt(i) == '(') {
                stack.add("(");
            }
            else if ( operation.charAt(i) == ')' ) {
                while (!stack.isEmpty() && (stack.top() != "(")) {

                    //System.out.println(stack.pop());
                    finalOperation += stack.pop();
                   // if(stack.top() == "(" ) {
                      //  stack.pop();
                   // }
                }
            }
        }
        while (!stack.isEmpty() ) {
            //System.out.println(stack.pop());
            if (stack.top() == "(" || stack.top() == ")") {
                stack.pop();
            }
            else {
                finalOperation += stack.pop();
            }
        }
        return finalOperation;
    }

    static private String performOperation(String c1, String c2, char operation) {
        DecimalFormat df = new DecimalFormat("0.0");
        double operand1 = Double.parseDouble(c1);
        double operand2 = Double.parseDouble(c2);
        switch (operation) {
            case '+': return df.format(operand1 + operand2);
            case '-': return df.format(operand2 - operand1);
            case '*': return df.format(operand1*operand2);
            case '/': return  df.format(operand2/operand1);
            case '^': return df.format(Math.pow(operand2, operand1));
        }
        return "";
    }

    static private String evaluatePostfix(Stack stack, String operation) {
        try {
            int countOperands = 0;
            int countOperators = 0;
            for (int i = 0; i < operation.length(); i++) {
                if (((operation.charAt(i) != '+') && (operation.charAt(i) != '-')
                        && (operation.charAt(i) != '*') && (operation.charAt(i) != '/') && (operation.charAt(i) != '/') && (operation.charAt(i) != '^'))) {
                    stack.add(String.valueOf(operation.charAt(i)));
                    countOperands++;
                }
                if (((operation.charAt(i) == '+') || (operation.charAt(i) == '-')
                        || (operation.charAt(i) == '*') || (operation.charAt(i) == '/') || (operation.charAt(i) == '/') || (operation.charAt(i) == '^'))) {
                    String c1 = stack.pop();
                    String c2 = stack.pop();
                    countOperators++;
                    String result = "";
                    result = performOperation(c1, c2, operation.charAt(i));
                    int num = 0;
                    stack.add(result);
                }

            }
            if (countOperands != countOperators + 1) {
                throw new EmptyStackException();
            }

        }
        catch (EmptyStackException e) {
            return "nv";
        }

        return stack.pop();
    }

    public static void main(String args[]) {
        try {
            PrintWriter out;
            switch ("2") {
                case "2":
                    out = new PrintWriter("test.txt");
                    Stack stack1 = new Stack();
                    out.println(infixToPostfix(stack1, "2-3*4+5/6"));
                    out.close();
                    break;
                case "3":
                    out = new PrintWriter(args[2]);
                    Stack stack3 = new Stack();
                    out.println(evaluatePostfix(stack3, args[1]));
                    out.close();
                    break;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
