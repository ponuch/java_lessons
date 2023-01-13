package lesson6.first_task;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var laptops = new HashSet<Laptop>();
        laptops.add(new Laptop((byte) 16, 512, "Linux Mint", Color.BLACK, 40_000));
        laptops.add(new Laptop((byte) 8, 256, "Ubuntu", Color.WHITE, 50_000));
        laptops.add(new Laptop((byte) 32, 1024, "Win Pro", Color.YELLOW, 60_000));
        laptops.add(new Laptop((byte) 64, 512, "Ubuntu", Color.BLACK, 30_000));
        laptops.add(new Laptop((byte) 16, 256, "Linux Mint", Color.BLACK, 56_000));
        laptops.add(new Laptop((byte) 24, 256, "Cent os", Color.BLACK, 34_000));
        laptops.add(new Laptop((byte) 8, 512, "Win home", Color.BLACK, 57_000));
        laptops.add(new Laptop((byte) 16, 1024, "Win home", Color.BLACK, 65_000));
        laptops.add(new Laptop((byte) 32, 512, "Linux Mint", Color.BLACK, 63_000));
        laptops.add(new Laptop((byte) 16, 512, "Win pro", Color.BLACK, 50_000));

        var criterias = new HashMap<String, String>();

        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Введите команду (filter, exit) \n");
            String command = reader.nextLine();

            switch (command) {
                case "exit":
                    return;
                case "filter":
                    System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                            "1. ОЗУ\n" +
                            "2. Объём ЖД\n" +
                            "3. ОС\n" +
                            "4. Цвет\n" +
                            "5. Цена \n");
                    criterias.putAll(inputCriterias());
                    var compositePredicate = createPredicates(criterias);
                    laptops.stream().filter(compositePredicate).forEach(System.out::println);
                    break;

            }
        }

    }

    private static Predicate<Laptop> createPredicates(HashMap<String, String> criterias) {
        List<Predicate<Laptop>> allPredicate = new ArrayList<>();
        if (criterias.containsKey("ram")) {
            allPredicate.add(l -> l.ram() >= Integer.parseInt(criterias.get("ram")));
        }
        if (criterias.containsKey("ssd")) {
            allPredicate.add(l -> l.ssd() >= Integer.parseInt(criterias.get("ssd")));
        }
        if (criterias.containsKey("os")) {
            allPredicate.add(l -> l.os().contains(criterias.get("os")));
        }
        if (criterias.containsKey("color")) {
            allPredicate.add(l -> l.color().toString().contains(criterias.get("color")));
        }
        if (criterias.containsKey("price")) {
            allPredicate.add(l -> l.price() >= Integer.parseInt(criterias.get("price")));
        }

        Predicate<Laptop> compositePredicate = allPredicate.stream().reduce(l -> true, Predicate::and);

        return compositePredicate;
    }

    private static HashMap<String, String> inputCriterias() {
        Scanner reader = new Scanner(System.in);
        String filter = reader.nextLine();
        var criteria = new HashMap<String, String>();
        switch (filter) {
            case "1":
                System.out.println("Введите минимальное значение ОЗУ: \n");
                String ram = reader.nextLine();
                criteria.put("ram", ram);
                break;
            case "2":
                System.out.println("Введите минимальное значение ЖД: \n");
                String ssd = reader.nextLine();
                criteria.put("ssd", ssd);
                break;
            case "3":
                System.out.println("Введите значение ОС: \n");
                String os = reader.nextLine();
                criteria.put("os", os);
                break;
            case "4":
                System.out.println("Введите цвет: \n");
                String color = reader.nextLine();
                criteria.put("color", color);
                break;
            case "5":
                System.out.println("Введите минимальную цену: \n");
                String price = reader.nextLine();
                criteria.put("price", price);
                break;
        }
        return criteria;
    }
}

record Laptop(byte ram, int ssd, String os, Color color, int price) {}
