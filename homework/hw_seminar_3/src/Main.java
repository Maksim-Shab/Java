import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        delEvenNum(randomList(10));
//        secondTask(randomList(10));
    }

    static List<Integer> randomList(int n){//Заполнение списка случайными числами.
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }

    static void delEvenNum(List<Integer> list){
        /*
        Пусть дан произвольный список целых чисел,
        удалить из него четные числа
         */
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }

    static void secondTask(List<Integer> list){
        /*
        Задан целочисленный список ArrayList.
        Найти минимальное, максимальное и среднее арифметическое из этого списка.
        Collections.max()
         */
        System.out.println(list);
        System.out.println("Максимальное значение равно: " + Collections.max(list));
        System.out.println("Минимальное значение равно: " + Collections.min(list));
        int summ = 0;
        for (int i = 0; i < list.size(); i++) {
            summ += list.get(i);
        }
        double arithmeticMean = (double) summ / list.size();
        System.out.println("Среднее арифметическое равно: "+ arithmeticMean);
    }

}

