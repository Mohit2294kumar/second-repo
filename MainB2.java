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
    }
}