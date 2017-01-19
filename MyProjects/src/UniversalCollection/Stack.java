package UniversalCollection;

/**
 * Created by Администратор on 19.01.2017.
 */
public class Stack implements StackInterface {
    private String stArr[];
    private int capacity;


    public Stack(int size) {
        stArr = new String[size];
        capacity = 0;
    }

    private String[] resize() {
        String tmpArr[] = new String[capacity + 10];
        System.arraycopy(stArr, 0, tmpArr, 0, stArr.length);
        return tmpArr;
    }

    private void rewrite(int index) {
        System.arraycopy(stArr, index+1, stArr, index, capacity-index);
    }

    @Override
    public void push(String str) {
        capacity++;
        if (capacity > stArr.length) {
            stArr = resize();
        }
        stArr[capacity-1] = str;
    }

    @Override
    public String pop() {
        if (capacity > 0) {
            String str = stArr[capacity - 1];
            removeFirst();
            return str;
        }
        return "стек пуст!";
    }

    @Override
    public String getFirst() {
        String str = stArr[--capacity];
        rewrite(capacity);
        stArr[capacity] = null;
        return str;
    }

    @Override
    public String getLast() {
        capacity--;
        String str = stArr[0];
        rewrite(0);
        return str;
    }

    @Override
    public String getOnTheIndex(int index) {
        if (capacity > 0) {
            if ((index > capacity-1) || (index < 0))
            {
                return "Ошибка доступа к элементу стека";
            }
            capacity--;
            String str = stArr[capacity - index];
            if (index == 0) {
                stArr[capacity] = null;
                return str;
            }
            rewrite(capacity - index);
            stArr[capacity] = null;
            return str;
        }
        return "стек пуст!";
    }

    @Override
    public void removeLast() {
        capacity--;
        rewrite(0);
        stArr[capacity] = null;
    }

    @Override
    public void removeFirst() {
        stArr[--capacity] = null;
    }

    @Override
    public int getAmount() {
        return capacity;
    }
}
