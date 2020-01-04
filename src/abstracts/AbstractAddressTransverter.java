package abstracts;

import entity.ActualAddress;
import entity.VirtualAddress;

/**
 * 抽象地址转换器。
 * @author liJunhu
 */
public abstract class AbstractAddressTransverter {

    /**
     * 该方法规定了虚拟地址转换为实际地址的方法。
     * @param virtualAddress 输入虚拟地址。
     * @return 输出实际地址。
     */
    abstract public ActualAddress transform(VirtualAddress virtualAddress);
}
