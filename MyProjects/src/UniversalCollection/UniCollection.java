package UniversalCollection;

/**
 * Created by Администратор on 19.01.2017.
 */
public interface UniCollection {
    String getFirst();
    String getLast();
    String getOnTheIndex(int index);
    void removeLast();
    void removeFirst();
    int getAmount();
}
