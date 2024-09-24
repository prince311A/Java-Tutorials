import java.util.LinkedList;
import java.util.Queue;

public class JT_157_BinaryTreeConstruct {
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    public static class Node{
        int data;
        Node left;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    public static void constructBFS(String[] str){
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
        display(root);
    }
    public static void main(String[] args) {
        String[] str = {"1","2","3","4","5","","6","","7","","","8","","","","9",""};
        constructBFS(str);

    }
}
