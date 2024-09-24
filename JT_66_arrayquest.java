import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class JT_66_arrayquest {
    //Q1) Print the sum of the values in given range which start from 1 to r?
    static void returnSum(int ar[],int x,int y){
        int sum =0;
        for(int i=x;i<=y;i++){
            sum = sum+ar[i];
        }
        System.out.println("The sum of element from "+x+" to "+y+" is "+sum);
    }

    public static void main(String[] args) {
        int arr[] = new int[6];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the five elements of for the array");
        for(int i=1;i<=5;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the index from which you want the sum");
        int x = sc.nextInt();
        System.out.println("Enter the index upto which you want the sum");
        int y = sc.nextInt();
        returnSum(arr,x,y);
        // Lets do this without tranversing on array evertime
        for(int i =1;i<=arr.length-1;i++){
            arr[i] = arr[i-1]+arr[i];
        }
        int sum = arr[y]-arr[x-1];
        System.out.println("The sum of element is "+sum);
//        *********************************************************************************************
    // Calculate the suffix sum
        // For example {1,2,3,4,5} ==> {15,14,12,9,5}
//        int arr1[] = new int[5];
//        System.out.println("Enter the five elements of for the array");
//        for(int i=0;i<arr1.length;i++){
//            arr1[i] = sc.nextInt();
//        }
//        for(int i =arr1.length-2;i>=0;i--){
//            arr1[i]= arr1[i+1]+arr1[i];
//
//       }
//        System.out.println("Here is the suffix sum of array");
//        for(int i = 0;i<arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }
    }
    }

