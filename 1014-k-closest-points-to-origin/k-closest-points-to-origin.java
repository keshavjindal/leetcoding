class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(new Point(points[i][0] , points[i][1]));
        }

        // printPQ(pq);

        for(int i=k; i<points.length; i++){
            double cPointDist = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
            
            if(cPointDist < pq.peek().dist){
                pq.remove();
                pq.add(new Point(points[i][0] , points[i][1]));
            }
        }

        // printPQ(pq);

        int[][] ans = new int[k][2];
        int idx = -1;
        while(pq.size() > 0){
            idx++;

            ans[idx][0] = pq.peek().x;
            ans[idx][1] = pq.peek().y;

            pq.remove();
        }
        return ans;
    }

    public void printPQ(PriorityQueue<Point> pq){
        System.out.println("--------------");
        System.out.println("" + pq.peek().x + " " + pq.peek().y);
        System.out.println("--------------");
    }

    public class Point implements Comparable<Point>
    {
        int x;
        int y;
        double dist; // distance from origin

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x*x + y*y);
        }

        public int compareTo(Point other){
            if(this.dist < other.dist) return 1;
            else if(this.dist > other.dist) return -1;
            else return 0;
        }
    }
}

/**

3 3         18
5 -1        26
-2 4        20



 */