//CalculatorMemory.java
//@author Zachary Okayli Masaryk

import java.util.ArrayDeque;

 /**
  * Initializes an ArrayDeque that adds and removes values to and from its front.
  */
public class CalculatorMemory {

    //instance variable
    private ArrayDeque<Integer> pastOps;

    //constructs the ArrayDeque
    public CalculatorMemory(){
        pastOps = new ArrayDeque<Integer>();
    }

    /**
     * @param number: a number/userInput value that will later be used in a calculation
     * adds the number to the beginning of the deque, known as pastOps.
     */
    public void push(int number){
        pastOps.addFirst(number);
    }

    //removes number or operator from front of pastOps
    public int pop(){
        return pastOps.pop();
    }

    //returns True or False based on whether pastOps is an empty Array or not
    public boolean isEmpty(){
        return pastOps.isEmpty();
    }

    //returns the number of elements in pastOps
    public int size(){
        return pastOps.size();
    }
    
    //removes all values from pastOps
    public void clear(){
        pastOps.clear();
    }

    //converts elements in pastOps to a string containing the elements separated by a space
    public String toString(){
        String calcOps = "";
        Object[] pastOpsArray= pastOps.toArray();
        for(int i = 0; i < pastOpsArray.length; i++){
            Object operation = pastOpsArray[i];
            calcOps += operation + "\n";
        }
        return calcOps + "---\n";
    }
}
