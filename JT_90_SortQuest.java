import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class JT_90_SortQuest {
//    (Q1.a) In the givrn array,move all the 0's  to the end of the array without changing the order i.e {0,5,0,3,42}
    // output -> {5,3,42,0,0} used bubble sort
    static void moveZeroEnd(int a[]){
        for(int i=0;i<a.length-1;i++){
            boolean flag = false;
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]==0 && a[j+1]!=0){
                    //(Q1.b) IF we want {0,0,5,3,42} then change the condition (a[j]!=0 a[j+1]==0)
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
//Q2) Sort the string of array in lexicographical manner use selection short algorithm
    static void lexicoSelection(String s[]){
        for(int i =0;i<s.length-1;i++){
            int min_idex = i;
            for(int j =i+1;j<s.length;j++){
                if (s[min_idex].compareTo(s[j])>0){
                    min_idex = j;
                }
                }
            String temp = s[i];
            s[i] = s[min_idex];
            s[min_idex] = temp;
            }
        System.out.println(Arrays.toString(s));
        }
//  Q3)- Given an array of strings arr[]. Sort given strings using Bubble Sort and display the sorted array
    static void lexicoBubble(String []c){
        for(int i =0;i<c.length-1;i++){
            for(int j =0;j<c.length-i-1;j++){
                if(c[j].compareTo(c[j+1])>0){
                    String temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(c));
    }
//    Q4) Given a string s, return the string which contains all characters of s in lexicographical order.coding->cdgino
    static void characterLexicalSort(String e){
        char d[] = e.toCharArray(); // String to char array
         for (int j =0;j<d.length-1;j++) {
            int min = j;
            for(int i =j+1;i<d.length;i++) {
                if ( d[min] >d[i]) {
                    min=i;
                }
            }
            char temp = d[j];
            d[j] = d[min];
            d[min] = temp;
        }
        System.out.println(Arrays.toString(d));
    }
//    Q5) - Given an array with N distinct elements, convert the given array to a form where all elements
//    are in the range from 0 to N-1. The order of elements is the same, i.e., 0 is placed in the place of the smallest
//    element, 1 is placed for the second smallest element, ... N-1 is placed for the largest element.
    static void sortWrtIndex(int e[]) {
        int a[]=e.clone();
        for(int i =1;i<a.length;i++){
            int j= i;
            while(j>0&& a[j]<a[j-1]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
        }
        int index[] = new int[a.length];
        int idx = 0;
        for(int i =0;i<a.length;i++){
            for( int j =0;j<a.length;j++){
                if(a[i]==e[j]){
                   index[idx++] = j;
                }
            }
        }
        e =index;
        System.out.println(Arrays.toString(e));
    }
    public static void main(String[] args) {
        int a [] = {0,5,0,3,42};
    //    moveZeroEnd(a);
        String b[]= {"papaya","lime","watermelon","apple","mango","kiwi"};
        lexicoSelection(b);
        String c[] = {"coding", "is","fun"};
      // lexicoBubble(c);
        String  d = "coding";
        //
        int e[] = {10,40,20};
//        sortWrtIndex(e);
    }
}
