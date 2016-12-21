package model;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class ListNode {

    private int vaule;
    private ListNode nextNode;

    public ListNode(int key) {
        this.vaule = key;
    }

    public int getKey() {
        return vaule;
    }

    public void setKey(int key) {
        this.vaule = key;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
