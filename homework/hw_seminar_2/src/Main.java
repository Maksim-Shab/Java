import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(parseString());// Данный медот можно запустить отдельно, если необходимо проверить только парсинг.
        writerAndExceptionsFile(parseString(), "dfgs/sdag/fdsg/df/Test.txt");// Для проверки логирования необходимо ввести некорректный путь к файлу
    }

    static String parseString(){
        /*
        Дана json строка
        {{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
        Задача написать метод(ы), который распарсит строку
        и выдаст ответ вида: Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.
        Используйте StringBuilder для подготовки ответа.
         */
        String s = "{{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";
        String res = "";
        Map<String, String> map = new HashMap<>();

        String[] arr = s.replace("{", "").
                replace("\"", "").
                split("},");

        for (String data : arr) {
            String[] keys = data.split(",");
            for (String keyValues : keys) {
                String[] keyValue = keyValues.replace("}", "").split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                map.put(key, value);
            }
            res += "Студент " + map.get("фамилия") + " получил " +
                    map.get("оценка") + " по предмету " + map.get("предмет") + ".\n";
        }
        return res;
    }

    static void writerAndExceptionsFile(String s, String filePath) throws IOException {
        /*
        Создать метод, который запишет результат работы в файл.
        Обработайте исключения и запишите ошибки в лог файл.
         */
        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        StringBuilder stringBuilder = new StringBuilder(s);
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(stringBuilder.toString());
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
            fileHandler.setFormatter(formatter);
        }
        fileHandler.close();
    }
}