package replacement;

import java.util.List;

public interface Replacement {

    /**
     * 从list当中剔除掉一个元素，换进新的元素。
     * 这个T必须实现了Comparable接口进行比较。
     * @param list 这个list可以是PTE,TLE，Memory中的列表。根据LRU，或者是LFU从list中剔除被换出的元素。
     * @param t 插入新的元素。
     */
    <T extends Comparable<? super T>> void exec(List<T> list, T t);
}
