import java.util.HashSet;

public interface JT_54_hastset {
    public static void main(String[] args) {
        HashSet<Integer> myhash = new HashSet<>();
        myhash.add(1);
        myhash.add(2);
        myhash.add(5);
        myhash.add(7);
        myhash.add(1);// HashSet doesnot stroes duplicate values or elements

        System.out.println(myhash);
    }
}
