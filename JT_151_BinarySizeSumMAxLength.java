public class JT_151_BinarySizeSumMAxLength {
    public static class Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
//    Q1) Find the size of the tree without using global variable
    static int size(Node root){ // T.C O(n)
        if(root==null)return 0;
       int left = size(root.left);
       int right = size(root.right);
       return left+right+1;
//       return 1+size(root.left)+size(root.right); // one line
    }
    //    Q2) Find the maximum element in the tree without using global variable
    static int max(Node root){ // T.C O(n)
        if(root==null)return Integer.MIN_VALUE;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int max1 = Math.max(leftMax,rightMax);
        return Math.max(root.data,max1);
    }
    //    Q3) Find the minimum element in the tree without using global variable
    static int min(Node root){ // T.C O(n)
        if(root==null)return Integer.MAX_VALUE;
        int leftMax = min(root.left);
        int rightMax = min(root.right);
        int max1 = Math.min(leftMax,rightMax);
        return Math.min(root.data,max1);
    }
    //    Q4) Find the sum of all element in the tree without using global variable
    static int sum(Node root){ // T.C O(n)
        if(root==null)return 0;
        int sumLeft = sum(root.left);
        int sumRight = sum(root.right);
        return root.data+sumLeft+sumRight;
    }
    //    Q5) Find the height of the tree
    static int height(Node root){ // T.C O(n)
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 0;
        int leftHeight = height(root.left);
        int rightHeight= height(root.right);
        int maxLeftRightHeight = Math.max(leftHeight,rightHeight);
        return 1+maxLeftRightHeight;
    }
    //    Q6) Print the elements of tree of the given level
    static void nthLevel(Node root, int n){
        if(root==null)return;
        if(n==1) System.out.print(root.data+" ");
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
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
        System.out.println(size(root));//6
        System.out.println(max(root));//11
        System.out.println(min(root));//2
        System.out.println(sum(root));//38
        System.out.println(height(root));//2

        int level2 = 2; // 4,10
        int level3 = 3; // 6,5,11
        nthLevel(root,3);
    }
}
