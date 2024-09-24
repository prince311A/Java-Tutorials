import java.util.*;
import java.util.stream.StreamSupport;

public class JT_153_BinaryTree_BFS_DFS {
    public static class Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    // Most Imp*--> Level order traversal or BFS using queues without using recursion
    public static void breadthFirstSearch(Node root){
        Queue<Node> que = new LinkedList<>();
        if(root!=null)que.add(root);
        while (que.size()!=0){
            Node temp = que.peek();
            if(temp.left!=null)que.add(temp.left);
            if(temp.right!=null)que.add(temp.right);
            System.out.print(temp.data+" ");
            que.remove();
        }
        System.out.println();
    }
    // Most Imp*--> Depth First Search or DFS using queues without using recursion
    // DFS in three ways inorder, preorder, postorder
    // Inorder DFS
public static List<Integer> inOrderDepthFirstSearch(Node root){ // Inorder
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (st.size()!=0){
            Node temp = st.peek();
            if (temp.left!=null){
                st.push(temp.left);
                temp.left= null; // VVIMP // here we are breaking the structure of tree
            }
           else {
                Node temp1 = st.peek();
                ans.add(temp1.data);
                st.pop();
                if(temp1.right!=null){
                    st.push(temp.right);
                }
            }
        }
        return ans;
}
    // PostOrder DFS
    public static List<Integer> postDepthFirstSearch(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (st.size()!=0){
            Node temp = st.peek();
            if(temp.left!=null){
                st.push(temp.left);
                temp.left = null;// VVIMP // here we are breaking the structure of tree
            }
            else if(temp.right!=null) {
                    st.push(temp.right);
                    temp.right =null;// VVIMP // here we are breaking the structure of tree
                }
            else {
                ans.add(temp.data);
                st.pop();
            }

        }
        return ans;
    }
    // PreOrder DFS
    static List<Integer> preDepthFirstSearch(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        ans.add(root.data);

        while (st.size()!=0){
            Node temp = st.peek();
            if(temp.left!=null){
                st.push(temp.left);
                ans.add(temp.left.data);
                temp.left =null;
            }
            else if(temp.right!=null){
                st.push(temp.right);
                        ans.add(temp.right.data);
                        temp.right = null;
            }
            else{
                st.pop();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        root.left = a; // linking
        root.right = b;  // linking
        Node c = new Node(6);
        a.left = c;// linking
        Node d = new Node(5);
        a.right = d;// linking
        Node e = new Node(11);
        b.right = e;// linking
        Node f = new Node(15);
        c.right = f;

//        breadthFirstSearch(root);

        // here we are breaking the structure of tree so we can see only correct output for one dfs traversal at one time

//       List<Integer>inOrderDFS= inOrderDepthFirstSearch(root);
//        System.out.println(inOrderDFS);

//        List<Integer> postOrder = postDepthFirstSearch(root);
//        System.out.println(postOrder);

        List<Integer> preOrder = preDepthFirstSearch(root);
        System.out.println(preOrder);
    }
}
