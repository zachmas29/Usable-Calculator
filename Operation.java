//Operation
//@author Zachary Okayli Masaryk

//reads operation characters from CalculatorMemory's deque, and processes them as real operations
//that are able to change the values within the deque.
public class Operation {

    /**
     * @param op an equation operation
     * @param left the value to the right of the operation in the deque.
     * @param right the value to the right of @left. Left will be operated on by the operation itself and this value.
     * @return calculation: the cumulative number formed by all operations that take place within the shrinking ArrayDeque
     */
    public static int performOperation(char op, int left, int right){
        int calculations = 0;
        if(op == '+'){
            calculations = (left + right);
        }
        else if(op == '-'){
            calculations = (left - right);
        }
        else if(op == '*'){
            calculations = (left * right);
        }
        else if(op == '/'){
            calculations = (left / right);
        }
        else{
            throw new IllegalArgumentException();
        }
        return calculations;
    }
}
