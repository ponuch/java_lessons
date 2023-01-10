package lesson5.first_task;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insert("alex", "222-333-444");
        phoneBook.insert("alex", "111-222-555");
        var phones =  phoneBook.allPhones("alex");
        assert phones.size() == 2;
        System.out.println(phones);
        phoneBook.delete("alex", "111-222-555");
        assert phones.size() == 1;
        System.out.println(phones);
    }
}
