import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] params) {
        Set<Notebook> notebooks = initSet();
        Scanner scanner = new Scanner(System.in);
        //Scanner scannerVal = new Scanner(System.in);

        List<String> criteriesInteger = Arrays.asList("1","2","3");
        List<String> criteriesString = Arrays.asList("4","5");
        Map<String, String> filter = new HashMap<String, String>();

        printNotebooks(notebooks, filter);
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - Минимальный объём ОЗУ (Гб)");
            System.out.println("2 - Минимальный объём HHD или SSD (Гб)");
            System.out.println("3 - Размер экрана (дюйм)");
            System.out.println("4 - Цвет");
            System.out.println("5 - Операционная система");
            System.out.println("0 - Сброс");
            System.out.println("-1 - Выход");
            System.out.print("Номер критерия-->");

            String key = scanner.nextLine();
            if (key != null) key = key.trim(); else continue;
            if (key.equalsIgnoreCase("-1")) break;
            if (key.equalsIgnoreCase("0")) {
                filter.clear();
                printNotebooks(notebooks, filter);
            }
            if (criteriesInteger.contains(key) || criteriesString.contains(key)) {
                System.out.print("Значение критерия-->");
                String value = scanner.nextLine();
                if (value != null) value = value.trim(); else continue;

                if (value.equals("")) {
                    filter.put(key, value);
                } else {
                    //
                    if (criteriesString.contains(key)) {
                        filter.put(key, value);
                    } else {
                        try {
                            Integer i = Integer.parseInt(value);
                            filter.put(key, value);
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("!!!!!!Для числового критерия (" + key + ") введено нечисловое значение");
                            continue;
                        }
                    }
                }
                //
                printNotebooks(notebooks, filter);
            } else {
                System.out.println();
                System.out.println(String.format("!Критерий %s отсутствует", key));
            }
        }
    }

    static void printNotebooks(Set<Notebook> notebooks, Map<String, String> filter) {
        List<String> forPrint = new ArrayList<String>();
        for (Notebook n: notebooks) {
            if (filter(n, filter)) {
                String s = String.format("S/N:%12s: ОЗУ(Гб):%d, диск(Гб):%d, экран(дюйм):%d, ОС:%s, цвет:%s",
                        n.getSerialNumber(),
                        n.getRamSizeGb(),
                        n.getDiskSizeGb(),
                        n.getScreenSizeInch(),
                        n.getOs(),
                        n.getColor()
                );
                forPrint.add(s);
            }
        }

        System.out.println();
        System.out.println(String.format("***Ноутбуки. Результат (%d из %d)", forPrint.size(), notebooks.size()));
        for (String s: forPrint) {
            System.out.println(s);
        }
    }

    static boolean filter(Notebook n, Map<String, String> filter) {
        boolean result = true;

        for (String key: filter.keySet()) {
            String value = filter.get(key);
            if (value == null || value.trim().equals("")) continue;
            //
            if (key.equals("1")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getRamSizeGb() >= i) {
                        //ok
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            } else if (key.equals("2")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getDiskSizeGb() >= i) {
                        //ok
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            } else if (key.equals("3")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getScreenSizeInch() >= i) {
                        //ok
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            } else if (key.equals("4")) {
                if (n.getColor().equalsIgnoreCase(value)) {
                    //ok
                } else {
                    result = false;
                    break;
                }
            } else if (key.equals("5")) {
                if (n.getOs().toUpperCase().contains(value.toUpperCase())) {
                    //ok
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    static Set<Notebook> initSet() {
        String OS_WINDOWS_10 = "Windows";
        String OS_LINUX_UBUNTU = "Linux";

        Set<Notebook> set = new HashSet<Notebook>();
        //
        set.add(new Notebook(
                "W1234",
                15,
                8,
                512,
                OS_WINDOWS_10,
                "White"
        ));
        set.add(new Notebook(
                "L2345",
                17,
                8,
                128,
                OS_LINUX_UBUNTU,
                "Black"
        ));
        set.add(new Notebook(
                "L2345",
                17,
                4,
                4000,
                OS_LINUX_UBUNTU,
                "White"
        ));
        set.add(new Notebook(
                "W1234",
                15,
                16,
                1024,
                OS_WINDOWS_10,
                "Gray"
        ));

        return set;
    }
}