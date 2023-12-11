package BalancedParenthesis;

/**
 * @author Dhruv
 * @project Day14
 */
public class BalancedParentheses {

    public static void main(String[] args) {
        String expression = "(5+6)*(7+8)/(4+3)*(5+6)*(7+8)/(4+3)";
        boolean isBalanced = checkBalancedParentheses(expression);

        if (isBalanced) {
            System.out.println("True - The arithmetic expression is balanced.");
        } else {
            System.out.println("False - The arithmetic expression is not balanced.");
        }
    }

    public static boolean checkBalancedParentheses(String expression) {
        Stack stack = new Stack();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing parenthesis
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // True if all parentheses are matched
    }
}
