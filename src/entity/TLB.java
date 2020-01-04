package entity;

import java.util.LinkedList;
import java.util.List;
/**
 * 适配器模式构造快表。
 * @author liJunhu
 */
public class TLB {

    private List<Mapper> list=new LinkedList<>();
    private int listSize;

    public TLB(int listSize) {
        this.listSize = listSize;
    }

    public void add(Mapper mapper){
        list.add(mapper);
    }

    public boolean isFull(){
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
