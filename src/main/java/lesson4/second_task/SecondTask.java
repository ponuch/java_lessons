package lesson4.second_task;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 */
public class SecondTask {
    public static void main(String[] args) {
        QueueEx<Integer> queueEx = new QueueEx<>();
        queueEx.enqueue(1);
        queueEx.enqueue(2);
        queueEx.enqueue(45);
        System.out.println("Initial state of queue");
        System.out.println(queueEx);

        var firstElem = queueEx.dequeue();
        System.out.println("First element = %d".formatted(firstElem));
        System.out.println(queueEx);

        var anotherFirstElement = queueEx.first();
        System.out.println("Another first element = %d".formatted(anotherFirstElement));
        System.out.println(queueEx);
    }
}
