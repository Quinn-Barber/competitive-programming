import java.io.*;
import java.util.*;

public class megainversions {

    static class Fenwick{
        public long[] cumfreq;
        public int n;

        public Fenwick(int sz){
            n = 1;
            while(n < sz) n <<= 1;
            cumfreq = new long[n+1];
        }

        public void add(int index, long value){
            while(index < cumfreq.length){
                cumfreq[index] += value;
                index += Integer.lowestOneBit(index);
            }
        }

        public long sum(int index){
            long ans = 0;
            while(index > 0){
                ans += cumfreq[index];
                index -= Integer.lowestOneBit(index);
            }
            return ans;
        }

        public long sum(int low, int high){
            return sum(high) - sum(low-1);
        }

        public long all(){
            return sum(cumfreq.length-1);
        }

        public long atOrAbove(int index){
            long sub = 0;
            if(index > 0) sub = sum(index-1);
            return all() - sub;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Fenwick sizeOne = new Fenwick(100000);
        Fenwick sizeTwo = new Fenwick(100000);
        long count = 0;
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            sizeOne.add(num, 1);
            long check = sizeOne.sum(num+1, 100000);
            if(check != 0)
                sizeTwo.add(num, check);
            count += sizeTwo.sum(num+1, 100000);
        }
        System.out.println(count);
    }


}
