package ua.ruban.part5;

import java.util.Arrays;

public class Tree<E extends Comparable<E>> {

    private Node<E> root;
    private Node parent;
    private int pT;


    public boolean add(E e) {
        if (findEl(e)!=null){
            return false;
        }
        if (root == null){
            root = new Node<>(e);
        }else {
            addTo(root,e);
        }
        return true;
    }

    private boolean addTo(Node<E> node, E value){
        boolean res = false;
        if (value.compareTo(node.value)<0){
            if (node.left == null){
                node.left = new Node(value);
                res =true;
            }else {
                addTo(node.left, value);
            }
        }else {
            if (node.right == null){
                node.right = new Node(value);
                res =true;
            }else {
                addTo(node.right, value);
            }
        }
        return res;
    }

    public void add(E[] elements) {
        for (int i=0; i<elements.length; i++){
            add(elements[i]);
        }
    }

    public String nodeToString(Node nd){
        String nT ="";
        Node [] combinations = {nd.right, nd.left, null};
        if (nd.right != null){
            combinations = Arrays.copyOf(combinations,3);
            combinations[2] = nd.right.getLeft();
        }
        for (int i=0; i<combinations.length; i++){
            if (combinations[i] == null){
                nT = nT.concat("N");
            }else {
                nT = nT.concat("P");
            }
        }
        return nT;
    }

    public void oneParent(Node nodN, Node change){
        if (parent.left == nodN) {
            parent.left = change;
        } else {
            parent.right = change;
        }
    }

    public boolean remove(E element) {
        Node<E> nodeRem = findEl(element);
        if (nodeRem == null){
            return false;
        }
        String sw = nodeToString(nodeRem);
        switch (sw) {
            case "PPP":
                Node a = nodeRem.right.getLeft();
                Node b = nodeRem.right;
                b.setLeft(null);
                a.setRight(b);
                a.setLeft(parent.left.getLeft());
                parent.setLeft(a);
                break;
            case "PPN":
                if (parent.left == nodeRem) {
                    nodeRem.right.setLeft(nodeRem.left);
                    parent.left = nodeRem.right;
                } else {
                    nodeRem.right.setLeft(nodeRem.left);
                    parent.setRight(nodeRem.right);
                }
                break;
            case "NPN":
                oneParent(nodeRem, nodeRem.left);
                break;
            case "PNN":
                oneParent(nodeRem, nodeRem.right);
                break;
            case "NNN":
                oneParent(nodeRem, null);
                    break;
            default:
                return false;
        }
        return true;
    }


    public Node<E> findEl(E value){
        Node<E> current = root;
        parent = null;
        while (current !=null){
            int res = current.value.compareTo(value);
            if (res>0){
                parent = current;
                current = current.left;
            }
            if (res<0){
                parent = current;
                current = current.right;
            }
            if (res ==0){
                break;
            }
        }
        return current;
    }

    public void print() {
        inOrder(root);
    }

    public void inOrder(Node<E> node){
        pT+=2;
        if (node == null) {
            pT-=2;
            return;
        }
        inOrder(node.left);
        for (int i=0; i<pT-2; i++){
            System.out.print(" ");
        }
        System.out.println(node.value);
        inOrder(node.right);
        pT-=2;
    }

    private static class Node<E extends Comparable<E>> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        Node(E element) {
            this.value = element;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
