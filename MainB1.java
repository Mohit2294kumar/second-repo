//Implementation of Tree Data Structure using LinkedList
import java.util.*;
public class MainB1{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node builTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1) return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left=builTree(nodes);
            newNode.right=builTree(nodes);
            return newNode;
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
    public static void main (String[] args){
        int[] arr={27,19,5,-1,-1,4,10,-1,-1,23,-1,-1,2,1,-1,-1,10,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.builTree(arr);
        System.out.println(root.data);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(findDiameter(root));
        System.out.println(isBalanced(root));
    }
}