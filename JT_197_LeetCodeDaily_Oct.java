import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JT_197_LeetCodeDaily_Oct {
//    1497. Check If Array Pairs Are Divisible by k
public boolean canArrange(int[] arr, int k) {
    int[] map = new int[k];
    for (int j : arr) {
        int x = ((j % k) + k) % k;
        map[x]++;
    }
    if(map[0]%2!=0)return false;
    System.out.println(Arrays.toString(map));
    for(int i =1;i<=k/2;i++){
        int x = k-i;
        if(map[x]!=map[i])return false;
    }
    return true;
}
    // 1331. Rank Transform of an Array
   static public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int idx = 0;
        for (int j : copy) {
            if (!hashMap.containsKey(j)) {
                hashMap.put(j, idx++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = hashMap.get(arr[i]) + 1;
        }
        return arr;
    }
//    567. Permutation in String
//   Find the all permutation of string (imp)
    // Brute Force Approach (TLE)
private static void permute(String str, String perm , HashSet<String> hashSet ) {
    // Base case: when the string is empty, print the permutation
    if (str.isEmpty()) {
        hashSet.add(perm);
        return;
    }

    // Recursively generate all permutations
    for (int i = 0; i < str.length(); i++) {
        // Fix one character, and find permutations of the rest
        char fixedChar = str.charAt(i);
        String remaining = str.substring(0, i) + str.substring(i + 1);
        permute(remaining, perm + fixedChar,hashSet);
    }
}
    static public boolean checkInclusion(String s1, String s2) {
        HashSet<String>hashSet = new HashSet<>();
        permute(s1,"",hashSet);
        System.out.println(hashSet);
        for(int i =0;i<s2.length();i++){
            for(int j =i+1;j<=s2.length();j++){
                if(hashSet.contains(s2.substring(i,j))){
                    return true;
                }
            }
        }
        return false;
    }
    // Approach 2 sort then check with same length substring
    public boolean checkInclusion2(String s1, String s2) {
        char[] chr = s1.toCharArray();
        Arrays.sort(chr);
        StringBuilder str = new StringBuilder();
        for (char c : chr) {
            str.append(c);
        }
        // System.out.println("Str "+str);
        if(str.length()==1) {
            for (int i = 0; i < s2.length(); i++) {
                if(str.charAt(0)==s2.charAt(i))return true;
            }
        }
        else{
            for(int i =0;i<s2.length();i++) {
                if (i + str.length() <= s2.length()) {
                    String temp = s2.substring(i, i + str.length());
                    // System.out.println(temp);
                    char[] chrs = temp.toCharArray();
                    Arrays.sort(chrs);
                    StringBuilder str1 = new StringBuilder();
                    for (char c : chrs) {
                        str1.append(c);
                    }
                    // System.out.println("str1 " + str1);
                    if (str1.toString().contentEquals(str)) return true;
                }
            }
        }
        return false;
    }
 // Optimal Sliding window protocol
 public boolean checkInclusion3(String s1, String s2) {
     int s1len = s1.length();
     int s2len = s2.length();
     int []arr1 = new int[26];
     for(int i =0;i<s1len;i++){
         int c = (int)s1.charAt(i);
         arr1[c-97]++;
     }
     System.out.println(Arrays.toString(arr1));
     int []arr2 = new int[26];
     int i = 0;
     int j = 0;
     while (j<s2len){
         int p = (int)s2.charAt(j);
         arr2[p-97]++;
         if(j-i+1>s1len){
             arr2[(int) s2.charAt(i)-97]--;
             i++;
         }
         if(Arrays.equals(arr1,arr2)){
             return true;
         }
         j++;

     }
     return false;
 }
    public static void main(String[] args) {

    }
}
