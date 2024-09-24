import org.w3c.dom.ls.LSOutput;

public class JT_168_BST_MorrisTraversal_Inorder {
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
    // Morris Traversal
    public static void morrisTraversalInorder(Node root){
        Node curr = root;
        while (curr!=null){
            if(curr.left!=null){ // find predecessor
                Node pred = curr.left;
                while (pred.right!=null && pred.right!=curr){
                    pred =pred.right;
                }
                if(pred.right ==null){ // connect pred to cuurent
                    pred.right= curr;
                    curr = curr.left;
                }
                if(pred.right==curr){
                    pred.right = null;
                    System.out.print(curr.val+" ");
                    curr = curr.right;
                }
            }else{
                System.out.print(curr.val+" ");
                curr = curr.right;
            }
        }
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
        morrisTraversalInorder(root);
    }
}
