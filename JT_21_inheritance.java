class animal{
    int animalid;
    String aniname;
    void fun1(){
        System.out.println("hewll");
    }

}
class bird extends animal{
    int birdid;
    String birdname;
    void setdata(){
        animalid = 101;
        aniname = "lion";
        birdid = 201;
        birdname = "peacock";
    }
    void showdata(){
        System.out.println(animalid);
        System.out.println(aniname);
        System.out.println(birdid);
        System.out.println(birdname);
    }
}
public class JT_21_inheritance {
    public static void main(String[] args) {
        bird b = new bird();
        b.setdata();//
        b.showdata();
//        animal c = new bird();
        b.fun1(); // valid because only access base class method

    }
}
