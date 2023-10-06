package Lab6.code;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        Scanner in = new Scanner(System.in);
        MyStackL stack = new MyStackL();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t))
                stack.push(t);
            else {
                if (t.equals("-")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a - b));
                }else if (t.equals("+")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a + b));
                }else if (t.equals("*")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a * b));
                }else if (t.equals("/")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a / b));
                }
            }
        }
        in.close();
        
        return Double.parseDouble(stack.pop());
    }
}