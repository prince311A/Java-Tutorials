import java.util.*;

import static java.util.Collections.*;

/*Traversal in N-Array Tree
* Here we only apply preorder and postorder only, not inorder
* Preorder-> first root then child
* PostOrder-> first child then root
* */

public class JT_176_GenericTrees {
    private static class Node{
        int data;
        List<Node> child;
        Node(int data){
            this.data = data;
            child = new ArrayList<>();
        }
    }
//    Q1) Traverse the tree in Preorder
    static void preOrder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.data+" ");
            return;
        }
        System.out.print(root.data+" ");
        int n = root.child.size();
        for(int i =0;i<n;i++){
            preOrder(root.child.get(i));
        }
    }
//    Q2) Traverse the tree in Postorder
    static void postOrder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.data+" ");
            return;
        }
        int n = root.child.size();
        for(int i =0;i<n;i++){
            postOrder(root.child.get(i));
        }
        System.out.print(root.data+" ");
    }
//    Q3) Traverse the tree in Level order Traversal (BFS)
    public static void levelOrder(Node root){
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0) {
            Node temp = queue.peek();
            if (!temp.child.isEmpty()) {
                int n = temp.child.size();
                for (int i = 0; i < n; i++) {
                    queue.add(temp.child.get(i));
                }
            }
            System.out.print(temp.data+" ");
            queue.remove();
        }
    }
    //    Q4) Find the node which has maximum value
    static int max = Integer.MIN_VALUE;
    public static void findMax(Node root){
        if(root.child.isEmpty()){
            if(max<root.data){
                max = root.data;
            }
            return;
        }
        if(max<root.data){
            max = root.data;
        }
        int size = root.child.size();
        for(int i =0;i<size;i++){
            findMax(root.child.get(i));
        }

    }
    //    Q4) Find the node which has maximum value without using global variable
    public static int maximumElement(Node root){
        if(root.child.isEmpty()){
           return root.data;
        }
         int n = root.child.size();
        for(int i =0;i<n;i++){
         int max = maximumElement(root.child.get(i));
        }
        return Math.max(max,root.data);
    }
    // Q5) convert N-array tree to its mirror image
    static void mirrorTree(Node root){
        if(root.child.isEmpty())return;
        int size = root.child.size();
        if(size==1)return;
        for(int i=0;i<size;i++){
            mirrorTree(root.child.get(i));
            reverse(root.child);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(30);
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));
        // adding to first child of root
        root.child.get(0).child.add(new Node(1));
        root.child.get(0).child.add(new Node(4));
        root.child.get(0).child.add(new Node(8));
        // adding to second child of root
        root.child.get(1).child.add(new Node(6));
        root.child.get(1).child.add(new Node(7));
        root.child.get(1).child.add(new Node(15));
        // adding to third child of root
        root.child.get(2).child.add(new Node(31));
        root.child.get(2).child.add(new Node(55));
        root.child.get(2).child.add(new Node(65));

        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        findMax(root);
        System.out.println(max);
        System.out.println(maximumElement(root));
        mirrorTree(root);
        levelOrder(root);




    }
}
