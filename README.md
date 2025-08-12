This project is a simple calculator. Users are prompted to enter 1 number, then another number, then an operator. The program registers the first number as the first operand and the second number as the second operand, then performs a math problem specified by the operator.


Operation.java
Defines the Operation class, which contains a static method `performOperation` for executing basic arithmetic operations (+, -, *, /) on two integer operands. It is used by the Calculator class to process operators read from the calculator's memory. Invalid operators throw an IllegalArgumentException.

CalculatorMemory.java
Defines the CalculatorMemory class, which manages an `ArrayDeque<Integer>` to store calculator inputs (numbers or results of operations). It supports pushing and popping from the front of the deque, checking if the deque is empty, getting its size, clearing it, and generating a string representation of its contents. This acts as the calculator's memory stack.

Calculator.java
Defines the Calculator class, which uses a CalculatorMemory instance to store user input and perform calculations. It provides a `run` method that continuously prompts the user for numbers or operators, handles special commands (`clear`, `pop`), and processes valid operations using the Operation class. It includes error handling for invalid inputs, insufficient operands, and division by zero. The `main` method launches the interactive calculator program.
