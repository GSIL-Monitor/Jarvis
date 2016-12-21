package binary_tree;

/**
 * Created by apple on 16/6/18.
 */
public class BinaryTreeNode {

    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;
    private String root;

    public BinaryTreeNode() {
        this.leftNode = null;
        this.rightNode = null;
        this.root = null;
    }

    public BinaryTreeNode(String root) {
        this.leftNode = null;
        this.rightNode = null;
        this.root = root;
    }

    public BinaryTreeNode(BinaryTreeNode leftNode, BinaryTreeNode rightNode, String root) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.root = root;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
