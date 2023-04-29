import java.io.*;
import java.util.*;


public class milksum {

    static int N;
    static int Q;
    static long arr[];
    static long sorted[];

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(reader.readLine());
        arr = new long[N];
        sorted = new long[N];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);
        long[] psum = psum(sorted);

        long ans = 0;
        for(int i = 0; i < sorted.length; i++){
            ans += sorted[i] * (i+1);
        }

        st = new StringTokenizer(reader.readLine());
        Q = Integer.parseInt(st.nextToken());

        for(int a = 0; a < Q; a++){
            st = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            long j = Long.parseLong(st.nextToken());
            long newAns = ans;
            int oldIdx = 0;
            int newIdx = 0;
            if(arr.length != 1) {
                oldIdx = findIndex(sorted, arr[i]);
                newIdx = findIndex(sorted, j);
            }

            if(oldIdx < newIdx){
                newIdx--;
                newAns -= (sorted[oldIdx] * (oldIdx+1));
                newAns -= (psum[N] - psum[oldIdx+1]);
                newAns += (psum[N] - psum[newIdx+1]);
                newAns += j * (newIdx+1);
            }
            else if(oldIdx > newIdx){
                newAns -= (sorted[oldIdx] * (oldIdx+1));
                newAns += ((psum[N] - psum[newIdx]) - sorted[oldIdx]);
                newAns -= ((psum[N] - psum[oldIdx+1]));
                newAns += j * (newIdx+1);
            }
            else{
                newAns -= (sorted[oldIdx] * (oldIdx+1));
                newAns += j * (newIdx+1);
            }
            writer.println(newAns);
        }


        reader.close();
        writer.close();
    }

    public static long[] psum(long[] a){
        long[] psums = new long[a.length+1];
        for(int i = 0; i < a.length; i++){
            psums[i+1] = psums[i] + a[i];
        }
        return psums;
    }

    public static int findIndex(long[] nums, long target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // found exact match
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, left > right
        return left; // index where target would be inserted
    }



}