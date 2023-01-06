package lesson4.second_task;

import java.util.Collection;
import java.util.LinkedList;

public class QueueEx<T> {
    private LinkedList<T> internalList;

    public QueueEx() {
        this.internalList = new LinkedList<T>();
    }

    public QueueEx(Collection<T> collection) {
        this.internalList = new LinkedList(collection);
    }

    /**
     * помещает элемент в конец очереди
     * @param elem - элемент, который помещают в очередь
     */
    public void enqueue(T elem) {
        internalList.add(elem);
    }

    /**
     * возвращает первый элемент из очереди и удаляет его
     * @return
     */
    public T dequeue() {
        return internalList.removeFirst();
    }

    /**
     *  возвращает первый элемент из очереди, не удаляя
     * @return первый элемент из очереди
     */
    public T first() {
        return internalList.getFirst();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
