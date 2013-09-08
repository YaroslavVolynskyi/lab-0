package lab0;

public class Stack<T> {

    public final static int limit = 5;
    private Node<T> head;

    public T getHead() throws Exception{
        if (head != null){
            return head.value;
        } else {
            throw new Exception("stack is empty");
        }
    }

    public int getSize(){
        Node<T> current = head;
        int size = 0;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }

    public void push(T value) throws Exception {
        if (getSize() >= limit){
            throw new Exception("stack is full");
        } else {
            Node<T> newTop = new Node<T>();
            newTop.value = value;
            newTop.next = head;
            head = newTop;
        }
    }

    public T pop() throws Exception{
        if (head == null){
            throw new Exception("stack is empty");
        } else {
            T value = head.value;
            head = head.next;
            return value;
        }
    }
}
