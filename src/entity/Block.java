package entity;

public class Block implements Comparable<Block>,Tag {


    private int blockNumber;
    private int last;

    public Block(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public int compareTo(Block o) {
        return o.last-this.last;
    }

    @Override
    public int getKey() {
        return blockNumber;
    }

    @Override
    public void updateLast() {
       last++;
    }

    @Override
    public void clearLast() {
        last=0;
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockNumber=" + blockNumber +
                ", last=" + last +
                '}';
    }
}
