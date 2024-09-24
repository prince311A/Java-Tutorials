import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class JT_144_HashSet {
    /*HashSet Methods() ->
    * add() T.C O(1)
    * remove() T.C O(1)
    * contains T.C O(1)
    *  Properties --:
    * Unordered Insertion
    * Uniqueness
    * Hashing Internally
    * */
    static void introductionHashSet(){
        HashSet<String> hset = new HashSet<>();
        hset.add("prince");
        hset.add("rahul");
        hset.add("sonu");
        hset.add("prince"); // cannot inserted
        System.out.println(hset); // rahul,prince,sonu
        System.out.println(hset.size());//3
        hset.remove("sonu");
        System.out.println(hset);// rahul prince
        System.out.println(hset.size());//2
        System.out.println(hset.contains("prince"));//true
    }
//    Q1) Given an unsorted array of integers ,return length of the longest consecutive elements sequence (LEETCODE 128)
    // i/p -> {100,4,200,3,2,1} o/p-> 4 i.e 1,2,3,4
    static void consecutiveElementsBruteForce(int arr[]){ //T.C O(nlogn+n)
        Arrays.sort(arr);
        int max = -1;
        int count = 1;
        for(int i= 1;i<arr.length;i++){
            if(arr[i-1]+1 == arr[i]){
                count++;

                if(count>max){
                    max = count;
                }
            }
            else{
                count = 1;
            }
        }
        System.out.println("Longest Consecutive Elements Length: "+max);
    }
    // Optimized using hashSet T.C O(n)
    static void consecutiveElementsOptimized(int arr[]){
        HashSet<Integer> hset = new HashSet<>();
        for(int i =0;i< arr.length;i++){
            hset.add(arr[i]);
        }
        int max = -1;
        int length = 0;
        for(int i :hset){
            if(!hset.contains(i-1)){ // i is starting point of the sequence\
                int currNum = i;
                int currStreak =1; // length of current consecutive sequence

                while (hset.contains(currNum+1)){
                    currStreak++;
                    currNum = currNum+1;
                }
                if(currStreak>max){
                    max = currStreak;
                }
            }
        }
        System.out.println("Longest Consecutive Elements Length: "+max);
    }
//   Q3. Y$u are given n distinct pairs. Each pair is numbered fr$m 1 t$ n. All these pairs are initially put in a bag.
//Y$u need t$ pair up each number. Y$u take numbers $ne by $ne fr$m the bag and f$r each number y$u l$$k
//whether the pair $f this number has already been taken $ut $f the bag, $r n$t. If n$t (that means the pair $f
//this number is still in the bag), y$u put the current number $n the table in fr$nt $f him. Otherwise, y$u put
//b$th numbers fr$m the pair aside. Print the maximum number $f numbers that were $n the table at the
//same time. [Medium]
    // i/p -> 3, ==>2 1 1 3 2 3
    // o/p -> 2
    static void maxElementOnTable(int arr[]){
        HashSet<Integer> hset = new HashSet<>();
        int countElementOnTable = 0;
        for(int i =0;i<arr.length;i++){
            if (!hset.contains(arr[i])){
                hset.add(arr[i]);
                countElementOnTable = Math.max(countElementOnTable,hset.size());
            }
            else{
                hset.remove(arr[i]);

            }
        }
        System.out.println(countElementOnTable);
    }
   /* Q4) Given two arrays of length n, print union and intersections that contain union and intersection of the
    elements present in the given arrays. Order of elements in output doesn·t matter.
    */
    static void unionIntersection(int arr1[],int arr2[]){
        ArrayList<Integer> intersect= new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i= 0;i<arr1.length;i++){
            hashSet.add(arr1[i]);
        }
        for(int i = 0;i<arr2.length;i++){
            if(hashSet.contains(arr2[i])){
//                System.out.println("Intersection :"+arr2[i] );
                intersect.add(arr2[i]);
            }
            else{
                hashSet.add(arr2[i]);
            }
        }
        System.out.println("Intersection List: "+intersect);
        System.out.println("Union List: "+hashSet);
    }
    public static void main(String[] args) {
//        introductionHashSet();
        int arr[] = {100,4,200,3,2,1};//4
        int arr1[] = {0,3,7,2,5,8,4,6,0,1};//9
//        consecutiveElementsBruteForce(arr1);
//        consecutiveElementsOptimized(arr);

        int arr2[] = {2, 1, 1, 3, 2 ,3};//2
//        maxElementOnTable(arr2);

        int arr3[] ={10, 15, 4, 20};
        int arr4[] ={8, 4, 2, 10};
        unionIntersection(arr3,arr4);
     }
}
