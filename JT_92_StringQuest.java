import java.util.Arrays;
/*Q1) Qs. Create an array to store companies -> "Bloomberg", "Microsoft", "Uber", "Google", "IBM", "Netflix"
a. Remove the first company from the array
 b. Remove Uber & Add Ola in its place
 c. Add Amazon at the end*/
public class JT_92_StringQuest {
    public static void main(String[] args) {
        String s[] = {"Bloomberg","Microsoft","Uber","Google","IBM","Netflix"};
        for(int i =0;i<s.length;i++) {
            if (s[i].equals("Bloomberg"))s[i] = "";
            if (s[i].equals("Uber")) s[i] = "Ola"; // Approach In Same Array
        }
        for(int i =1;i<s.length;i++)s[i-1] = s[i];
        s[s.length-1] ="Amazon";
        System.out.println(Arrays.toString(s));


        String f[] = {"Bloomberg","Microsoft","Uber","Google","IBM","Netflix"};
        String ans[] = new String[f.length];
        for (int i = 0;i<ans.length-1;i++){   // Approach Using An Extra Array
            ans[i] = f[i+1];
            if(f[i+1].equals("Uber"))ans[i] = "Ola";
        }
        ans[ans.length-1] = "Amazon";
        System.out.println(Arrays.toString(ans));

    }
}
