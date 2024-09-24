import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JT_163_BinaryTreeQuest {
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
    //    Problem LEETCODE 2385
// Steps to solve the problem
// step-1   find the start/infected node
    static Node getNode(Node root,int start){
        if(root==null)return null;
        if(root.data==start){
            return root;
        }
        Node left =  getNode(root.left,start);
        Node right = getNode(root.right,start);
        if(left==null)return right;
        else return left;
    }
    // step-2 We have to  make a hashmap where the parent node of every node will be stored
    static void getParentNodeOfEveryNode(Node root,HashMap<Node,Node>parent){
        if(root==null)return;
        if(root.left!=null)parent.put(root.left,root);
        if(root.right!=null)parent.put(root.right,root);
        getParentNodeOfEveryNode(root.left,parent);
        getParentNodeOfEveryNode(root.right,parent);
    }
    static void amountOfTime(Node  root,int start){
        Node node =  getNode(root,start); //step-1
//        System.out.println(node.data);// checking purpose
        HashMap<Node,Node>parent = new HashMap<>();
        getParentNodeOfEveryNode(root,parent); // step-2
//        for (var n:parent.entrySet()){
//            System.out.println(n.getKey().data+"->"+n.getValue().data);// checking purpose
//        }
        // step-3 Making que to traverse BFS
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        HashMap<Node,Integer>isVisited = new HashMap<>();
        isVisited.put(node,0);
        while (que.size()>0){
            Node temp = que.peek();
            int level = isVisited.get(temp);
            if(temp.left!=null && !isVisited.containsKey(temp.left)){
                que.add(temp.left);
                isVisited.put(temp.left,level+1);
            }
            if(temp.right !=null && !isVisited.containsKey(temp.right)){
                que.add(temp.right);
                isVisited.put(temp.right,level+1);
            }
            if(parent.containsKey(temp) &&  !isVisited.containsKey(parent.get(temp))){
                que.add(parent.get(temp));
                isVisited.put(parent.get(temp),level+1);
            }
            que.remove();
        }
        int max = -1;
        for(var m:isVisited.values()){
            max  = Math.max(m,max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(5);
        Node b = new Node(4);
        root.left = a;
        Node c = new Node(9);
        Node d = new Node(2);
        b.left = c;
        b.right = d;
        Node e = new Node(3);
        a.right = b;
        root.right = e;
        Node f = new Node(10);
        Node g = new Node(6);
        e.left = f;
        e.right = g;
//    display(root);//1,5,4,9,2,3,10,6
        amountOfTime(root,3);
    }
}
