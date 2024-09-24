public class JT_165_BST_Deletion {
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
    // Problem-1 Delete the Node of BST having 0 child LEETCODE 450
    static Node deleteNoChild(Node root,int target){
        if(root==null)return null;
        if(root.data>target&&root.left.data==target){
            root.left = null;
        }
        if(root.data<target&& root.right.data==target){
            root.right = null;
        }
        if(root.data>target) deleteNoChild(root.left,target);
        if(root.data<target) deleteNoChild(root.right,target);
        return root;
    }
    // Problem-2 Delete the Node of BST having 1 child
    static Node delete1Child(Node root,int target) {
        if (root == null) return null;
        if (root.left!=null &&root.data > target && root.left.data == target) { // go left
            if (root.left.left == null && root.left.right == null) {
                root.left = null; // 0 child
            }
            if (root.left!=null&&root.left.left != null) root.left = root.left.left; // 1 Child
            else {
                if(root.left!=null)
                    root.left = root.left.right;
            }
        }

        if (root.right!=null && root.data<target && root.right.data == target) { // go right
            if (root.right.left == null && root.right.right == null) root.right = null; // 0 child
            if (root.right!=null && root.right.left != null) root.right = root.right.left; // 1 Child
            else{
                if(root.right!=null)
                    root.right = root.right.right;
            }
        }
        if(root.data>target) delete1Child(root.left,target);
        if(root.data<target) delete1Child(root.right,target);
        return root;
    }
    // Problem-3 Delete the Node of BST having 2 child
    static void deleteTwoChild(Node root,int target){
        if(root==null)return;
        if(root.left!=null && root.data>target && root.left.data==target){
//            if (root.left.left == null && root.left.right == null) root.left = null; // 0 child
//            if (root.left!=null&&root.left.left != null) root.left = root.left.left; // 1 Child
//            else {
//                if(root.left!=null)
//                    root.left = root.left.right;
//            }
            // code for two child
            // finding inorder Precedor
            if(root.left.left!=null) {
                Node precedor = root.left.left;
                while (root.left.left.right != null) precedor = precedor.right;
                precedor.right = root.left.right;
                root.left = precedor;
            }
        }
        if(root.right!=null && root.data<target && root.right.data==target) {
//            if (root.right.left == null && root.right.right == null) root.right = null; // 0 child
//            if (root.right != null && root.right.left != null) root.right = root.right.left; // 1 Child
//            else {
//                if (root.right != null)
//                    root.right = root.right.right;
//            }
            // code for two child
            if (root.right.left != null) {
                Node precedor = root.right.left;
                while (root.right.left.right != null) precedor = precedor.right;
                precedor.right = root.right.right;
                root.right = precedor;
            }
        }
        if(root.data>target) deleteTwoChild(root.left,target);
        if(root.data<target) deleteTwoChild(root.right,target);
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
//      Node ans  =  deleteNoChild(root,70);
//      display(ans);


//    Node ans1 = delete1Child(root,34);
//        display(ans1);

        deleteTwoChild(root,20);
        display(root);
        // summited to leetcode
    }
}
