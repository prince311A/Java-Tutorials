import java.util.ArrayDeque;

public class JT_47_deque {
    public static void main(String[] args) {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        p.add(4);
        p.add(50);
        p.add(1);
        System.out.println(p.getFirst());// both are method of arraydeque
        System.out.println(p.getLast());
        System.out.println();


    }
}