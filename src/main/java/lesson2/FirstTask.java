package lesson2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 Данные для фильтрации приведены ниже в виде json строки.

 Если значение null, то параметр не должен попадать в запрос.

 Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class FirstTask {
    public static void main(String[] args) {
        var sql = "select * from students where ";
        try (var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("condition.json")) {
            Map<String, String> conditions = new ObjectMapper().readValue(resourceAsStream, HashMap.class);
            var builder = new StringBuilder(sql);
            conditions.entrySet().stream().filter(item -> !item.getValue().equals("null")).forEach(cond -> {
                builder.append(cond.getKey());
                builder.append("=");
                builder.append(cond.getValue());
                builder.append(" and ");
            });
        System.out.println(builder.replace(builder.lastIndexOf("and") - 1, builder.lastIndexOf("and") + 3, ""));

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
