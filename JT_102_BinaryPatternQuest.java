public class JT_102_BinaryPatternQuest {
    //Q1) PWSkills videoNo.52 => esa sabse chota(minimum) number nikalna hai jisse kam ya baraber or (jisse jyada nahi) chocolate student m distribute kr de
    static boolean chocolateDistribution(int a[],int maxchoco,int m){
        int students = 1;
        int choco = 0;
        for(int i =0;i<a.length;i++){
            if(a[i]>maxchoco)return false;
            else if(choco+a[i]<=maxchoco){
                choco = choco+a[i];
            }
            else{
                students++;
                choco = a[i];
            }
        }
        if(m<students){
            return false;
        }
        else {
            return true;
        }
    }
    static int distributeChoclates(int a[],int m){
        int start =1;
        int end = (int)1e9;
        int ans = 0;
        while (start<=end){
            int mid = (start+end)/2;
            if(chocolateDistribution(a,mid,m)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    //Q2) PWSkills videoNo.52 ==>esa sabse bada(maximum) number jo kidz ke bich ki distance number se kam na ho
    static boolean maximumPossbile(int c[],int m,int miniDist) {
        int kids = 1;
        int lastKidPlaced = c[0];
        for (int i = 1; i < c.length; i++) {
            if (c[i] - lastKidPlaced >= miniDist) {
                kids++;
                lastKidPlaced = c[i];
            }
        }
        if (kids >= m) {
            return true;
        } else {
            return false;
        }

    }
    static int carRace(int c[],int m){
        int start = 1;
        int end = (int)1e9;
        int ans = 0;
        while (start<=end){
            int mid = (start+end)/2;
            if(maximumPossbile(c,m,mid)){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int []a = {5,3,1,4,2};
        int m1 = 3;
        int b[] = {12,34,67,90};
        int m2 = 2;
      //  System.out.println(distributeChoclates(a,m1));
       // System.out.println(distributeChoclates(b,m2));

        int c[]  = {1,2,4,8,9};
        System.out.println(carRace(c,3));
        System.out.println(carRace(c,2));

    }
}
