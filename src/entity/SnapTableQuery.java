package entity;

public class SnapTableQuery<E extends Comparable<E> & Tag> {

    private SnapTable<E,?> pte;
    private SnapTable<E,?> tlb;
    private Memory memory;
    private Class<E> eClass;

    public SnapTableQuery(SnapTable<E, ?> pte, SnapTable<E, ?> tlb,Memory memory,Class<E> eClass) {
        this.pte = pte;
        this.tlb = tlb;
        this.memory=memory;
        this.eClass=eClass;
    }

    public E query(VirtualAddress virtualAddress){

        int QueryNumber=virtualAddress.getPageNumber();

        E e= pte.TryGet(QueryNumber);
        if(e==null)
        {
           System.out.println("SnapTableQuery::快表中没有该记录。搜查慢表。");
           e= tlb.TryGet(QueryNumber);
        }else
        {
            System.out.println("SnapTableQuery::在快表中找到了该记录，直接返回。");
            return e;
        }

        if(e==null)
        {
            //此刻慢表都没有,说明没有存放在内存中。这时候就要从外部调取。
            //读取虚拟内存在外存中实际存储的位置。
            memory.add(new Block(virtualAddress.getOuterAddress()));
            try {
                E e1=eClass.getDeclaredConstructor(int.class,int.class).newInstance(QueryNumber,virtualAddress.getOuterAddress());
                //System.out.println(e1.toString());
                System.out.println("SnapTableQuery::慢表中没有该记录。模拟调入内存。该条记录存储到了快表当中。");
                pte.add(e1);
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }

        }else{
            //若在慢表当中找到了.则放入快表当中。
            pte.add(e);
            System.out.println("SnapTableQuery::在页表中找到，调入到快表。");
        }

        return e;

    }

}
