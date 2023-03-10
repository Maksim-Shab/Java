import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        int a = 5;
//        System.out.println(a-- - --a);
        ex1();
    }
    static void ex0(){
        /*
        Написать программу, кот запросит пользователя ввести "имя" в консоли.
        Получит введенную строку и выведет в консоль сообщение "Привет "имя"!"
         */
        System.out.println("Как тебя зовут?");
        try (Scanner scanner = new Scanner(System.in)) {
           String name = scanner.nextLine();
//        System.out.println("Привет,")
           System.out.printf("Привет, %s", name);
           scanner.close();
       }
    }

    static void  ex1() {
        /*
        В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */
        System.out.println("Как тебя зовут?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро," + name + "!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Доброе день," + name + "!");
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Доброе вечер," + name + "!");
        } else {
            System.out.println("Доброе ночи," + name + "!");
        }
    }

    static void ex2(){
        /*
        Дан массив двоичных чисел,
        например [1,1,0,1,1,1], вывести максимальное кол-во подряд идущих 1
         */
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));
        int res = ex2_1(arr, 1);
        System.out.println("Максиьальное количество подряд идущих 1 равно: " + res);
    }
    static int ex2_1(int[] arr, int num) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                count++;
            } else {
                if(maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        if(maxCount < count) {
            maxCount = count;
        }
        return maxCount;
    }

    static void ex3() {
        int[] arr = new int[]{3,2,5,3};
        int[] res = new int[arr.length];
        int val = 3;
        Arrays.fill(res, val);

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != val){
                res[j] = arr[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(res));
    }

    static void  ex4() {
        /*
        Во фразе "Добро пожаловать на курс по Java"
        переставить слова в обратном порядке.
         */
        String s = "Добро пожаловать на курс по Java";
        String[] arr = s.split(" ");
        String res = "";
        for (int i = arr.length - 1; i >= 0 ; i--) {
            res += arr[i] + " ";
        }
        System.out.println(res);
    }

}