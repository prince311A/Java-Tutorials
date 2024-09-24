import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  JT_171_BST_Quest {
    public static void displayInorder(Node root){
        if(root==null)return;
        displayInorder(root.left);
        System.out.print(root.val+" ");
        displayInorder(root.right);

    }
    public static class Node{
                int val;
        Node left;
        Node right;
        Node(int data){
            val = data;
        }
    }
    // Problem 1. LEETCODE 99. Recover BST
//    Approach 1-> Traverse inorder wise and Store all element in arratlist then again traverse inorder wise then replace
    // the node.val with the elements of arraylist T.C O(n) & S.C O(n)
    static void inorder(Node root, List<Integer>ans){
        if(root==null)return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    static int i = 0;
    static void inorderForReplace(Node root, List<Integer>ans){
        if(root==null)return;
        inorderForReplace(root.left,ans);
       root.val = ans.get(i++);
        inorderForReplace(root.right,ans);
    }
    static void recoverTree(Node root){
        List<Integer>ans = new ArrayList<>();
        inorder(root,ans);
//        System.out.println("Before Sorting"+ans);
        Collections.sort(ans);
//        System.out.println("After Sorting"+ans);
        inorderForReplace(root,ans);
    }
    // Approach.2 with T.C O(n) but Space complexity is O(1) using morris traversal with extra two pointers
    static void recoverTreeOptimized(Node root){
//       pending
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(2);
        root.left = a;
        root.right =b;
        b.left = c;
//        recoverTree(root);
//        displayInorder(root);

        recoverTreeOptimized(root);


    }
}
