import java.util.*;
public class MainB2 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        public static Node buildTree(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (root.data > data) {
                root.left = buildTree(root.left, data);
            } else {
                root.right = buildTree(root.right, data);
            }
            return root;
        }

        public static Node buildTree(int[] nodes) {
            Node root = null;
            for (int data : nodes) {
                root = buildTree(root, data);
            }
            return root;
        }
    }
    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> list=new LinkedList<Node>();
        list.add(root);
        list.add(null);
        while(!list.isEmpty()){
            Node currNode=list.remove();
            if(currNode==null){
                System.out.println();
                if(list.isEmpty()){
                    break;
                }else{
                    list.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    list.add(currNode.left);
                }
                if(currNode.right!=null){
                    list.add(currNode.right);
                }
            }
        }
    }
    public static boolean search(Node root, int key){
        if(root==null) return false;
        if(root.data==key){
            return true;
        }else if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }
    public static Node delete(Node root, int key){
        if(root==null) return root;
        if(root.data>key){
            root.left=delete(root.left, key);
        }else if(root.data<key){
            root.right=delete(root.right, key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.data=minValue(root.right);
            root.right=delete(root.right, root.data);
        }
        return root;
    }
    public static int minValue(Node root){
        int min=root.data;
        while(root.left!=null){
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
    public static int findDiameter(Node root){
        if(root==null) return 0;
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        int leftDiameter=findDiameter(root.left);
        int rightDiameter=findDiameter(root.right);
        return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter));
    }
    public static int findHeight(Node root){
        if(root==null) return 0;
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static boolean isBalanced(Node root){
        if(root==null) return true;
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {15, 10, 5, 14, 20, 19, 25};
        BinarySearchTree tree = new BinarySearchTree();
        Node root = tree.buildTree(arr);
        System.out.println(root.data); 
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        // System.out.println();
        if(search(root, 25)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        System.out.println(findDiameter(root));
        System.out.println(isBalanced(root));
        System.out.println(findHeight(root));
        root=delete(root, 20);
        levelOrder(root);
    }
}