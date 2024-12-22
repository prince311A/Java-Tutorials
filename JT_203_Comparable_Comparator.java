import java.util.*;

/*
* Comparable--> only single logic, compareTo(one arg), inside class, .lang
* Comparator--> multiple logic, compare(two arg), outside class, .util, support lambda exp.
* */
public class JT_203_Comparable_Comparator {
   static class Sort implements Comparable<Sort> {
        // Comparable can used under the class and we can define only single logic in it
        // compareTo() which requires only one argument
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Sort(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Sort{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Sort o) {
            return o.id - this.id;
        }
    }
    public static void main(String[] args) {
        sortStudentsAge();
        sortStringList();
        sort2DArrayList();
        sort2DArray();
    }

    //    Q0) Sort Students based on their age
    static void sortStudentsAge() {
        List<Sort> list = new ArrayList<>();
        list.add(new Sort(95, "prince"));
        list.add(new Sort(50, "rahul"));
        list.add(new Sort(41, "priya"));
        Collections.sort(list);
        System.out.println("Using Comparable " + list);
    }

    // Q1) Given 2D arraylist Sort it based on Oth index
    static void sort2DArrayList() {
        List<List<Integer>> mainList = new ArrayList<>();
        mainList.add(new ArrayList<>(Arrays.asList(2, 5)));
        mainList.add(new ArrayList<>(Arrays.asList(1, 6)));
        mainList.add(new ArrayList<>(Arrays.asList(8, 1)));
        mainList.add(new ArrayList<>(Arrays.asList(9, 2)));
        mainList.add(new ArrayList<>(Arrays.asList(7, 8)));
        System.out.println("Before Sorting :" + mainList);

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) > o2.get(0)) return 1;
                else return -1;
            }
        };
        Collections.sort(mainList, comparator);
        System.out.println("After Sorting :" + mainList);
    }

    // Q2) Given 2D array Sort it based on Oth index
    static void sort2DArray() {
        int[][] arr = {{2, 5}, {1, 6}, {8, 1}, {9, 2}, {7, 8}};
        Comparator<int[]> comparator1 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) return 1;
                else return -1;
            }
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]) + " ");
        }
        System.out.println();
        Arrays.sort(arr, comparator1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]) + " ");
        }
    }

    //    Q3) Sort List<String> Based on Length of String
    static void sortStringList() {
        // Using Comparator
        // Comparator can used outside the class and we can define multiple logic in it
        // compare() which requires two argument
        List<String> list1 = new ArrayList<>();
        list1.add("prince");
        list1.add("abc");
        list1.add("yakubmemon");
        list1.add("vandu");
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else return -1;
            }
        };
        Collections.sort(list1, comparator);
        System.out.println("Using Comparator :" + list1);
    }
}

