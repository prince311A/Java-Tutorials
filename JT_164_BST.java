public class JT_164_BST {
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
    //    Problem-1. LEETCODE.700 (Searching) Find the target value is present in BST or not T.C O(logn)
    static boolean findTarget(Node root,int target){
        if(root==null)return false;
        if(root.data==target) return true;
        boolean left =false;
        boolean right=false;
        if(root.data>target){
            left= findTarget(root.left,target);
        }
        if(root.data<target){
            right =  findTarget(root.right,target);
        }
        return right||left;
    }
    // Problem-2 Insertion in BST LEETCODE.701
    static Node insertIntoBST(Node root, int val){
        if(root==null)return null;
        if(root.left==null && root.data>val){
            Node temp = new Node(val);
            root.left =  temp;
            return root;
        }
        if(root.right==null && root.data<val){
            Node temp = new Node(val);
            root.right =  temp;
            return root;
        }
        if(root.data>val) insertIntoBST(root.left,val);
        if(root.data<val)insertIntoBST(root.right,val);
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        Node a = new Node(20);
        Node b = new Node(60);
        root.left = a;
        root.right =b;
        Node c = new Node(17);
        Node d = new Node(34);
        a.left = c;
        a.right = d;
        Node e = new Node(55);
        Node f = new Node(89);
        b.left = e;
        b.right = f;
        Node g = new Node(10);
        c.left = g;
        Node h = new Node(28);
        d.left = h;
        Node i = new Node(70);
        f.left =i;
        Node j = new Node(14);
        g.right = j;

        display(root);
        System.out.println();
        System.out.println( findTarget(root,70));
//************************************************************************
        Node A  = new Node(4);
        Node B  = new Node(2);
        Node C  = new Node(7);
        A.left = B;
        A.right = C;
        Node D  = new Node(1);
        Node E  = new Node(3);
        B.left = D;
        B.right = E;
//        display(A);
//        System.out.println();
//      Node ans = insertIntoBST(A,5);
//        display(ans);
//        *****************************************************************
    }
}
