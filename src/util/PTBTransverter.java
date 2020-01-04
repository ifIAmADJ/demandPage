package util;

import entity.Mapper;
import replacement.Replacement;

import java.util.List;

/**
 * 页表转换器。当需要对快表进行换进换出时，会构造该转换器。
 * @author liJunhu
 */
public class PTBTransverter<T extends Replacement> {

    /**
     * 该方法判定哪些页会被换掉。
     * @param mappers 页表。
     * @param mapper 新替换的页表元素。
     * @param t 替换方式
     */
    void transform(List<Mapper> mappers,Mapper mapper, Replacement t){

    }

}
