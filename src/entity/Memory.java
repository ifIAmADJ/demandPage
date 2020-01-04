package entity;

import replacement.LFU;
import util.Transverter;

import java.util.LinkedList;
import java.util.List;

/**
 * 模拟内存
 */
public class Memory {

    //模拟内存的表。
    private List<Block> blockList=new LinkedList<>();
    private Transverter<Block,LFU> blockLFUTransverter=new Transverter<>();

    private int listSize;

    public Memory(int listSize) {
        this.listSize = listSize;
    }

    public void add(Block block){
        if(!isFull()) {
            blockList.add(block);
        }else{
            blockLFUTransverter.transform(blockList,block,new LFU());
        }
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    public void remove(Block block){
        blockList.remove(block);
    }

    public Block TryGet(int QueryNumber){

        Block temp=null;

        for (Block b:
             blockList) {

            if(b.getKey()==QueryNumber)
            {

                //对找到的元素b,last重置为0.
                b.setLast(0);
                temp=b;
                continue;
            }

            //对其他未使用的元素，last+1.
            b.setLast(b.getLast()+1);

        }

       return temp;

    }

    private boolean isFull(){
        return blockList.size()==listSize;
    }

}
