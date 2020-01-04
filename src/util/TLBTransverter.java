package util;

import entity.Mapper;
import replacement.Replacement;
import java.util.List;

/**
 * 快表转换器。当需要对快表进行换进换出时，会构造该转换器。
 * @author liJunhu
 */
public class TLBTransverter<T extends Replacement> {
    /**
     * 该方法判定哪些页会被换掉。
     * @param mappers 提供快表内存储的list
     * @param mapper 提供替换的快表项
     * @param t 替换方式.
     */
    public void transform(List<Mapper> mappers, Mapper mapper, T t){
        t.exec(mappers,mapper);
    }
}
