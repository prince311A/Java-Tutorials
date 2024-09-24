import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class JT_166_BST_Quest {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            val = data;
        }
    }

    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
    // Problem-1 Lowest Common Ancestor of BST LEETCODE 235
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(p==q)return p;
        if(p==root|| q==root)return root;
        if(p.val>root.val && q.val<root.val)return root;
        if(p.val<root.val && q.val>root.val)return root;
        if(p.val<root.val && q.val<root.val)return  lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val && q.val>root.val)return  lowestCommonAncestor(root.right,p,q);
        return root;

    }
    // Problem-2 Find the inorder predecessor and successor of given BST
    // Approach 1- We should inorder traverse the BST and store in ArrayList then find the key in list and return +1dx & -1idx
    // Approach 2- We can the save the space complexity by using global variable for predecessor and successor
    // Making global variable
    static int predecessor = -1;// stores value in inorder manner
    static int mainPrecedor = 0;// for main predecessor value
    static boolean successor = false;
    static int mainSuccessor = 0;// for main successor value
    public static void predecessorSuccessor(Node root,int key){
        // Approach -2
        if(root==null)return;
        predecessorSuccessor(root.left,key);
        if (root.val == key) {
            mainPrecedor = predecessor;
            successor=true;
        } else if (root.val>key&& successor==true) {
            mainSuccessor=root.val;
            successor=false;
        } else {
            predecessor = root.val;
        }
        predecessorSuccessor(root.right,key);
    }
    // Problem-3 LEETCODE 98 ValidateBinarySearchTree
    public static void inorder(Node root,List<Integer>arr){
        if(root==null)return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    static   public boolean isValidBST(Node root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        for(int i =1;i<arr.size();i++){
            if(arr.get(i-1)>=arr.get(i)){
                return false;
            }
        }
        return true;
    }
    // Problem-4 LEETCODE  108 Convert Sorted Array to BST
    public static Node recursive(int[] nums,int start,int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        Node node = new Node(nums[mid]);
        node.left =   recursive(nums,start,mid-1);
        node.right =   recursive(nums,mid+1,end);
        return  node;
    }
    public static Node sortedArrayToBST(int[] nums) {
        return recursive(nums,0,nums.length-1);
    }
    // Problem-5 LEETCODE.230. Kth Smallest Element in a BST
    static Node prev =  null;
    static int kth = 0;
    static int finl = 0;
    public static void inorder(Node root,int k){
        if(root==null)return;
        inorder(root.left,k);
        if(prev!=null && kth==k){
            finl = prev.val;
        }
        else{
            prev = root;
            kth++;
            if(kth==k){
                finl = prev.val;
            }
        }
        inorder(root.right,k);
    }
    static public int kthSmallest(Node root, int k) {
        inorder(root,k);
        return finl;
    }
    // Problem-6 LEETCODE 109 Convert Sorted List to Binary Search Tree
    public static class ListNode{
        int data; // store the data part of node
        ListNode next ; // store the address of next node

        ListNode(int data){
            this.data = data;
        }
    }
    public static Node binarySearch(int arr[],int start,int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left =  binarySearch(arr,start,mid-1);
        root.right =  binarySearch(arr,mid+1,end);
        return root;
    }
    public static Node sortedListToBST(ListNode head) {
        // Finding the size of linkedlist to make  array
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        // Copy the element of linked list to array
        temp =head;
        int arr[] = new int[n];
        int i =0;
        while(temp!=null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return binarySearch(arr,0,arr.length-1);
    }
    // Problem-7 LEETCODE 1008 Construct Binary Search Tree from Preorder Traversal
    public static Node insertIntoBST(Node root, int val) {
        if(root==null){
            Node temp = new Node(val);
            return temp;
        };
        if(root.left==null && root.val>val){
            Node temp = new Node(val);
            root.left =  temp;
            return root;
        }
        if(root.right==null && root.val<val){
            Node temp = new Node(val);
            root.right =  temp;
            return root;
        }
        if(root.val>val) insertIntoBST(root.left,val);
        if(root.val<val) insertIntoBST(root.right,val);
        return root;
    }
    public static Node bstFromPreorder(int[] preorder) {
        Node root = new Node(preorder[0]);
        for(int i =1;i<preorder.length;i++){
            root = insertIntoBST(root,preorder[i]);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        Node A = new Node(2);
        Node B = new Node(8);
        root.left = A;
        root.right = B;
        Node C = new Node(0);
        Node D = new Node(4);
        A.left  = C;
        A.right = D;
        Node E = new Node(7);
        Node F = new Node(9);
        B.left = E;
        B.right = F;
        Node G = new Node(3);
        Node H = new Node(5);
        D.left = G;
        D.right = H;
//        Node ans = lowestCommonAncestor(root,A,B);
//        System.out.println(ans.val);
//        ***********************************************************
        Node a = new Node(50);
        Node b = new Node(30);
        Node c = new Node(70);
        a.left =b;
        a.right = c;
        Node d = new Node(20);
        Node e = new Node(40);
        b.left = d;
        b.right = e;
        Node f = new Node(60);
        Node g = new Node(80);
        c.left = f;
        c.right = g;
        predecessorSuccessor(a,50);
        System.out.println(mainPrecedor);
        System.out.println(mainSuccessor);
//        ***********************************************************
        System.out.println(isValidBST(root));
//        *************************************************************
        int arr[] ={-10,-3,0,5,9};
        Node tree = sortedArrayToBST(arr);
        display(tree);
        System.out.println();
//     ***********************************************************
        System.out.println(kthSmallest(root,1));
//        **********************************************************
        ListNode a1 = new ListNode(-10);
        ListNode b1 = new ListNode(-3);
        ListNode c1= new ListNode(0);
        ListNode d1 = new ListNode(5);
        ListNode e1 = new ListNode(9);
        a1.next = b1;
        b1.next =  c1;
        c1.next = d1;
        d1.next  =e1;
        Node tree2 = sortedListToBST(a1);
        display(tree2);
        System.out.println();
//        **********************************************************
        int ab[] = {8,5,1,7,10,12};
        Node tree3 = bstFromPreorder(ab);
        display(tree3);
        System.out.println();

    }
}
