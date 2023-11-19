import java.util.ArrayList;

/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 18:44
 */
public class NewArrayList<E> {
    private ArrayList arrayList = new ArrayList();

    public E get(int index) {
        return (E) arrayList.get(index);
    }

    public void add(E element) {
        arrayList.add(element);
    }


    public void remove(int index) {
        arrayList.remove(index);
    }
}
