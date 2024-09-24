import java.util.Comparator;
import java.util.PriorityQueue;

public class JT_183_HeapQuest {
//    Q1) You are given set of points in XY plane. Find the k closest distance points from origin.
    // input-> (5,3),(1,2),(3,4),(5,6),(7,8),(9,10) o/p-> k = 3, (1,2),(3,4),(5,3)
    static class Points{
        int x ;
        int y ;
        int distance;
        Points(int x, int y){
            this.x =x;
            this.y =y;
            int dis = (int)Math.sqrt(  Math.pow((0-x),2) + Math.pow((0-y),2));
            distance = dis;
        }
}
// implementing comparator
   private static class PointsCompare implements Comparator<Points>{
        public int compare(Points p1, Points p2){
            if(p1.distance<p2.distance)return -1;
            else if(p1.distance>p2.distance)return 1;
            else return 0;
        }
}
public static void main(String[] args) {
        int k = 3; // how many closest points to find
        Points p1 = new Points(5,3);
        Points p2 = new Points(1,2);
        Points p3 = new Points(3,4);
        Points p4 = new Points(5,6);
        Points p5 = new Points(7,8);
        Points p6 = new Points(9,10);

    PriorityQueue<Points>pq = new PriorityQueue<>(new PointsCompare());
    pq.add(p1);
    pq.add(p2);
    pq.add(p3);
    pq.add(p4);
    pq.add(p5);
    pq.add(p6);

     for(int i =k;i>0;i--){
         System.out.println(pq.peek().x+" "+pq.peek().y+" = "+pq.peek().distance);
         pq.remove();
     }
}
}
