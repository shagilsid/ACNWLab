package dsr;

public class Node {
    int sequenceNumber=0;
    int src;

    public Node(int src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return String.format("%d ",src);
    }
}
