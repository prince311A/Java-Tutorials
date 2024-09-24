public class JT_170_BST_Quest {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            val = data;
        }
    }
    // Problem 1. LEETCODE.669 Trim Binary Search Tree
    public  static void helper(TreeNode root, int low, int high){
        if(root==null)return;
        while(root.left!=null){
            if(root.left.val<low)root.left = root.left.right;
            else if(root.left.val>high)root.left = root.left.left;
            else break;
        }
        while(root.right!=null){
            if(root.right.val>high)root.right = root.right.left;
            else if(root.right.val<low)root.right = root.right.right;
            else break;
        }
        helper(root.left,low,high);
        helper(root.right,low,high);
    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode temp = new TreeNode(Integer.MAX_VALUE);
        temp.left = root;
        helper(temp,low,high);
        return temp.left;
    }
    public static void main(String[] args) {
    }
}
