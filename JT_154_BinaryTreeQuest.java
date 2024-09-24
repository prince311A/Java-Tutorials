import java.util.*;

public class JT_154_BinaryTreeQuest {
    public static class Node{
        int data;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    // Problem 1: LEETCODE 543 Diameter of Binary Tree
    // we have to use height method
    public static int height(Node root){
        if (root==null)return 0;
        if(root.left==null &&root.right==null )return 0;
        int max = Math.max(height(root.left),height(root.right));
        return 1+max;
    }
    public static int diameterOfBinaryTree(Node root){
        if (root==null)return 0;
        if(root.left==null &&root.right==null )return 0;
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        int mid = height(root.left)+height(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null)mid++;
        int max = Math.max(leftDia,rightDia);
        return Math.max(max,mid);
    }
    // Problem 2: LEETCODE 110 Balance Binary Tree
    public  static boolean isBalanced(Node root) {
        if(root==null)return true;
        int leftTree = height(root.left);
        if(root.left!=null)leftTree++;
        int rightTree = height(root.right);
        if(root.right!=null)rightTree++;
        int diff = leftTree- rightTree;
        if(diff<0){
            diff =  -(diff);
        }
        if(diff>1)return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    // Problem 3 LEETCODE.100 Same Tree
    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)return true;
        if(p==null)return false;
        if(q==null)return false;
        if(p.data!=q.data)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    // Problem 4 LEETCODE.257 Binary Tree Path, // we have to find the root to leaf path
    public static void helper(Node root,List<String> ans,String s){
        if(root==null)return;
        if(root.left==null && root.right==null){
            s = s+root.data;
            ans.add(s);
            return;
        }
        helper(root.left,ans,s+root.data+"->");
        helper(root.right,ans,s+root.data+"->");
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
    }
    // Problem 5 LEETCODE.236 Lowest Common Ancestor
    public static void nodeToRoot(Node root,Node node, List<Integer> ans,List<Integer>temp){
        if(root==null)return;
        temp.add(root.data);
        if(root.data==node.data){
           for(int i = 0;i<temp.size();i++){
               ans.add(temp.get(i));
           }
            return;
        }
        nodeToRoot(root.left,node,ans,temp);
        nodeToRoot(root.right,node,ans,temp);
        temp.remove(temp.size()-1); // back tracking
    }
    public static void lowestCommonAncestor(Node root, Node p, Node q) {
        // we have to find the node to root path for p and q then we find the common node
        List<Integer> ans1 = new ArrayList<>(); // for root to p node
        List<Integer> ans2 = new ArrayList<>(); // for root to q node
        List<Integer> temp = new ArrayList<>();
        nodeToRoot(root,p,ans1,temp); // p=4
        temp = new ArrayList<>(); // is for empty the list
        nodeToRoot(root,q,ans2,temp); // q=5
        Collections.reverse(ans1);
        Collections.reverse(ans2);
        System.out.println(ans1);
        System.out.println(ans2);

        for(int i =0;i<ans1.size();i++){
            for(int j = 0;j<ans2.size();j++){
                if(ans1.get(i) == ans2.get(j)){
                    System.out.println(ans2.get(j));
                    return;

                }
            }
        }
    }
//    ***************************************************************************
public static boolean contains(Node root,Node node){
    if(root==null)return false;
    if(root==node)return true;
    return contains(root.left,node) || contains(root.right,node);
}
    public static Node llowestCommonAncestor(Node root, Node p, Node q) {
        if(p==q)return p;
        if(p==root || q==root)return root;
        boolean leftp = contains(root.left,p);
        boolean rightq = contains(root.right,q);
        if(leftp==true && rightq==true)return root;
        if(leftp==true && rightq==false)return llowestCommonAncestor(root.left,p, q);
        if(leftp==false && rightq==true)return llowestCommonAncestor(root.right,p, q);
        if(leftp==false && rightq==false)return root;
        return root;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node d = new Node(4);
        Node e = new Node(5);
        a.left = d;
        a.right = e;
//        System.out.println(diameterOfBinaryTree(root));
//***********************************************************************************************
        Node A = new Node(1);
        Node B= new Node(2);
        A.right = B;
        Node C = new Node(3);
        B.right = C;
//        System.out.println(isBalanced(A));
//***************************************************************************************************
        // For p
        Node p = new Node(1);
        Node p1 = new Node(2);
        Node p2 = new Node(1);
        p.left = p1;
        p.right = p2;
        // For q
        Node q = new Node(1);
        Node q1 = new Node(1);
        Node q2 = new Node(2);
        q.left = q1;
        q.right = p2;
//        System.out.println(isSameTree(p,q));
//        *************************************************************************************************
//        List<String> ans = binaryTreePaths(root);
//        System.out.println(ans);
//        ************************************************************************************************
        Node A1 = new Node(3);
        Node B1 = new Node(5);
        Node C1 = new Node(1);
        A1.left = B1;
        A1.right = C1;
        Node D1 = new Node(6);
        Node E1 = new Node(2);
        B1.left = D1;
        B1.right = E1;
        Node F1 = new Node(0);
        Node G1 = new Node(8);
        C1.left = F1;
        C1.right = G1;
        Node H1 = new Node(7);
        Node I1 = new Node(4);
        E1.left = H1;
        E1.right = I1;
        lowestCommonAncestor(A1,B1,I1);

      Node ans =  llowestCommonAncestor(A1,B1,I1);
        System.out.println(ans.data);


    }
}
