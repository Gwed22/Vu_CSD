package csd201_ws03_bst_finddelete_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class BSTNode {

    /* Stores nodes information */
    private int data;
    private int count;
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    private int level;
    private int order;

    /* Updates Node information */
    public enum NodeType {
        LEFT_CHILD,
        RIGHT_CHILD
    }

    /* For drawing */
    private static final int LEVEL_DY = 60;
    private int x;
    private int y;
    private int width;

    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = this.order = 0;

        this.width = this.x = this.y = 0;
    }

    public BSTNode(int data, int yMin, int screenWidth) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = this.order = 0;

        this.width = this.x = screenWidth / 2;
        this.y = yMin;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
        if (this.leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (this.rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent, NodeType nodeType) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
        if (nodeType == NodeType.LEFT_CHILD) {
            this.order = parent.getOrder() * 2 + 1;
        } else {
            this.order = parent.getOrder() * 2 + 2;
        }

        this.width = parent.getWidth() / 2;
        if (nodeType == NodeType.LEFT_CHILD) {
            this.x = parent.getX() - width;
        } else {
            this.x = parent.getX() + width;
        }
        this.y = parent.getY() + LEVEL_DY;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean hasChild() {
        return !isLeaf();
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    public BSTNode findMaxNode() {
        BSTNode node = this;
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    public BSTNode findMinNode() {
        BSTNode node = this;
        while (node.hasLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    public boolean removeLeafChild(BSTNode node) {
        if (node == null) {
            return false;
        }
        if (node.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.getLeftChild().getData() == node.getData()) {
                    this.setLeftChild(null);
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.getRightChild().getData() == node.getData()) {
                    this.setRightChild(null);
                    return true;
                }
            }
        }
        return false;
    }
}
