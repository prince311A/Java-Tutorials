import org.w3c.dom.Node;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JT_159_BinaryTreeRightView {
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node constructBfs(String[] str){
        Node root  = new Node(Integer.parseInt(str[0]));
        Queue<Node>que = new LinkedList<>();
        que.add(root);
        int i =1;
        while (i<str.length-1){
            Node temp = que.peek();
            if(!str[i].equals("")){
                Node temp1 = new Node(Integer.parseInt(str[i]));
                temp.left = temp1;
                que.add(temp1);
            }if(!str[i+1].equals("")){
                Node temp1 = new Node(Integer.parseInt(str[i+1]));
                temp.right = temp1;
                que.add(temp1);
            }
            que.remove();
            i = i+2;
        }
        return root;
    }
    // Problem 1. LEETCODE(199) Right view binary Tree
    // Helper Methods
    public static int height(Node root){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 0;
        int  leftT = height(root.left);
        int rightT =height(root.right);
        return 1+ Math.max(leftT,rightT);
    }
    static void printNthLevel(Node root, int n, List<Integer>list){
        if(root==null)return;
        if(n==1) list.add(root.data);
        printNthLevel(root.left,n-1,list);
        printNthLevel(root.right,n-1,list);
    }
    public   static void rightViewBinaryTree(Node root){
        List<List<Integer>>mainList  = new ArrayList<>();
        int level = 1+height(root);
        for(int i =1;i<=level;i++){
            List<Integer>list = new ArrayList<>();
            printNthLevel(root,i,list);
            mainList.add(list);
        }
//        System.out.println(mainList);
//        System.out.println(mainList.size());
        List<Integer>ans = new ArrayList<>();
        for(int i =0;i<mainList.size();i++){
            List<Integer> l1 = mainList.get(i);
            for(int j =  0;j<l1.size();j++){
                if(j== l1.size()-1) ans.add(l1.get(j));
            }

        }
        System.out.println(ans);
    }
    // optimized Approach

    public static void preOrder(Node root,int level,List<Integer>list){
        if(root==null)return;
        list.set(level-1,root.data);

        preOrder(root.left,level+1,list);
        preOrder(root.right,level+1,list);


    }
    public static void rightViewOptimized(Node root){
        int level = height(root)+1;
//        System.out.println(level);
        List<Integer> list = new ArrayList<>();
        if(root==null)return;
        for(int i = 0;i<level;i++){
            list.add(100);
        }
        preOrder(root,1,list);
        System.out.println(list);
    }
    public static void main(String[] args) {
        String[] str = {"1","2","3","","5","","4"};
        Node ans =   constructBfs(str);
//     display(ans);
//       rightViewBinaryTree(ans);
        rightViewOptimized(ans);
    }
}
