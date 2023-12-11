package BalancedParenthesis;

import java.util.LinkedList;

/**
 * @author Dhruv
 * @project Day14
 */
class Stack {
    private LinkedList<Character> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(char ch) {
        stack.push(ch);
    }

    public char pop() {
        return stack.pop();
    }

    public char peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
