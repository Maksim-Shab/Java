import java.util.LinkedList;

public class MyClassQueue {
    private LinkedList<Integer> linkedList;

    MyClassQueue(){
        linkedList = new LinkedList();
    }

    void enqueue(int element){
        linkedList.add(element);
    }

    int dequeue(){
        return linkedList.pollFirst();
    }

    int first(){
        return linkedList.getFirst();
    }

    public String toString() {
        LinkedList linkedList1 = new LinkedList<>();
        linkedList1 =  linkedList;
        return linkedList1.toString();
    }

}
