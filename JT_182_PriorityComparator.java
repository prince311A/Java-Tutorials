import java.util.Comparator;
import java.util.PriorityQueue;
/*Comparable and Comparator
* Comparable --> Comparable provides a single sorting sequence. If we use Comparable it will affect the original class.
* Comparator --> Comparator provides multiple sorting sequences. The comparator will not affect the original class.
* */
class StudentData{
    String name;
    int rollNo;
    int marks;
}
// Here we use priority queue to compare between object of StudentData class
public class JT_182_PriorityComparator {
  private static class StudentComparator implements Comparator<StudentData>{

        public int compare(StudentData s1,StudentData s2) {
            if (s1.marks > s2.marks) return -1;
            else if (s2.marks > s1.marks) return 1;
            else {
                if (s1.rollNo > s2.rollNo) return -1;
                else if (s1.rollNo < s2.rollNo) return 1;
                else return 0;
            }
        }
    }
    public static void main(String[] args) {
        StudentData s1 = new StudentData();
        s1.name = "Prince Tiwari";
        s1.rollNo = 31;
        s1.marks = 65;

        StudentData s2 = new StudentData();
        s2.name = "Aman Singh";
        s2.rollNo = 5;
        s2.marks = 65;

        // comparing object of StudentData
        PriorityQueue<StudentData> pq = new PriorityQueue<>(new StudentComparator());
        pq.add(s1);
        pq.add(s2);

        System.out.println(pq.peek().name);
        System.out.println(pq.peek().rollNo);
        System.out.println(pq.peek().marks);
    }

}
