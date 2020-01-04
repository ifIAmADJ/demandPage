package entity;

import replacement.Replacement;
import util.Transverter;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class SnapTable<E extends Comparable<E> & Tag,R extends Replacement> {

    //泛型不可以使用构造函数，只能通过外部传入。
    private R r;
    private Transverter<E,R> ERTransverter;
    private List<E> list;
    private int listSize;
    /**
     * 构造函数
     * @param listSize 声明所有的listSize。
     */
    public SnapTable(int listSize,R r) {
        this.listSize = listSize;
        this.r=r;
        ERTransverter=new Transverter<>();
        list=new LinkedList<>();
    }


    /**
     * 检查某个元素是否在该表中.为了规定标准,需要实现Tag接口.
     * @param QueryNumber 传入寻找的key.(比如说页数)
     * @return 若寻找到对应的元素E,则返回.
     */
    public E TryGet(int QueryNumber){

        E temp=null;

        for(E e:list)
        {
            if(e.getKey()==QueryNumber)
            {
                e.clearLast();
                temp=e;
                System.out.println("SnapTable::找到了元素");
                continue;
            }

            e.updateLast();

        }

        return temp;

    }

    /**
     * 构造函数
     * @param listSize 声明所有的listSize。
     */
    public SnapTable (int listSize,Class<R> rClass) {
        this.listSize = listSize;
        try {

            r= rClass.getDeclaredConstructor().newInstance();

        }catch (NoSuchMethodException |InstantiationException |InvocationTargetException |IllegalAccessException e)
        {
            e.printStackTrace();
        }
        ERTransverter=new Transverter<>();
        list=new LinkedList<>();
    }

    /**
     * 尝试在表中添加新的元素。如果该表已经满了，那么则启动替换器。
     * @param e 尝试添加的元素。
     */
    public void add(E e){

        //如果表没有满
        if(!isFull()) {
            list.add(e);
        }else{
            System.out.println("SnapTable::启动LFU转换器。");
            ERTransverter.transform(list,e,r);
        }
    }

    /**
     * 判断该表是否已经满了。
     * @return 返回结果。
     */
    private boolean isFull(){
        return  listSize==list.size();
    }

    //---------SET与GET方法-----------//
    public R getR() {
                return r;
            }

            public void setR(R r) {
                this.r = r;
            }

            public List<E> getList() {
                return list;
            }

            public void setList(List<E> list) {
                this.list = list;
            }

            public int getListSize() {
                return listSize;
            }

            public void setListSize(int listSize) {
                this.listSize = listSize;
            }
}
