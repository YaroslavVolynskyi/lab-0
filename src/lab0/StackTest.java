package lab0;

import org.junit.Before;
import static org.junit.Assert.*;

public class StackTest {
    private Stack<Integer> myStack;

    @Before
    public void setUp(){
        myStack = new Stack<Integer>();
    }

    private void generateStack(int n) throws Exception{
        for (int i = 0; i < n; i++){
            myStack.push(i);
        }
    }

    @org.junit.Test
    public void testGetHead() throws Exception {
        try{
            myStack.getHead();
            fail();
        } catch(Exception e){
            assertEquals("stack is empty", e.getMessage());
        }
        generateStack(Stack.limit);
        for(int i = Stack.limit - 1; i >= 0; i--){
            assertEquals(myStack.getHead(), (Integer)i);
            myStack.pop();
        }
    }

    @org.junit.Test
    public void testGetSize() throws Exception {
        for(int i = 0; i < Stack.limit; i++){
            assertEquals(i, myStack.getSize());
            myStack.push(0);
        }
    }

    @org.junit.Test
    public void testPush() throws Exception {
        generateStack(Stack.limit);
        int headValue = myStack.getHead();
        try{
            myStack.push(0);
            fail();
        } catch(Exception e){
            assertEquals("stack is full", e.getMessage());
        } finally{
            assertEquals((Integer) headValue, myStack.getHead());
        }
    }

    @org.junit.Test
    public void testPop() throws Exception {
        try{
            myStack.pop();
            fail();
        } catch(Exception e){
            assertEquals("stack is empty", e.getMessage());
        }

        generateStack(Stack.limit);
        for(int i = Stack.limit - 1; i >= 0; i--){
            assertEquals((Integer)i, myStack.pop());
        }

        try{
            myStack.pop();
            fail();
        } catch(Exception e){
            assertEquals("stack is empty", e.getMessage());
        }
        try{
            myStack.getHead();
            fail();
        } catch(Exception e){
            assertEquals("stack is empty", e.getMessage());
        }
    }
}
