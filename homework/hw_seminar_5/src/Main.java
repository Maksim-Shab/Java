import java.util.*;

public class Main {
    public static void main(String[] args){
//         phoneBook();
        popularity();
    }

    static void phoneBook(){
        /*
        Реализуйте структуру телефонной книги с помощью HashMap,
        учитывая, что 1 человек может иметь несколько телефонов.
         */
        HashMap<String, String> employees = new HashMap<>();

        employees.put("Иван Иванов", "+73535797955, +75444567710");
        employees.put("Пётр Петров", "+14562156239");
        employees.put("Сидор Сидоров", "+7842454456");
        employees.put("Григорий Григорьев", "+754524545557");
        employees.put("Анатолий Анитольев", "+512325561");

        System.out.println(employees);
    }

    static void popularity(){

        String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, " +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        s = s.replace(",", "");
        String[] arr = s.split(" ");
        ArrayList names = new ArrayList();

        for (int i = 0; i < arr.length; i+=2) {
            names.add(arr[i]);
        }

        TreeMap<Object, Integer> map = new TreeMap<>();
        for (int i = 0; i < names.size(); i++) {
            if (map.containsKey(names.get(i))) {
                int count = map.get(names.get(i)) + 1;
                map.put(names.get(i), count);
            } else {
                map.put(names.get(i), 1);
            }
        }
        System.out.println(names);
        map.entrySet().stream().sorted(Map.Entry.<Object, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }

}