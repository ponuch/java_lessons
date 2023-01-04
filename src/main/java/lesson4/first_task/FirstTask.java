package lesson4.first_task;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */
public class FirstTask {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("seconf");
        list.add("third");
        System.out.println("List before reverse");
        System.out.println(list);
        System.out.println("List after reverse using Collections.reverse()");
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("New list after reverse using static method :)");
        var newList = reverse(list);
        System.out.println(newList);
    }

    private static LinkedList reverse(LinkedList<?> list) {
        var resultList = new LinkedList<>();
        for(int i = list.size() - 1; i >= 0; i--) {
            resultList.add(list.get(i));
        }
        return resultList;
    }
}
