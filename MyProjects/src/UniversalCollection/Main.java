package UniversalCollection;

/**
 * Created by Администратор on 19.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
        Queue queue = new Queue(4);

        for (int i = 0; i < 10; i++) {
            stack.push("" + i);
            queue.set("" + i);
        }

        System.out.println("Количество в стеке = " + stack.getAmount());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop() + "\n");

        System.out.println(stack.getFirst());
        System.out.println(stack.getLast());
        System.out.println(stack.getOnTheIndex(2) + "\n");
        stack.removeFirst();
        stack.removeLast();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        System.out.println("Количество в очереди = " + queue.getAmount());

        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get() + "\n");

        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        System.out.println(queue.getOnTheIndex(2) + "\n");
        queue.removeFirst();
        queue.removeLast();
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());

        for (int i = 0; i < 10; i++) {
            stack.push("" + i);
            queue.set("" + i);
        }

        UniCollection collection = stack;

        System.out.println("\n Коллекция содержит " + collection.getAmount());
        System.out.println(collection.getFirst());
        System.out.println(collection.getLast());
        collection.removeLast();
        collection.removeFirst();
        System.out.println(collection.getOnTheIndex(4));
        System.out.println(collection.getOnTheIndex(3));

        collection = queue;
        System.out.println("\n Коллекция содержит " + collection.getAmount());
        System.out.println(collection.getFirst());
        System.out.println(collection.getLast());
        collection.removeLast();
        collection.removeFirst();
        System.out.println(collection.getOnTheIndex(4));
        System.out.println(collection.getOnTheIndex(3));
    }
}
