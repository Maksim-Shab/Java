import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        reversList(randomList(5));
//        queue();
//        System.out.println("Сумма всех элементов равна: " + sumElements(randomList(5)));
    }

    static LinkedList randomList(int n){
        Random random = new Random();
        LinkedList linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(random.nextInt(5));
        }
        return linkedList;
    }

    static void reversList(LinkedList list) {
        /*Пусть дан LinkedList с несколькими элементами.
        Реализуйте метод, который вернет “перевернутый” список.
         */
        System.out.println("Оригинал: " + list);
        LinkedList linkedList = new LinkedList<>();
        for (int i = list.size(); i > 0; i--) {
            linkedList.add(list.pollLast());
        }
        System.out.print("Реверс: " + linkedList);
    }

    static void queue(){
        /*Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.
         */
        MyClassQueue myClassQueue = new MyClassQueue();
        myClassQueue.enqueue(3);
        myClassQueue.enqueue(4);
        myClassQueue.enqueue(5);
        myClassQueue.enqueue(6);
        myClassQueue.enqueue(7);
        System.out.println("Начальная очередь: " + myClassQueue);
        System.out.println("Первый элемент(без удаления): " + myClassQueue.first());
        System.out.println("Первый элемент(с удалением): " + myClassQueue.dequeue());
        System.out.println("Первый элемент(без удаления): " + myClassQueue.first());
        System.out.println("Итоговая очередь: " + myClassQueue);
    }

    static Integer sumElements(LinkedList list){
        /*
        Найдите сумму всех элементов LinkedList,
        сохраняя все элементы в списке. Используйте итератор
         */
        System.out.println(list);
        int sum = 0;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            iterator.remove();
            sum += integer;
        }
        return sum;
    }
}