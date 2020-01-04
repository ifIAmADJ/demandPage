package abstracts;

import entity.*;
import replacement.LFU;

@SuppressWarnings("all")
public class AddressTransverter extends AbstractAddressTransverter {

    //建立一个表查询器
    private SnapTableQuery<Mapper> snapTableQuery;

    private Memory memory;

    private SnapTable<Mapper, LFU> pte;

    private SnapTable<Mapper,LFU> tlb;


    public AddressTransverter(int MemorySize,int pteSize,int tlbSize) {

        memory=new Memory(MemorySize);

        //该pte是个快表.
        pte=new SnapTable<>(pteSize,LFU.class);

        //该tlb是个普通页表.
        tlb=new SnapTable<>(tlbSize,LFU.class);

        //初始化表查询器.
        snapTableQuery=new SnapTableQuery<>(pte,tlb,memory,Mapper.class);

    }

    @Override
    public ActualAddress transform(VirtualAddress virtualAddress) {


        Mapper mapper=snapTableQuery.query(virtualAddress);

        if(mapper!=null)
        {
            return new ActualAddress(mapper.getBlockNumber(),virtualAddress.getInnerAddress());
        }

        System.out.println("本次查询未能获取信息。");
        return null;
    }

    public void view(){
        System.out.println("打印页表信息：");
        memory.getBlockList().forEach(p->{
            System.out.println(p.toString());
        });


        System.out.println("打印快表信息：");
        pte.getList().forEach(p->{
            System.out.println(p.toString());
        });


        System.out.println("打印内存信息：");
        memory.getBlockList().forEach(p->{
            System.out.println(p.toString());
        });
    }
}
