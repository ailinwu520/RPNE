# Reverse Polish Notation Evaluator

A Java program that evaluates arithmetic expressions written in **Reverse Polish Notation (RPN)** using a custom stack implementation.

## Description

The `Lab06` class provides:

- An `evalRPN(List<String> tokens)` method that evaluates a given RPN expression and returns the result as an integer.
- A nested `ArrayStack<T>` class, which implements a **generic resizable stack** with basic stack operations: `push`, `pop`, `peek`, and `empty`.
- A `getList(int example)` helper method to retrieve sample RPN expressions for testing.

**Supported operators:**  
- Addition (`+`)  
- Subtraction (`-`)  
- Multiplication (`*`)  
- Division (`/`)

The algorithm loops through the list of tokens:
1. Pushes numbers onto the stack.
2. Pops two numbers when an operator is encountered.
3. Performs the operation and pushes the result back onto the stack.
4. Finally, returns the single value left on the stack.
