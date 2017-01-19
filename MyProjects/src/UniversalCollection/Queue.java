package UniversalCollection;

/**
 * Created by Администратор on 19.01.2017.
 */
public class Queue implements QueueInterface {
    private String qArr[];
    private int capacity;


    public Queue(int size) {
        qArr = new String[size];
        capacity = 0;
    }

    private String[] resize() {
        String tmpArr[] = new String[capacity + 10];
        System.arraycopy(qArr, 0, tmpArr, 0, qArr.length);
        return tmpArr;
    }

    private void rewrite(int index) {
        System.arraycopy(qArr, index+1, qArr, index, capacity-index);
    }

    @Override
    public void set(String str) {
        capacity++;
        if (capacity > qArr.length) {
            qArr = resize();
        }
        qArr[capacity-1] = str;
    }

    @Override
    public String get() {
        if (capacity > 0) {
            String str = qArr[0];
            removeFirst();
            return str;
        }
        return "Очередь пуста";
    }

    @Override
    public String getFirst() {
        String str = qArr[0];
        --capacity;
        rewrite(0);
        qArr[capacity] = null;
        return str;
    }

    @Override
    public String getLast() {
        String str = qArr[--capacity];
        qArr[capacity] = null;
        return str;
    }

    @Override
    public String getOnTheIndex(int index) {
        if (capacity > 0) {
            if ((index > capacity-1) || (index < 0))
            {
                return "Ошибка доступа к элементу очереди";
            }
            capacity--;
            String str = qArr[index];
            if (index == capacity) {
                qArr[capacity] = null;
                return str;
            }
            rewrite(index);
            qArr[capacity] = null;
            return str;
        }
        return "Очередь пуста!";
    }

    @Override
    public void removeLast() {
        capacity--;
        qArr[capacity] = null;
    }

    @Override
    public void removeFirst() {
        capacity--;
        rewrite(0);
        qArr[capacity] = null;
    }

    @Override
    public int getAmount() {
        return capacity;
    }
}
