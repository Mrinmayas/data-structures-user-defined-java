import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity. " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {

        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                //If capacity > 0, increase the size by 2.
                capacity *= 2;
            }

            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr; //New size, with trailing null values.
        }
        arr[len++] = elem;
    }

    public T removeAt(int rm_index) {
        if (rm_index >= len && rm_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] newArr = (T[]) new Object[len - 1];

        //5 elements
        //1,2,3,4,5.
        //delete at index 2.
        //1,2,4,5
        for (int i = 0; i < len - 1; i++) {
            if (i < rm_index)
                newArr[i] = arr[i];

            if (i > rm_index)
                newArr[i] = arr[i + 1];
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(o)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder(len).append("[");

            for (int i = 0; i < len - 1; i++) {
                builder.append(arr[i] + ", ");
            }
            return builder.append(arr[len - 1] + "]").toString();
        }
    }
}