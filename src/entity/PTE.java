package entity;

import replacement.LFU;
import util.TLBTransverter;

import java.util.LinkedList;
import java.util.List;

/**
 * 适配器模式构造页表。
 * @author liJunhu
 */
public class PTE {

    private TLBTransverter<LFU> lfutlbTransverter =new TLBTransverter<>();

    private List<Mapper> list=new LinkedList<>();

    private int listSize;

    public PTE(int listSize) {
        this.listSize = listSize;
    }

    public void add(Mapper mapper){

        //如果表没有满
        if(!isFull()) {
            list.add(mapper);
        }else{
            //启动TLB转换器。
            lfutlbTransverter.transform(list,mapper,new LFU());
        }
    }

    private boolean isFull(){
        return  listSize==list.size();
    }

    public List<Mapper> getList() {
        return list;
    }

    public void setList(List<Mapper> list) {
        this.list = list;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
}
