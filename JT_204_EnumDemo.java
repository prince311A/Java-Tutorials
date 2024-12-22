import java.sql.SQLOutput;

class Working{
    // BY default Enum works like this
    public static final Working APPLE = new Working();
    public static final Working SAMSUNG = new Working();
    public static final Working ONEPLUS = new Working();
    public static final Working VIVO = new Working();
    public static final Working NOKIA= new Working();
}
enum Mobile{
    // this are object of Mobile which define with price
    APPLE(50),SAMSUNG(),ONEPLUS(25),VIVO(10),NOKIA(45);
    private int price;
    Mobile(int price){
        this.price = price;
    }
    Mobile(){}

    public int getPrice() {
        return price;
    }
}
public class JT_204_EnumDemo  {
    public static void main(String[] args) {
        System.out.println(Mobile.APPLE.getPrice());
    }
    }
