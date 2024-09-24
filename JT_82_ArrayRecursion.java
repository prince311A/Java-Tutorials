public class JT_82_ArrayRecursion {
//    Q1) Print all the elements of array by recursion
static void PrintArray(int arr[],int idx){
    if(arr.length==idx){
        return;
    }
    System.out.print(" "+arr[idx]);
    PrintArray(arr,idx+1);

}
//Q2) Find the maximum element in array by recursion
    static int FindMax(int arr[],int idx){
    if(idx == arr.length-1){
        return arr[idx];
    }
    int max = FindMax(arr,idx+1);
    if(max>arr[idx]){
        return max;
    }
    else {
        max = arr[idx];
        return max;
    }
    }
//Q3) Find the sum of all the elements of array by recursion
    static int SumOfArray(int []arr,int idx){
    if(idx==arr.length-1){
        return arr[idx];
    }
    int sum = SumOfArray(arr,idx+1);
    return arr[idx]+sum;
    }
//    Q4) Find the target element in the given array
    static boolean findTarget(int arr[],int idx,int target){
    if(idx>=arr.length){
        return false;
    }if(arr[idx]==target){
        return true;
    }
    if(findTarget(arr,idx+1,target)){
        return true;
    }
    else {
        return false;
    }
    }
//    Q5) Find the index of the number in given array by recursion
    static void IndexReturn(int arr[],int idx,int target){
    if(idx>=arr.length){
        return ;
    }
    if(arr[idx]==target){
        System.out.println(idx);
    }
    IndexReturn(arr,idx+1,target);
    }

    public static void main(String[] args) {
        int arr[] = {4,8,9,4,4,6};
       // PrintArray(arr,0);
       // System.out.println(FindMax(arr,0));
      //  System.out.println(SumOfArray(arr,0));
       // System.out.println(findTarget(arr,0,8));
        IndexReturn(arr,0,4);
}
}
