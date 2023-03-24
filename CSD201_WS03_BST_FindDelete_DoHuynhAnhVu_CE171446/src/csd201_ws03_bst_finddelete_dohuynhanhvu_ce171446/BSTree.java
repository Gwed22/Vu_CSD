package csd201_ws03_bst_finddelete_dohuynhanhvu_ce171446;

import java.util.ArrayList;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class BSTree {

    /* Binary Search Tree information */
    private BSTNode root;
    private String result;
    ArrayList<BSTNode> path;

    /* For drawing */
    private int screenWidth;
    private int yMin;

    public BSTree() {
        root = null;
        result = "";
        screenWidth = yMin = 0;
        path = new ArrayList<>();
    }

    public BSTree(int yMin, int screenWidth) {
        root = null;
        result = "";
        this.screenWidth = screenWidth;
        this.yMin = yMin;
        path = new ArrayList<>();
    }

    public BSTNode getRoot() {
        return this.root;
    }

    public String getTraversalResult() {
        return this.result;
    }

    public void addNode(int data) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
        } else {
            BSTNode node = root;
            boolean isAdd = false;
            while (!isAdd) {
                if (data < node.getData()) {
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild();
                    } else {
                        node.setLeftChild(new BSTNode(data));
                        isAdd = true;
                    }
                } else if (data > node.getData()) {
                    if (node.hasRightChild()) {
                        node = node.getRightChild();
                    } else {
                        node.setRightChild(new BSTNode(data));
                        isAdd = true;
                    }
                } else {
                    node.setCount(node.getCount() + 1);
                    isAdd = true;
                }
            }
        }
    }

    public void preOrder() {
        this.result = "";
        preOrder(this.root);
    }

    public void preOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.getCount(); i++) {
            result += "," + node.getData();
        }
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    public void inOrder() {
        this.result = "";
        inOrder(this.root);
    }

    public void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        for (int i = 0; i < node.getCount(); i++) {
            result += "," + node.getData();
        }

        inOrder(node.getRightChild());
    }

    public void postOrder() {
        this.result = "";
        postOrder(this.root);
    }

    public void postOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        for (int i = 0; i < node.getCount(); i++) {
            result += "," + node.getData();
        }
    }

    public ArrayList<BSTNode> getPath() {
        return this.path;
    }

    public BSTNode findNode(int data) {
        BSTNode node = this.root;
        result = "";

        path.clear();

        while (node != null) {
            System.out.print(node.getData() + " -> ");
            result += node.getData() + " -> ";
            path.add(node);
            if (data == node.getData()) {
                return node;
            } else if (data < node.getData()) {
                node = node.getLeftChild();
            } else if (data > node.getData()) {
                node = node.getRightChild();
            }
        }
        path.clear();
        return null;
    }

    public boolean removeNode(int data) {
        BSTNode node = findNode(data);
        return removeNode(node);
    }

    public boolean removeNode(BSTNode node) {
        if (node == null) {
            return false;
        }
        node.setCount(node.getCount() - 1);
        if (node.getCount() == 0) {
            if (node.isLeaf()) {
                node.getParent().removeLeafChild(node);
                return true;
            } else {
                BSTNode incomer = null;
                if (node.hasLeftChild()) {
                    incomer = node.getLeftChild().findMaxNode();
                } else {
                    incomer = node.getRightChild().findMinNode();
                }
                node.setData(incomer.getData());
                node.setCount(incomer.getCount());

                incomer.setCount(1);
                return removeNode(incomer);
            }
        } else {
            return true;
        }
    }
}
