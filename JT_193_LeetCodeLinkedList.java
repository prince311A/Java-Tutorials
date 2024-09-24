public class JT_193_LeetCodeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
//    Q1) Add Two Numbers (LEETCODE.2)
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode temp1 = l1;
    ListNode temp2 = l2;
    ListNode ans = new ListNode(-1);
    ListNode tempAns = ans;
    int sum = 0;
    while (temp1 != null && temp2 != null) {
        sum = sum + temp1.val + temp2.val;
        if (sum < 10) {
            ListNode tempu2 = new ListNode(sum);
            tempAns.next = tempu2;
            tempAns = tempAns.next;
            sum = 0;
        } else {
            int diff = sum - 10;
            // System.out.println(diff);
            ListNode tempu1 = new ListNode(diff);
            tempAns.next = tempu1;
            tempAns = tempAns.next;
            sum = 1;
        }
        temp1 = temp1.next;
        temp2 = temp2.next;
    }

    while (temp1 != null) {
        sum = sum + temp1.val;
        if (sum < 10) {
            ListNode tempu2 = new ListNode(sum);
            tempAns.next = tempu2;
            tempAns = tempAns.next;
            sum = 0;
        } else {
            int diff = sum - 10;
            // System.out.println(diff);
            ListNode tempu1 = new ListNode(diff);
            tempAns.next = tempu1;
            tempAns = tempAns.next;
            sum = 1;
        }
        temp1 = temp1.next;
    }
    while (temp2 != null) {
        sum = sum + temp2.val;
        if (sum < 10) {
            ListNode tempu2 = new ListNode(sum);
            tempAns.next = tempu2;
            tempAns = tempAns.next;
            sum = 0;
        } else {
            int diff = sum - 10;
            // System.out.println(diff);
            ListNode tempu1 = new ListNode(diff);
            tempAns.next = tempu1;
            tempAns = tempAns.next;
            sum = 1;
        }
        temp2 = temp2.next;
    }
    if (sum == 1) {
        ListNode tempu1 = new ListNode(1);
        tempAns.next = tempu1;
    }
    return ans.next;
}
// Q2) Rotate List (LEETCODE 61)
public ListNode rotateRight(ListNode head, int k) {
    if (head == null)return null;
    if(head.next==null)return head;
    int size = 0;
    ListNode temp = head;
    ListNode last = null;
    while (temp != null) {
        size++;
        last = temp;
        temp = temp.next;
    }

    k = k % size;
    if(k==0)return head;
    temp = head;
    for (int i = 1; i < size - k; i++) {
        temp = temp.next;
    }
    ListNode rotate = temp.next;
    temp.next = null;
    last.next = head;
    return rotate;
}
    public static void main(String[] args) {

    }
}
