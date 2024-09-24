import java.util.LinkedList;
import java.util.Queue;

public class JT_158_BinaryTreeBoundaryTraversal {
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
    public static Node constructBFS(String[] str){
        Queue<Node> que = new LinkedList<>();
        Node root = new Node(Integer.parseInt(str[0]));
        que.add(root);
        int i = 1;
        while (i< str.length-1){
            Node mainTemp = que.peek();
            if(!str[i].equals("")){
                Node temp = new Node(Integer.parseInt(str[i]));
                mainTemp.left = temp;
                que.add(temp);
            }
            if(!str[i+1].equals("")){
                Node temp1 = new Node(Integer.parseInt(str[i+1]));
                mainTemp.right = temp1;
                que.add(temp1);
            }
            que.remove();
            i = i+2;
        }
        return root;
    }
    // Problem: Boundary Printing
    static void leftBoundary(Node root){
        if(root==null)return;
        if(root.left!=null || root.right!=null){
            System.out.print(root.data+" ");
        }
        leftBoundary(root.left);
        if(root.left==null)leftBoundary(root.right);
    }
    static void leafBoundary(Node root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            System.out.print(root.data+" ");
        }
        leafBoundary(root.left);
        leafBoundary(root.right);

    }
    static void rightBoundary(Node root){
        if(root==null)return;
        rightBoundary(root.right);
        if(root.right==null)rightBoundary(root.left);
        if(root.left!=null || root.right!=null){
            System.out.print(root.data+" ");
        }

    }
    public static void boundaryTraversal(Node root){
        leftBoundary(root);
        leafBoundary(root);
        rightBoundary(root.right);
    }
    public static void main(String[] args) {
        // constructing the tree
        String str[] ={"1","2","3","4","5","","6","7","","8","","9","10","","11","","12","","13","","14","15","16","","17",
                "","","18","","19","","","","20","21","22","23","","24","25","26","27","","","28","",""};
        Node root =  constructBFS(str);
//       display(root);
        boundaryTraversal(root);


    }
}

