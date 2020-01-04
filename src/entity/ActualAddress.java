package entity;

public class ActualAddress implements Comparable<ActualAddress>{

    private int blockNumber;
    private int innerAddress;
    private int last;

    public ActualAddress(int blockNumber, int innerAddress) {
        this.blockNumber = blockNumber;
        this.innerAddress = innerAddress;
        last=0;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getInnerAddress() {
        return innerAddress;
    }

    public void setInnerAddress(int innerAddress) {
        this.innerAddress = innerAddress;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public int compareTo(ActualAddress o) {
        return o.last-this.last;
    }
}
