class Employee{
    private int id;
    private String name;
 public    void getdata(int x,String n){
        id = x;
        name = n;
    }
    void showdata(){
        System.out.println(id);
        System.out.println(name);
    }
}
public class JT_21_gettersetter {
    public static void main(String[] args) {
        Employee p= new Employee();
        p.getdata(12,"prince");
        p.showdata();
    }
}
