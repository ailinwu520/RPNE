import java.util.ArrayList;
import java.util.List;
import java.util.EmptyStackException;

public class Lab06 {

    public int evalRPN(List<String> tokens) {
        // initialize stack and variables
        ArrayStack<String> stack = new ArrayStack<String>();
        int value = 0;
        String result = "";
        String operator = "";
        int val1, val2;

        // loop through the array list
        for (int i = 0; i < tokens.size(); i++) {
            // if not operator, then push to stack
            if ( tokens.get(i).equals("+") || tokens.get(i).equals("-") ||
                    tokens.get(i).equals("/") || tokens.get(i).equals("*") ) {
                operator = tokens.get(i);
            }
            // if operator, then assign to variable
            else {
                stack.push(tokens.get(i));
                continue;
            }

            switch (operator) {
                // addition operator
                case "+" -> {
                    // pop first two value, then push back to stack
                    val1 = Integer.parseInt(stack.pop());
                    val2 = Integer.parseInt(stack.pop());
                    value = val1 + val2;
                    result = "" + value;
                    stack.push(result);
                }
                // subtraction operator
                case "-" -> {
                    // pop first two value, then push back to stack
                    val1 = Integer.parseInt(stack.pop());
                    val2 = Integer.parseInt(stack.pop());
                    value = val2 - val1;
                    result = "" + value;
                    stack.push(result);
                }
                // multiplication operator
                case "*" -> {
                    // pop first two value, then push back to stack
                    val1 = Integer.parseInt(stack.pop());
                    val2 = Integer.parseInt(stack.pop());
                    value = val1 * val2;
                    result = "" + value;
                    stack.push(result);
                }
                // division operator
                case "/" -> {
                    // pop first two value, then push back to stack
                    val1 = Integer.parseInt(stack.pop());
                    val2 = Integer.parseInt(stack.pop());
                    value = val2 / val1;
                    result = "" + value;
                    stack.push(result);
                }
            }
        }
        // convert string to integer
        return Integer.parseInt(stack.pop());
    }

    // ArrayStack Implementation
    public class ArrayStack<T> extends Object {
        protected T[] arr;
        protected int top;

        // default constructor initialize empty stack
        public ArrayStack() {
            top = 0;
            arr = (T[]) new Object[10];
        }

        // expand Function
        public void Expand() {
            T[] largerArr = (T[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                largerArr[i] = arr[i];
            }
            arr = largerArr;
        }

        // push Function
        public void push(T item) {
            // add to top of the stack, expand is needed
            if (top == arr.length) {
                    Expand();
            }
            arr[top] = item;
            // increment size
            top++;
        }

        // pop Function
        public T pop() throws EmptyStackException {
            // remove the top element, return reference
            if (top == 0) {
                // throw exception when stack empty
                throw new EmptyStackException();
            }
            else {
                return arr[--top];
            }
        }

        // peek Function
        public T peek() throws EmptyStackException {
            // return top reference of stack
            if (top == 0) {
                // throw exception when stack empty
                throw new EmptyStackException();
            }
            else {
                return arr[top-1];
            }
        }

        // empty Function
        public boolean empty() {
            // return true when stack empty, else false
            return (top == 0);
        }
    }



    public ArrayList<String> getList(int example) throws Exception {
        if (example < 0 || example > 2)
            throw new Exception("Three examples only!");
        ArrayList<String> list = new ArrayList<String>();
        if (example == 0)
            list.addAll(List.of(new String[]{"2", "1", "+", "3", "*"}));
        else if (example == 1)
            list.addAll(List.of(new String[] {"4", "13", "5", "/", "+"}));
        else
            list.addAll(List.of(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        return list;
    }


    public static void main (String [] args) {
        Lab06 lab = new Lab06();
        ArrayList<String> tokens = new ArrayList<String>();
        try {
            for (int example = 0; example < 3; example++)
                System.out.println("Example " + example + " evaludates to " + lab.evalRPN(lab.getList(example)));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}
