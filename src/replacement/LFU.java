package replacement;

import java.util.List;

public class LFU implements Replacement{

    @Override
    public <T extends Comparable<? super T>> void exec(List<T> list, T t) {
        //TODO 从List当中移除掉最少使用的元素，然后将元素t加进来。
        list.sort(T::compareTo);
        list.remove(0);
        list.add(t);
    }

}
