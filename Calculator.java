// Calculator
//@author Zachary Okayli Masaryk

import java.util.Scanner;

 /**
  * Inherits the CalculatorMemory deque and its methods
  * Prompts a user to enter values and operators that are pushed into the deque.
  * Throws exceptions to parameters that cannot be carried out by java, and acts accordingly.
  * Performs calculations on all valified inputs in maim function. 
  */
public class Calculator{

    //instance variable
    private CalculatorMemory memory;

    //constructor initializing instance variable
    //ArrayDeque inherited from CalculatorMemory.java
    //Structure of the 
    public Calculator(){
        memory = new CalculatorMemory();
    }

    /**
     * Input scanner that pushes a user's entries into the ArrayDeque, memory.
     * Throws exceptions to inputs that cannot be carried by a built-in java method.
     * According to the error, it will act on the input in certain ways. I.E: Parse int cannot work on 
     * a non int, but if it ends up being an operator, it will perform an operation within the first three deque values and
     * the processOperation helper function. A while loop keeps the operations and userInputs in function until the deque is empty.
     * Every time an operation is performed, the right and left values of the operation become one combined value in the deque.
     */
    public void run(){
        Scanner inputSpace = new Scanner(System.in);
        while(true){
            System.out.print("Enter a number or operator: ");
            String userInput = inputSpace.nextLine();
            if(userInput.isEmpty()){
                break;
            }
            try{
                memory.push(Integer.parseInt(userInput));
            }
            catch(NumberFormatException L){
                if(userInput.equals("clear")){
                    memory.clear();
                }
                else if(userInput.equals("pop")){
                    if(memory.isEmpty()){
                        System.out.println("Error: pop requires one argument");
                    }
                    else{
                        System.out.println("Answer: " + memory.pop());
                    }
                }
                else{
                    processOperation(userInput);
                }
            }
            System.out.println("\nMemory contents: ");
            System.out.print(memory);
            System.out.println("");
        }
        inputSpace.close();
    }

    /**
     * @param input userInput from scanner (processed through run()).
     * Handles all errors that cannot lead to an operation through perform operation.
     * Calls Operation.java's performOperation function on all valid operation components
     */
    private void processOperation(String input){
        int popOne = 0;
        int popTwo = 0;
        try{
            if(memory.size() < 2){
                System.out.println("Error: operator requires two arguments");
            }
            else{
                popOne = memory.pop();
                popTwo = memory.pop();
                int result = Operation.performOperation(input.charAt(0), popTwo, popOne);
                memory.push(result);
                System.out.println("Answer: " + result);
            }
        }
        catch(IllegalArgumentException E){
            System.out.println("Error: expected number or operator");
            memory.push(popTwo);
            memory.push(popOne);
        }
        catch(ArithmeticException I){
            System.out.println("Error: divide by zero");
            memory.push(popTwo);
            memory.push(popOne);
        }
    }

    public static void main(String[] args){
        Calculator calcTest = new Calculator();
        calcTest.run();
    }

}
