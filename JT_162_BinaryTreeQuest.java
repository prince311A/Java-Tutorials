public class JT_162_BinaryTreeQuest {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    // Problem LEETCODE 114 FLATTEN Binary Tree to linked list
    public static void flatten(Node root) {
        if(root==null)return;
        Node leftTree = root.left;
        Node rightTree = root.right;
        flatten(leftTree);
        flatten(rightTree);
        root.right = leftTree;
        Node temp = leftTree;
        while(temp!=null && temp.right!=null){
            temp = temp.right;
        }
        if(temp!=null) temp.right = rightTree;
        else root.right = rightTree;
        root.left = null;
        return;
    }
    // optimized  in terms of space complexity (MORRIS TRAVERSAL)
    static void morrisTraversalFlattenBT(Node root){
        Node temp = root;
        while (temp!=null) {
            if (temp.left != null) {
                Node precedor = temp.left;
                while (precedor.right != null) precedor = precedor.right;
                precedor.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
            }
            temp = temp.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        root.left = a;
        root.right = d;
        a.left = b;
        a.right = c;
        d.right = e;

        flatten(root);
        display(root);
        System.out.println();
        morrisTraversalFlattenBT(root);
        display(root);
    }
}
