import java.util.*;

public class JT_169_BST_Quest {
    public static class Node{
        int val;
     Node left;
     Node right;
        Node(int data){
            val = data;
        }
    }
    // Problem 1- LEETCODE.1305 All Elements in two BST
    static void morisTraversalInorder(Node root,List<Integer>ans){
        Node curr = root;
        while (curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while (pred.right!=null && pred.right!=curr)pred = pred.right;
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right==curr){
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
             ans.add(curr.val);
                curr = curr.right;
            }
        }
    }
    static void getAllElements(Node root1,Node root2){
        List<Integer>ans1 = new ArrayList<>();
        List<Integer>ans2 = new ArrayList<>();
        // Lets traverse both the BST by morris traversal in inorder way than add to array list
        morisTraversalInorder(root1,ans1);
        morisTraversalInorder(root2,ans2);
        System.out.println(ans1);
        System.out.println(ans2);
//        int arr1[] = new int[3];
//        int arr2[] = new int[3];
//        for(int i =0;i<ans1.size();i++){ // copying elements of arraylist to array
//            arr1[i] = ans1.get(i);
//        }
//        System.out.println(Arrays.toString(arr1));
//        for(int i =0;i<ans2.size();i++){ // copying elements of arraylist to array
//            arr2[i] = ans2.get(i);
//        }
//        System.out.println(Arrays.toString(arr2));

        // Lets sort the both sorted array in O(n) approach

//        int ansMain1[] = new int[arr1.length+arr2.length]; // by using array
        List<Integer>ansMain = new ArrayList<>(); // using arraylist

        int i=0;int j =0; int k = 0;

        // merging two sorted arrays
//        while(i<arr1.length && j< arr2.length){
//            if (arr1[i]<arr2[j]) {
//                ansMain[k++] = arr1[i];
//                i++;
//            }
//            if (arr1[i]>=arr2[j]) {
//                ansMain[k++] = arr2[j];
//                j++;
//            }
//        }
//        while (i<arr1.length)ansMain[k++] = arr1[i++];
//        while (j<arr2.length)ansMain[k++] = arr2[j++];

        // merging two sorted arraylist
        while(i<ans1.size() && j< ans2.size()){
            if (ans1.get(i)<=ans2.get(j)) {
                ansMain.add(ans1.get(i));
                i++;
            }
            if (ans1.get(i)>ans2.get(j)) {
                ansMain.add(ans2.get(j));
                j++;
            }

        }
        while (i<ans1.size())ansMain.add(ans1.get(i++));
        while (j<ans2.size())ansMain.add(ans2.get(j++));
//        System.out.println(Arrays.toString(ansMain1));
        System.out.println(ansMain);
    }

    public static void main(String[] args) {
        Node A1 = new Node(2);
        Node B1 = new Node(1);
        Node C1 = new Node(4);
        A1.left = B1;
        A1.right = C1;

        Node A2 = new Node(1);
        Node B2 = new Node(0);
        Node C2 = new Node(3);
        A2.left = B2;
        A2.right = C2;

        getAllElements(A1,A2);

    }
}
