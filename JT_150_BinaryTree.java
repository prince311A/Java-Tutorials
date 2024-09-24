public class JT_150_BinaryTree {
    // Implementing Binary Tree Manually
    public static class Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    // printing the child node with respect to parent by only passing root node through recursion
    static int size = 1; // calculating size of tree
    static void printTree(Node root){
        if(root ==null)return;
      System.out.print(root.data+"->");
        if(root.left!=null){
            System.out.print(root.left.data+",");
            size++;
        }
        else System.out.print("null,");
        if(root.right!=null){
            System.out.print(root.right.data);
            size++;
        }
        else System.out.print("null");
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        root.left = a; // linking
        root.right = b;  // linking
        Node c = new Node(6);
        a.left = c;// linking
        Node d = new Node(5);
        a.right = d;// linking
        Node e = new Node(11);
        b.right = e;// linking

        // printing the child node with respect to parent by only passing root node through recursion
        printTree(root);// pre order traversal
        System.out.println(size);

    }
}
