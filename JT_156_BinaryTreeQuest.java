import java.util.ArrayList;
import java.util.List;

public class JT_156_BinaryTreeQuest {
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

    //  Q1) LEETOCODE.103 Binary Tree Zigzag
    public static int height(Node  root){
        if(root ==null)return 0;
        if(root.left==null && root.right==null)return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1+ Math.max(leftHeight,rightHeight);
    }
    static void evenLevelOrder(Node root,int n,List<Integer>RLlist){ // print right to left
        if(root==null)return;
        if(n==1) RLlist.add(root.data);
        evenLevelOrder (root.right,n-1,RLlist); //right
        evenLevelOrder (root.left,n-1,RLlist); // left
    }
    static void oddLevelOrder(Node root,int n,List<Integer> LRlist){// print left to right
        if(root==null)return;
        if(n==1) LRlist.add(root.data);
        oddLevelOrder (root.left,n-1,LRlist); // left
        oddLevelOrder (root.right,n-1,LRlist); //right
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        Node a = new Node(9);
        Node b = new Node(20);
        root.right = b;
        root.left = a;
        Node c = new Node(15);
        Node d = new Node(7);
        b.left=c;
        b.right=d;
//        display(root);
//        System.out.println();
//        System.out.println(height(root));//3
//        ******************************************************************************
        // For level order traversal we have to find the level
        System.out.println("Printing all the elements in level order: ");
        int level = 1+ height(root);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i =1;i<=level;i++){
            List<Integer>list = new ArrayList<>();
            if(i%2==0){
                evenLevelOrder(root,i,list);
            }
            else {
                oddLevelOrder(root,i,list);
            }
            ans.add(list);
        }
        System.out.println(ans);






    }
}
