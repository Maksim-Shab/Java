import java.util.LinkedList;

public class MyClassQueue {
    private LinkedList linkedList;

    MyClassQueue(){
        linkedList = new LinkedList();
    }

    void enqueue(int element){
        linkedList.add(element);
    }

    int dequeue(){
        return (Integer) linkedList.pollFirst();
    }

    int first(){
        return (Integer) linkedList.getFirst();
    }

    public String toString() {
        LinkedList linkedList1 = new LinkedList<>();
        linkedList1 =  linkedList;
        return linkedList1.toString();
    }

}
