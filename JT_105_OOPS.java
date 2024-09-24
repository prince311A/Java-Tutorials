public class JT_105_OOPS {
    public static class Student{
        String name;
    }
    static void change(Student s){
        s.name = "rahul";
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "prince";
        System.out.println(s1.name); // prince
        change(s1); // actual value will be changed like array
        System.out.println(s1.name); // rahul


    }
}
