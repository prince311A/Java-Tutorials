public class JT_152_BinaryTraversals {
    // Traversing Tree in Preorder(N-L-R),Inorder(L-N-R), Postorder(L-R-N)
    // Time Complexity of all the traversals are in terms of level (2pow N) and in terms of node O(n)
    public static class Node{
        int data ;
     Node left ;
     Node right ;
        Node(int data){
            this.data = data;
        }
    }
    // this is to understand the 3 traversal and call of recursion
    static void pip(int n){
        if(n==0)return;
        System.out.print(n);
        pip(n-1);
        System.out.print(n);
        pip(n-1);
        System.out.print(n);
    }

    // Preorder(N-L-R)
    static void preorder(Node root){
        if(root==null)return;
        System.out.print(root.data+","); // node
        preorder(root.left); // left
        preorder(root.right); //right
    }
    // Inorder(L-N-R)
    static void inOrder(Node root){
        if(root==null)return;
        inOrder(root.left); // left
        System.out.print(root.data+","); // node
        inOrder(root.right); //right
    }
//    Postorder(L-R-N)
    static void postOrder(Node root){
        if(root==null)return;
        postOrder(root.left); // left
        postOrder(root.right); //right
        System.out.print(root.data+","); // node
    }
    // Level order Traversal (BFS)
    static int height(Node root){ // T.C O(n)
        if(root==null)return 0;
        if(root.left==null)return 0;
        if(root.right==null)return 0;
        int leftHeight = height(root.left);
        int rightHeight= height(root.right);
        int maxLeftRightHeight = Math.max(leftHeight,rightHeight);
        return 1+maxLeftRightHeight;
    }
    static void levelOrder(Node root,int n){
        if(root==null)return;
        if(n==1) System.out.print(root.data+" ");
        levelOrder(root.left,n-1); // left
        levelOrder (root.right,n-1); //right
    }
    // Most Imp*--> Level order traversal or BFS using queues without using recursion

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

//        pip(3); // this is to understand the 3 traversal and call of recursion

        preorder(root); //2,4,6,5,10,11
        System.out.println();
        inOrder(root);//6,4,5,2,10,11
        System.out.println();
        postOrder(root);// 6,5,4,11,10,2
        System.out.println();

        // For level order traversal we have to find the level
        System.out.println("Printing all the elements in level order: ");
        int level = 1+ height(root);
        for(int i =1;i<=level;i++){
            levelOrder(root,i);
            System.out.println();
        }

    }
}
