import java.util.*;

public class horror {
    public static int oo = 987654321;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int h = in.nextInt();
        int l = in.nextInt();
        ArrayList<Integer> horrorMovies = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++){
            map.put(i, oo);
            graph[i] = new HashSet<>();
        }
        for(int i = 0; i < h; i++) {
            int movie = in.nextInt();
            horrorMovies.add(movie);
            map.put(movie, 0);
        }
        for(int j = 1; j <= l; j++){
            int a = in.nextInt();
            int b = in.nextInt();
            if(a != b){
                graph[b].add(a);
                graph[a].add(b);
            }
        }

        LinkedList<Integer[]> queue = new LinkedList<>();

        boolean used[] = new boolean[n];

        for(int i = 0; i < h; i++){
            Integer[] arr = new Integer[2];
            arr[0] = horrorMovies.get(i);
            arr[1] = 1;
            used[horrorMovies.get(i)] = true;
            queue.addLast(arr);
        }

        while(queue.size() > 0){
            Integer[] arr = queue.pollFirst();
            int num = arr[0];
            Iterator it = graph[num].iterator();
            for(int i = 0; i < graph[num].size(); i++){
                int movie = (int) it.next();
                if(used[movie]) continue;
                used[movie] = true;
                map.put(movie, arr[1]);
                Integer[] newArr = new Integer[2];
                newArr[0] = movie;
                newArr[1] = arr[1]+1;
                queue.addLast(newArr);
            }
        }

        int max = map.get(0);
        int maxIdx = 0;
        for(int i = 0; i < n; i++){
            if(map.get(i) > max){
                max = map.get(i);
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
    }
}
