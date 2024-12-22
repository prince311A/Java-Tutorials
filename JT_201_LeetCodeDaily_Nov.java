import java.util.*;

public class JT_201_LeetCodeDaily_Nov {
    // 1957. Delete Characters to Make Fancy String
    // my approach
    public String makeFancyString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.add(s.charAt(0));
        boolean flag = false;
        int size = s.length();
        for (int i = 1; i < size; i++) {
            char curr = s.charAt(i);
            if (!flag && stack.peek() == curr) {
                flag = true;
                stack.add(curr);
            }

            else if (stack.peek() != curr) {
                stack.add(curr);
                flag = false;
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }

        return stringBuilder.toString();
    }
    // Optimized
    public String makeFancyString1(String s) {
        int size = s.length();
        if (size == 1 || size == 2)
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for (int i = 2; i < size; i++) {
            char curr = s.charAt(i);
            if (curr == sb.charAt(sb.length() - 1) && curr == sb.charAt(sb.length() - 2)) {
                continue;
            }
            sb.append(curr);
        }
        return sb.toString();
    }
//    3163. String Compression III
public String compressedString(String word) {
    StringBuilder str = new StringBuilder();
    int count = 1;
    int size = word.length();
    for (int i = 1; i < size; i++) {
        char curr = word.charAt(i);
        char prev = word.charAt(i - 1);
        if (count >= 9 && curr == prev) {
            str.append(count);
            str.append(prev);
            count = 1;

        } else if (curr != prev) {
            str.append(count);
            str.append(prev);
            count = 1;

        } else {
            count++;
        }
    }
    str.append(count);
    str.append(word.charAt(word.length() - 1));
    System.out.println(str);
    return str.toString();
}
    // 2601. Prime Subtraction Operation
    static boolean prime(int x) {
        for (int i = x - 1; i > 1; i--) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    static int primes(int idx, int[] nums) {
        int min = nums[idx];
        for (int i = nums[idx] - 1; i > 1; i--) {
            if (prime(i)) {
                if (idx == 0) {
                    min = Math.min(min, nums[idx] - i);
                } else if (nums[idx] - i > nums[idx - 1]) {
                    min = Math.min(min, nums[idx] - i);
                    return min;
                }
            }
        }
        return min;
    }

    static boolean isSorted(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1])
                return false;
        }
        return true;
    }

    static public boolean primeSubOperation(int[] nums) {
        if (isSorted(nums))
            return true;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            ;
            int prime = primes(i, nums);
            nums[i] = prime;
        }
        return isSorted(nums);
    }
//************************************************************************************
    // 2070. Most Beautiful Item for Each Query
    // Brute force My approach
public int[] maximumBeauty(int[][] items, int[] queries) {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    for (int[] item : items) {
        for (int j = 0; j < items[0].length; j++) {
            if (hashMap.containsKey(item[0])) {
                hashMap.put(item[0], Math.max(item[1], hashMap.get(item[0])));
            } else {
                hashMap.put(item[0], item[1]);
            }
        }
    }
//        System.out.println(hashMap);
    List<List<Integer>>list = new ArrayList<>();
    for (var x:hashMap.entrySet()){
        List<Integer>l = new ArrayList<>();
        l.add(x.getKey());
        l.add(x.getValue());
        list.add(l);
    }
//        System.out.println(list);
    for(int i =0;i<queries.length;i++){
        int x = queries[i];
        int maxBeauty = 0;
        for (List<Integer> l : list) {
            if (l.get(0) <= x) {
                maxBeauty = Math.max(maxBeauty, l.get(1));
            }
        }
        queries[i] = maxBeauty;
    }
    return queries;
}
// optimized
public int[] maximumBeauty1(int[][] items, int[] queries) {
    Arrays.sort(items, (a, b) -> a[0] - b[0]);
    int maxBeauty = items[0][1];
    for (int i = 1; i < items.length; i++) {
        if (items[i][1] > maxBeauty) {
            maxBeauty = items[i][1];
        }
        items[i][1] = maxBeauty;
    }
    for (int k = 0; k < queries.length; k++) {
        int x = queries[k];
        int start = 0;
        int end = items.length - 1;
        int max = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (items[mid][0] <= x) {
                start = mid + 1;
                max = items[mid][1];
            } else {
                end = mid - 1;
            }
        }
        queries[k] = max;
    }
    return queries;
}

}

