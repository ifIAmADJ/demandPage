package util;

import replacement.Replacement;
import java.util.List;

/**
 * 该转换器需要据悉以下两个泛型参数：
 * @param <E> 进行转换的E，其中e必须实现了Comparable接口用于比较。
 * @param <R> 指定一个实现了Replacement接口的置换方式。
 */
public class Transverter<E extends Comparable<E>,R extends Replacement> {
    /**
     * 使用泛型定义一个高度抽象的转换器方法。
     * @param es e的集合。
     * @param e e必须实现了Comparable接口。
     * @param r r必须实现了Replacement接口。
     */
    public void transform(List<E> es, E e,R r){
        r.exec(es,e);
    }

}
