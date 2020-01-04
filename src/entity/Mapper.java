package entity;

/**
 * 页表中的映射项.
 * (快)表页号-内存块号
 */
public class Mapper implements Comparable<Mapper>,Tag {

    private int PageNumber;
    private int BlockNumber;
    private int last;

    public Mapper(int pageNumber, int blockNumber) {
        PageNumber = pageNumber;
        BlockNumber = blockNumber;
        last=0;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getBlockNumber() {
        return BlockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        BlockNumber = blockNumber;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public int compareTo(Mapper mapper) {
        return mapper.last-this.last;
    }

    @Override
    public int getKey() {
        return PageNumber;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "PageNumber=" + PageNumber +
                ", BlockNumber=" + BlockNumber +
                ", last=" + last +
                '}';
    }

    @Override
    public void updateLast() {
        last++;
    }

    @Override
    public void clearLast() {
        last=0;
    }
}
