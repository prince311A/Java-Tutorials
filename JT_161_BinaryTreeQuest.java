public class JT_161_BinaryTreeQuest {
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
    // Problem LEETCODE.437 PATH SUM III
    public static int countPath(Node root,long targetSum){
        if(root==null)return 0;
        int count = 0;
        if((long)root.data==targetSum){
            count++;
        }
        return count+countPath(root.left,targetSum-(long)root.data)+countPath(root.right,targetSum-(long)root.data);
    }
    public static int pathSumIII(Node root, int targetSum) {
        if(root==null)return 0;
        int count = countPath(root,(long)targetSum);
        return count+pathSumIII(root.left,targetSum)+pathSumIII(root.right,targetSum);
    }
    public static void main(String[] args) {
        Node root =  new Node(10);
        Node a = new Node(5);
        Node b = new Node(-3);
        root.left =  a;
        root.right = b;
        Node c = new Node(3);
        Node d = new Node(2);
        a.left = c;
        a.right = d;
        Node e = new Node(11);
        b.right = e;
        Node f = new Node(3);
        Node g = new Node(-2);
        c.left =f;
        c.right = g;
        Node h = new Node(1);
        d.right = h;

        System.out.println(pathSumIII(root,8));

    }
}
