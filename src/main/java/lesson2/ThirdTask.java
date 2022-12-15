package lesson2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

/**
 *     Дана json строка (можно сохранить в файл и читать из файла) (Коллеги, если сложно будет распарсить .json -> можно работать как со строкой обычной)
 *
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 *
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 *
 * Пример вывода:
 *
 * Студент Иванов получил 5 по предмету Математика.
 *
 * Студент Петрова получил 4 по предмету Информатика.
 *
 * Студент Краснов получил 5 по предмету Физика.
 */
public class ThirdTask {
    public static void main(String[] args) {
        try (var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("students.json")) {
            Student[] students = new ObjectMapper().readValue(resourceAsStream, Student[].class);
            System.out.println(Arrays.toString(students));
            var builder = new StringBuilder();
            Arrays.stream(students).forEach(student -> {
                builder.append("Студент %s".formatted(student.surname));
                builder.append(" получил %s ".formatted(student.mark));
                builder.append(" по предмету %S. \n".formatted(student.subject));
            });
            System.out.println(builder);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    record Student(@JsonProperty("фамилия") String surname, @JsonProperty("оценка") String mark, @JsonProperty("предмет")String subject){}
}
