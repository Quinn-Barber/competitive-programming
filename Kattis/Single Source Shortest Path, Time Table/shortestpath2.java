/*
Quinn Barber
March 28th, 2022
 */
import java.util.*;

public class shortestpath2 {

    final public static int oo = 987654321; // Infinity
    public static int distance[];
    public static ArrayList<Edge>[] graph;
    public static int m, n, q, s;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        s = in.nextInt();
        
        while(true){
            distance = new int[n];
            graph = new ArrayList[n];
            for(int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
            
            // Add each edge to the directed graph (array of arraylist implementation)
            for(int i = 0; i < m; i++){
                int u = in.nextInt();
                int v = in.nextInt();
                int t0 = in.nextInt();
                int t = in.nextInt();
                int time = in.nextInt();
                graph[u].add(new Edge(v, t0, t, time) );
            }
            
            // Run dijkstras to find shortest distance to every node from start node s, and store it in the distance array
            dijkstras(s);
            
            // Each node query is either the distance in the distance array or infinity (oo) / Impossible
            for(int i = 0; i < q; i++){
                int query = in.nextInt();
                if( distance[query] == oo )
                    System.out.println("Impossible");
                else
                    System.out.println(distance[query]);
            }
            
            // Take in next case and return if its 4 zeros
            n = in.nextInt();
            m = in.nextInt();
            q = in.nextInt();
            s = in.nextInt();
            System.out.println();
            if(n == 0 && m == 0 && q == 0 && s == 0)
                return;
        }
    }

    public static void dijkstras(int start)
    {
        // Initialize all distances to infinity except for the start node at 0
        for(int i = 0; i < n; i++){
            distance[i] = oo;
        }
        distance[start] = 0;
        
        // Add the start node to a queue of nodes that contain the node number and its current distance
        PriorityQueue<Node> queue = new PriorityQueue<Node>(1, new Sort());
        queue.add(new Node(start, 0));
        
        // Iterate until queue size is 0, of which all nodes have been looked at
        while(queue.size() > 0){
            // Poll the lowest distance node out of the queue
            Node tmp = queue.poll();
            int node = tmp.getNode();
            int dis = tmp.getDistance();
            
            // Iterate through each edge of the node that was polled
            for(int i = 0; i < graph[node].size(); i++){
                // Set info from edge
                int v = graph[node].get(i).getV();
                int t0 = graph[node].get(i).getT0();
                int p = graph[node].get(i).getT();
                int d = graph[node].get(i).getTime();
                int math;
                // If p is 0 and the current time is past t0, then its impossible to get to so continue
                if(p == 0 && dis > t0){
                    continue;
                }
                // If the distance is less than or equal to t0, then the math is easy:
                // just t0 plus the time required to move through that edge
                if(dis <= t0) {
                    math = t0 + d;
                }
                else {
                    /*
                            This is the calculations portion:
                        Find the current time minus t0 and mod it with p then subtract
                    that number from p.
                    
                        This will give the amount of time to add to the current time, add the time
                    it takes to traverse the edge and the current time to find the distance required
                    to reach this node.
                    
                        If math % p is 0, then nothing needs to be added as the times line up
                    with the cycles. So skip that part and just add current time and time to traverse the node.
                     */
                    math = dis - t0;
                    math %= p;
                    if(math != 0)
                        math = p - math;
                    math += d;
                    math += dis;
                }
                // If this distance is less than the one in the distance array, update ths array and the queue
                if(math < distance[v]){
                    Node chng = new Node(v, distance[v]);
                    queue.remove(chng);
                    distance[v] = math;
                    chng.setDistance(math);
                    queue.add(chng);
                }
                
            }
        }
    }
}

class Edge{
    // Directed from u to v
    private final int v;
    // t0 is when it must be to be able to traverse (in intervals of t)
    private final int t0;
    private final int t;
    // time is the amount of time the edge takes to traverse
    private final int time;

    public Edge(int v, int t0, int t, int time) {
        this.v = v;
        this.t0 = t0;
        this.t = t;
        this.time = time;
    }

    public int getT0() { return t0;}
    public int getT() { return t;}
    public int getTime() {  return time;}
    public int getV(){  return v;}
}

class Node{
    // Node number and distance that will be in the queue
    private int node;
    private int distance;

    public Node(int node, int distance){
        this.node = node;
        this.distance = distance;
    }

    public int getDistance(){   return distance;}
    public int getNode(){   return node;}
    public void setDistance(int distance){
        this.distance = distance;
    }
}

// In the queue it is polling from the lowest distance, not the lowest node number
class Sort implements Comparator<Node>{
    public int compare(Node a, Node b){
        return a.getDistance() - b.getDistance();
    }
}