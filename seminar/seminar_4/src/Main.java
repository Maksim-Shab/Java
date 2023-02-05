import java.util.*;

public class Main {
    public static void main(String[] args) {
        ex1();

    }


    static void ex4(){
        MyStack myStack = new MyStack(4);
        System.out.println(myStack.size());
        myStack.push(5);
        myStack.push(4);
        myStack.push(2);
        myStack.push(10);
        myStack.push(7);
        myStack.push(50);

        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);
        myStack.push(33);
        System.out.println(myStack);
        }


static void ex(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        int sum = 0;
        // for (Integer integer: list){
        // }
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
        Integer integer = iterator.next();
        iterator.remove();
        sum += integer;
        }
        }


static void ex0(){
        /*
        1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
        2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
         */
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        list1.add(0, 5);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("ArrayList: " + (finishTime - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        list2.add(0, 5);
        }
        long finishTime2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (finishTime2 - startTime2));
        }


static void ex1(){
        /*
        Реализовать консольное приложение, которое:
        Принимает от пользователя строку вида
        text~num
        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
        Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
         */
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();

        while (true){
        String line = scanner.nextLine();
        String[] lines = line.split("~");
        if (lines[0].equals("end")){
        break;
        }
        if (!check(linkedList, lines)){
        continue;
        }
        if (lines[0].equals("print")){
        String word = linkedList.get(Integer.parseInt(lines[1]));
        linkedList.remove(Integer.parseInt(lines[1]));
        System.out.println(word);
        } else {
        linkedList.add(Integer.parseInt(lines[1]), lines[0]);
        }
        }
        System.out.println("Р”Рѕ СЃРєРѕСЂРѕР№ РІСЃС‚СЂРµС‡Рё");
        }


static void ex2(){
        /*
        Рефлизовать консольное приложение, которое:
        Принимает от пользователя и “запоминает” строки.
        Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        Если введено revert, удаляет предыдущую введенную строку из памяти.
         */
        

        }


static void ex3(){
        /*
        1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит на консоль содержимое стэка.
        2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди.
        */
        int[] array = new int[]{4,5,6,3,2,1,7};
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < array.length; i++) {
//            stack.push(array[i]);
//        }
//        System.out.println(stack.pop());
//        System.out.println(stack);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
        queue.offer(array[i]);
        }
        System.out.println(queue.peek());
        System.out.println(queue);
        }

static boolean check(LinkedList<String> linkedList, String[] lines){
//        try {
//                    linkedList.add(Integer.parseInt(lines[1]), lines[0]);
//                } catch (Exception e){
//                    System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
//                      continue;
//                }
        if (!lines[1].matches("[0-9]+")){
        System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
        return false;
        }
        int index = Integer.parseInt(lines[1]);
        if (index > linkedList.size()){
        System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
        return false;
        }
        return true;
        }
        }
