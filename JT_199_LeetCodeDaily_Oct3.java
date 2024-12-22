import java.util.*;

public class JT_199_LeetCodeDaily_Oct3 {
    //     1942. The Number of the Smallest Unoccupied Chair-->revise****
    // brute force
    public int smallestChair(int[][] times, int targetFriend) {
        int arrivalTarget = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) <= times[i][0]) {
                    // update to list
                    list.set(j, times[i][1]);
                    if (times[i][0] == arrivalTarget) {
                        // System.out.println(j);
                        return j;
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(times[i][1]);
                if (times[i][0] == arrivalTarget) {
                    // System.out.println(list.size()-1);
                    return list.size() - 1;
                }

            }
        }
        // System.out.println(list);
        return -1;
    }

    // optimized
    static public int smallestChair1(int[][] times, int targetFriend) {
        int arrivalTarget = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        int n = times.length;
        // Priority Queue for occupied chairs, storing {departTime, chairNo}
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Min heap for free chairs
        PriorityQueue<Integer> free = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!occupied.isEmpty() && times[i][0] >= occupied.peek()[0]) {
                free.add(occupied.poll()[1]);
            }

            if (free.isEmpty()) {
                occupied.offer(new int[]{times[i][1], count});

                if (times[i][0] == arrivalTarget)
                    return count;

                count++;
            } else {
                int top = free.poll();
                if (arrivalTarget == times[i][0]) {
//                    System.out.println(top);
                    return top;
                }
                occupied.add(new int[]{times[i][1], top});

            }


        }
        return -1;
    }

    //    2938. Separate Black and White Balls
    static public long minimumSteps(String s) {
        long count = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                count += ones;
            }
        }
        return count;
    }
    // 1405. Longest Happy String
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]); // max-heap

        if (a > 0) {
            pq.offer(new int[] { a, 'a' });
        }
        if (b > 0) {
            pq.offer(new int[] { b, 'b' });
        }
        if (c > 0) {
            pq.offer(new int[] { c, 'c' });
        }
        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            int currCount = pq.peek()[0];
            char currChar = (char) pq.peek()[1];
            pq.poll();

            if (str.length() >= 2 && str.charAt(str.length() - 1) == currChar
                    && str.charAt(str.length() - 2) == currChar) {
                if (pq.isEmpty()) {
                    return str.toString();
                }
                int nextCount = pq.peek()[0];
                char nextChar = (char) pq.peek()[1];
                pq.poll();

                str.append(nextChar);
                nextCount--;
                if (nextCount > 0) {
                    pq.add(new int[] { nextCount, nextChar });
                }
                if (currChar > 0) {
                    pq.add(new int[] { currCount, currChar });
                }

            } else {
                str.append(currChar);
                currCount--;
                if (currCount > 0) {
                    pq.add(new int[] { currCount, currChar });
                }
            }
        }
        return str.toString();
    }
    // 670. Maximum Swap
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        int[] idx = new int[str.length()];
        idx[idx.length - 1] = idx.length - 1;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) <= str.charAt(idx[i + 1])) {
                idx[i] = idx[i + 1];
            } else {
                idx[i] = i;
            }
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < chars[idx[i]]) {
                char temp = chars[i];
                chars[i] = chars[idx[i]];
                chars[idx[i]] = temp;
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
//1106. Parsing A Boolean Expression
    static char solve(List<Character> list, char operator) {
        if (operator == '!') {
            if (list.get(0) == 't') {
                return 'f';
            } else {
                return 't';
            }
        } else if (operator == '&') {
            for (Character character : list) {
                if (character == 'f') {
                    return 'f';
                }
            }
            return 't';

        } else if (operator == '|') {
            for (Character character : list) {
                if (character == 't') {
                    return 't';
                }
            }
            return 'f';

        }
        return 'w';// unreachable
    }

    static public boolean parseBoolExpr(String expression) {
        int len = expression.length();
        char x = '.';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (expression.charAt(i) != ')' && expression.charAt(i) != ',') {
                stack.add(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                x = solve(list, stack.pop());
                stack.add(x);
            }
        }
        // System.out.println(x);
        return x == 't';
    }
    // 1233. Remove Sub-Folders from the Filesystem
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            if(!(folder[i]).startsWith(list.get(list.size()-1)+"/")){
                list.add(folder[i]);
            }
        }
        return list;
    }
//    2501. Longest Square Streak in an Array
public int longestSquareStreak(int[] nums) {
    HashSet<Long> hashSet = new HashSet<>();
    for (int x : nums) {
        hashSet.add((long) x);
    }
    int max = 1;
    for (int i = 0; i < nums.length; i++) {
        int temp = nums[i];
        int count = 1;
        while (hashSet.contains((long) temp * temp)) {
            if ((long) temp * temp >= Integer.MAX_VALUE) {
                break;
            }
            count++;
            temp = temp * temp;

        }
        max = Math.max(count, max);
    }
    return max == 1 ? -1 : max;
}
}
