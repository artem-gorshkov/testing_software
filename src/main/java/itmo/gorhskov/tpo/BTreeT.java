package itmo.gorhskov.tpo;

import java.util.ArrayList;

public class BTreeT {
    public ArrayList<Integer> arrayList = new ArrayList<>();
    BTreeNode root;
    int MinDeg;

    // Constructor
    public BTreeT(int deg) {
        this.root = null;
        this.MinDeg = deg;
    }

    public ArrayList<Integer> traverse() {
        arrayList.clear();
        if (root != null) {
//            arrayList = root.traverse();
            arrayList.addAll(root.traverse());
        }
        System.out.println();
        return arrayList;
    }

    // Function to find key
    public BTreeNode search(int key) {
        arrayList.clear();
        BTreeNode tmp;
        tmp = root == null ? null : root.search(key);
        arrayList.addAll(root.arrayList);
        return tmp;
    }

    public void insert(int key) {

        if (root == null) {

            root = new BTreeNode(MinDeg, true);
            root.keys[0] = key;
            root.num = 1;
        } else {
            // When the root node is full, the tree will grow high
            if (root.num == 2 * MinDeg - 1) {
                BTreeNode s = new BTreeNode(MinDeg, false);
                // The old root node becomes a child of the new root node
                s.children[0] = root;
                // Separate the old root node and give a key to the new node
                s.splitChild(0, root);
                // The new root node has 2 child nodes. Move the old one over there
                int i = 0;
                if (s.keys[0] < key)
                    i++;
                s.children[i].insertNotFull(key);

                root = s;
            } else
                root.insertNotFull(key);
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }

        root.remove(key);

        if (root.num == 0) { // If the root node has 0 keys
            // If it has a child, its first child is taken as the new root,
            // Otherwise, set the root node to null
            if (root.isLeaf)
                root = null;
            else
                root = root.children[0];
        }
    }

    public void test() {
        root.test();
    }
}
