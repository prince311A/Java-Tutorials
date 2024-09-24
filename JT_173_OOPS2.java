class Address{
    private String city;
    private String state;
    Address(String city,String state){
        this.city = city;
        this.state = state;
    }
     public String getCity() {
         return city;
     }
     public String getState() {
         return state;
     }
 }
 class Student{
     private String name;
     private Address address;

     public void setName(String name) {
         this.name = name;
     }
     public void setAddress1(String city,String state) {
        address = new Address(city,state); // tight coupling
        this.address = address;
     }
     public void setAddress(Address address){
         this.address = address;
     }
     public void display(){
         System.out.println("Name :"+name);
//         Address ad = getAddress(); we can directly use
         System.out.println("City :"+address.getCity());
         System.out.println("State:"+address.getState());
     }
 }
public class JT_173_OOPS2 {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Prince");
        Address ad = new Address("Rewa","MadhyaPradesh");  // firstly we set data to address class then get through student class
        st.setAddress(ad);

        // Below way is very very bad its a tight coupling
        st.setAddress1("Rewa","MadhyaPradesh"); // secondly we set data to student class only then get it

        st.display();
        // Here i have learned how we can use a class as a datatype in different class
        // firstly we set data to address class then get through student class
        // secondly we set data to student class only then get it
        // Above ways are tight coupled because we use 'new' keyword to create object of another class
        System.out.println("**************************************************");
        // This is very important example of also tight coupling but old approach (VVIMP)
        Student st1 = new Student();
        st1.setName("Rahul");
        st1.setAddress(new Address("Varanasi","U.P"));
        st1.display();

        // Loose coupling is achieved through dependency injection in Spring
    }

}
