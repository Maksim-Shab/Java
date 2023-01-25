import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sumOfNumbers(5);
//        multOfNumbers(5);
//        primeNumbers();
//        calculator();

    }

    static void sumOfNumbers(int num) {
        /*
        Вычислить n-ое число(сумма чисел от 1 до n)
         */
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        System.out.println(res);
    }

    static void multOfNumbers(int num) {
        /*
        Вычислить n! (произведение чисел от 1 до n)
         */
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        System.out.println(res);
    }

    static void primeNumbers() {
        /*
        Вывести все простые числа от 1 до 1000
        (простые числа - это числа
        которые делятся только на себя и на единицу без остатка.
        Чтобы найти остаток от деления используйте оператор % ,
        например 10%3 будет равно единице)
         */
        int[] arr = new int[1000];
        String numbers = "";
        for (int i = 0, j = 1; i < arr.length; i++) {
            arr[i] += j;
            j++;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 2; i <= arr.length; i++) {
            boolean bool = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool){
                numbers += i + " ";
            }
        }
        System.out.println(numbers);
    }

    static void calculator(){
        /*
        Реализовать простой калькулятор
        ("введите первое число"... "Введите второе число"... "укажите операцию,
        которую надо выполнить с этими числами"... "ответ: ...")
         */
        System.out.println("Введите первое число:");
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите второе число:");
        int secondNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите операцию, котору надо выполнить");
        String operation = scanner.nextLine();
        int res = 0;
        switch (operation){
            case "+":
                res = firstNumber + secondNumber;
                System.out.println("Ответ равен: " + res);
                break;
            case "-":
                res = firstNumber - secondNumber;
                System.out.println("Ответ равен: " + res);
                break;
            case "*":
                res = firstNumber * secondNumber;
                System.out.println("Ответ равен: " + res);
                break;
            case "/":
                res = firstNumber / secondNumber;
                System.out.println("Ответ равен: " + res);
                break;
            default:
                System.out.println("Введите корректные данные!");
                calculator();
        }

    }

}