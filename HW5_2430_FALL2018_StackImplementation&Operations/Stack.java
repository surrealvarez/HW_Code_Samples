import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {

    private  ArrayList<String> stack = new ArrayList<>();

    public String top() {
        return (stack.get(size()-1));
    }

    public String pop() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size()-1);
    }
    public  boolean isEmpty() {
        return  stack.isEmpty();
    }

    public void add(String obj) {
        stack.add(obj);
    }
    public int size() {
        return stack.size();
    }
}
