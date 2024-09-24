import java.nio.file.NotDirectoryException;

public class JT_155_BinaryTreeQuest {
    public static class Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    // Function of traversal
    public static void display(Node root){ // preorder
        if(root==null)return;
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    // Problem 1) LEETCODE.226 Invert Binary Tree
    public static void invertBinaryTree(Node root){
        if(root==null)return;
      Node temp = root.left;
      root.left = root.right;
      root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
    // Problem 2) LEETCODE.101 Symmetric Tree
    // here we have to take help of two methods same tree and invert tree
   public static boolean sameTree(Node p,Node q){
        if(p==null && q==null)return true;
        if(p==null && q!=null)return false;
        if(p!=null && q==null)return false;
        if(p.data!=q.data)return false;
        return sameTree(p.left,q.left) && sameTree(p.right,q.right);
    }
//   public static boolean symmetricTree(Node root){
//
//    }
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
//        *****************************************************************************
        display(root);// 2,4,6,5,10,11
        System.out.println();
        invertBinaryTree(root);
        display(root);// 2,10,11,4,5,6
//        *****************************************************************************
//        System.out.println( symmetricTree(root));
    }
}
