import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JT_160_BinaryTreeQuest {
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
    // Problem LEETCODE. 105 Construct BinaryTree with the help of given inorder and preorder traversal
    static Node helper(int[]preOrder,int preLo,int preHi,int[]inOrder,int inLo,int inHi){
        if(preLo>preHi)return null;
        Node root = new Node(preOrder[preLo]);
        int i = inLo;
        while (inOrder[i]!=preOrder[preLo])i++;
        int leftSize = i-inLo;
        root.left = helper(preOrder,preLo+1,leftSize+preLo,inOrder,inLo,i-1);
        root.right = helper(preOrder,leftSize+preLo+1,preHi,inOrder,i+1,inHi);
        return root;
    }
    static void constructTreeUsingTraversal(int[]preOrder,int[]inOrder){
        Node ans =  helper(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        display(ans);
    }
    //    *****************************************************************************
// Problem LEETCODE.112 Path Sum I
    // firstly we have to find every node to leaf  path
    static void nodeToLeaf(Node root, List<Integer>list,List<List<Integer>>ans){
        if(root==null)return;
        list.add(root.data);
        if(root.left==null && root.right==null){
            List<Integer>copy = new ArrayList<>();
            for(int i =0;i<list.size();i++){
                copy.add(list.get(i));
            }
            ans.add(copy);
        }
        nodeToLeaf(root.left,list,ans);
        nodeToLeaf(root.right,list,ans);
        list.remove(list.size()-1);
    }
    static void pathSum(Node root,int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        nodeToLeaf(root,list,ans);

        List<List<Integer>>mainAns = new ArrayList<>();
        for(int i = 0;i<ans.size();i++){
            List<Integer>temp =  ans.get(i);
            int sum = 0;
            for(int j =0;j<temp.size();j++){
                sum = sum+temp.get(j);
            }
            if(sum==targetSum){
                mainAns.add(temp);
            }
        }
        System.out.println(mainAns); // this is for sumPath II
    }
    // Optimized Approach
    static boolean pathSumOptimized(Node root,int targetSum){
        if(root==null)return false;
        if(root.left==null && root.right ==null){
            if(targetSum==root.data)return true;
        }
        return pathSumOptimized(root.left,targetSum-root.data) || pathSumOptimized(root.right,targetSum-root.data);
    }
    //    *****************************************************************************************
    // Problem 2) LEETCODE 113 Sum Path II
    static void pathSumIIHelper(Node root,int targetSum,  List<Integer> temp , List<List<Integer>> ans){
        if(root==null)return;
        temp.add(root.data);
        if(root.left==null && root.right ==null){
            if(targetSum==root.data){
                List<Integer>copy = new ArrayList<>();
                for(int i =0;i<temp.size();i++){
                    copy.add(temp.get(i));
                }
                ans.add(copy);
            }
        }
        pathSumIIHelper(root.left,targetSum-root.data,temp,ans);
        pathSumIIHelper(root.right,targetSum-root.data,temp, ans);
        temp.remove(temp.size()-1);
    }
    static List<List<Integer>>sumPathII(Node root,int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSumIIHelper(root,22,temp,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[]  preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
//      constructTreeUsingTraversal(preorder,inorder);
//      ****************************************************************
        Node root = new Node(5);
        Node a  = new Node(4);
        Node b  = new Node(11);
        Node e  = new Node(8);
        root.left = a;
        root.right = e;
        Node c  = new Node(7);
        a.left =b;
        Node d  = new Node(2);
        b.left = c;
        b.right = d;

        Node f  = new Node(13);
        Node g  = new Node(4);
        e.left = f;
        e.right = g;
        Node h  = new Node(1);
        Node i = new Node(5);
        g.right = h;
        g.left =i;
        pathSum(root,22);
//        System.out.println(pathSumOptimized(root,22));
//        ***********************************************************
        sumPathII(root,22);
        List<List<Integer>> ans = sumPathII(root,22);
        System.out.println(ans);
    }
}
