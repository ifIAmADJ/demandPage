package entity;

public class VirtualAddress implements Comparable<VirtualAddress>,Tag{

    private int pageNumber;
    private int innerAddress;
    private int outerAddress;
    private int last;

    public VirtualAddress(int pageNumber, int innerAddress,int outerAddress) {
        this.pageNumber = pageNumber;
        this.innerAddress = innerAddress;
        this.outerAddress =outerAddress;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
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

    public int getOuterAddress() {
        return outerAddress;
    }

    public void setOuterAddress(int outerAddress) {
        this.outerAddress = outerAddress;
    }

    @Override
    public int compareTo(VirtualAddress o) {
        return o.last-this.last;
    }

    @Override
    public int getKey() {
        return 0;
    }

    @Override
    public void updateLast() {
        last++;
    }

    @Override
    public void clearLast() {

    }
}
