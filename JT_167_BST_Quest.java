public class JT_167_BST_Quest {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            val = data;
        }
    }
    public static void displayInorder(Node root){
        if(root==null)return;
        displayInorder(root.left);
        System.out.print(root.val+" ");
        displayInorder(root.right);

    }
    // Important Concept REVERSE INORDER i.e right->root->left
    public static void reverseInorder(Node root){
        if(root==null)return;
        reverseInorder(root.right);
        System.out.print(root.val+" ");
        reverseInorder(root.left);
    }
    // Problem-1 LEETCODE 538. Convert BST to Greater Tree i.e update the value of every node to sum of all greater than the
    // val of node+node val it'self
    // Reverse Inorder traversal is applied
    static int prefix = 0;
    public static void inorder(Node root){
        if(root==null)return;
        inorder(root.right);
        prefix = prefix+root.val;
        root.val =  prefix;
        inorder(root.left);
    }
    public static Node greaterTree(Node root){
        inorder(root);
        System.out.println(prefix);
        return root;
    }
    //    Problem-2 LEETCODE .783 Minimum Distance Between BST Nodes
    static int minDiff = Integer.MAX_VALUE;
    static int min = 0;
    static Node prev = null;
    static public void inorder1(Node root){
        if(root==null)return;
        inorder1(root.left);
        if(prev==null)prev = root;
        else{
            min =Math.abs(prev.val - root.val);
            if(min<minDiff) minDiff = min;
            prev =root;
        }
        inorder1(root.right);
    }
    static public void minDiffInBST(Node root) {
        inorder1(root);
        System.out.println( minDiff);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        Node A = new Node(1);
        Node B = new Node(6);
        root.left = A;
        root.right = B;
        Node C = new Node(0);
        Node D = new Node(2);
        A.left  = C;
        A.right = D;
        Node E = new Node(5);
        Node F = new Node(7);
        B.left = E;
        B.right = F;
        Node G = new Node(3);
        Node H = new Node(8);
        D.right = G;
        F.right = H;
        displayInorder(root);
        System.out.println();
        reverseInorder(root);
//       ****************************************************************
        Node ans = greaterTree(root);
        displayInorder(ans);
        System.out.println();
//        *****************************************************************
        minDiffInBST(root);
    }
}
