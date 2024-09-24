import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JT_141_HashMap {
    // All About Hash Map
    /*Methods
    * Default Capacity of hAshMap is 16.
     * put() -> use for insertion and updation
     * get() ->take only key returns value, if key exists other null if key doesn't exist
     * remove() -> remove pair if exists otherwise null
     *VVIMP -> In every map, it store two same or different datatype which defined as entrySet().But the data type used to store entrySet() is
     *  Map.Entry<dataType1,dataType2>
     * Map.Entry<dataType1,dataType2> has two important methods getKey() and getValue() if we have entrySet() then we can fetch key and value both or we can use var
     * */
    static void  hashMapMethods(){
        Map<Integer,String > hmap = new HashMap<>();
//        HashMap<String,Integer> hmap = new HashMap<>(); // also valid
        hmap.put(1,"Prince");
        hmap.put(3,"Sanjay");
        hmap.put(2,"Monu");
        hmap.put(4,"Tinu");

//        System.out.println(hmap);
// Traversing all the entries of HAshMAp - mutliple methods
        // i) fetching pair using keySet()
        for (Integer key:hmap.keySet()) {
            System.out.printf("Roll No is %d and Name is %s\n",key,hmap.get(key));
        }
        System.out.println("---------------------------------------------------------------");
        // ii) fetching pair using entrySet()
        for (Map.Entry<Integer,String> set:hmap.entrySet()) {
            System.out.printf("Roll No is %d and Name is %s\n", set.getKey(),set.getValue()); // IMP
        }
        System.out.println("---------------------------------------------------------------");
//         iii) fetching pair using values() or value set
//        for (String value: hmap.values()) {
//            System.out.printf("Roll No is %d and Name is %s\n", ,value); // IMP
//        }
//        System.out.println("---------------------------------------------------------------");
        // Not possible
        for (var set:hmap.entrySet()) {
            System.out.printf("Roll No is %d and Name is %s\n", set.getKey(),set.getValue()); // IMP
        }
        System.out.println("---------------------------------------------------------------");
    }
    //    Q1) Find the most frequent element in it. If there is multiple then print one of them
    static void mostfrequentWithoutHashmap(int arr[]){ // Time Complexity O(n+nlog)
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int maxFreqcy = 0; // for frequency
        int count = 1;
        int maxvar = arr[0]; // for arr[i]
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
                if(maxFreqcy<count){
                    maxvar = arr[i];
                    maxFreqcy = count;
                }
            }else {

                count = 1;

            }
        }
        System.out.println(maxFreqcy); // problem how we find which number has max frequecy
        System.out.println(maxvar); // so we use this
    }
    // Approach USing hashMap
    static void mostfrequentHashmap(int arr[]){// Time Complexity O(n)
        Map<Integer,Integer> frenqucy = new HashMap<>();
        for(int i =0;i<arr.length;i++){

            if(frenqucy.containsKey(arr[i])){
                frenqucy.put(arr[i],frenqucy.get(arr[i])+1);
            }else {
                frenqucy.putIfAbsent(arr[i],1);
            }
        }
        System.out.println(frenqucy);
        // lets finds element with max frequency
        int max_frequency = -1;
        int max_variable = 0;
        for(Integer key:frenqucy.keySet()){
            if(max_frequency<frenqucy.get(key)){
                max_frequency = frenqucy.get(key);
                max_variable = key;
            }
        }
        System.out.printf("%d has maximum %d Occurrence",max_variable,max_frequency);
    }
    public static void main(String[] args) {
//        hashMapMethods();
        int arr[] = {1,3,2,1,4,1};
//        mostfrequentWithoutHashmap(arr);// Time Complexity O(n+nlog)
        mostfrequentHashmap(arr);// Time Complexity O(n)

    }
}
