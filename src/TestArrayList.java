import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by _red_ on 07.06.17.
 */
public class TestArrayList<T>{
    private final int CAPACITY = 10;
    private final int K = 3/2 + 1;
    private Object[] array = new Object[CAPACITY];
    private int count = 0;

    public void add(T value) {
        if (count == array.length - 1) resize();
        array[count++] = value;
    }


    public void add(int index, T value) {
        if (count == array.length - 1) resize();
        Object[] newArray = new Object[array.length];

        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, count - index);

//        for (int i = 0; i < index; i ++)
//            newArray[i] = array[i];
//
//        newArray[index] = value;
//
//        for (int i = index + 1; i < array.length; i ++)
//            newArray[i] = array[i - 1];

        array = newArray;
        count++;
    }

    public void remove(int index) {
        for (int i = index - 1; i<count; i++)
            array[i] = array[i+1];
        array[count] = null;
        count--;
    }

    public void remove(T value) {
        for (int i = 0; i < count; i++)
            if (get(i) == value) remove(i + 1);
    }

    public boolean contains(T value) {
        for (int i = 0; i < count; i++)
            if (array[i] == value) return true;
        return false;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * K];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }

    public int size() {
        return count;
    }

    public T get(int index) {
        return (T) array[index];
    }
}
