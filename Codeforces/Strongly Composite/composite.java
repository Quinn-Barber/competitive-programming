import java.io.*;
import java.util.*;

public class composite {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[] primes = primeSieve(10000000);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = in.nextInt();
            int numStronglyComposite = 0;
            int numComposite = 0;
            int numPrimes = 0;

            HashSet<Integer> primeSet = new HashSet<>();

            for(int i = 0; i < n; i++){
                int num = in.nextInt();
                if(primes[num]){
                    if(primeSet.contains(num)){
                        numStronglyComposite++;
                        primeSet.remove(num);
                    }
                    else{
                        primeSet.add(num);
                    }
                }
                else{
                    ArrayList<Integer> primefactors = primeFactors(num, primes);
                    //System.out.print(num + " prime factors: ");
                    for(int j = 0; j < primefactors.size(); j++){
                        //System.out.print(primefactors.get(j) + " ");
                        num = primefactors.get(j);
                        if(primeSet.contains(num)){
                            numStronglyComposite++;
                            primeSet.remove(num);
                        }
                        else{
                            primeSet.add(num);
                        }
                    }
                    //System.out.println();
                }
            }
            numStronglyComposite += primeSet.size() / 3;
            System.out.println(numStronglyComposite);

            // the product of 2 primes is not strongly composite
            // primes are not strongly composite
            // a prime number squared is strongly composite
            // a prime number times a composite number is strongly composite
            // the product of 3 primes is strongly composite
        }
    }

    public static ArrayList<Integer> primeFactors(int n, boolean[] primes){
        ArrayList<Integer> primefactors = new ArrayList<>();
        while(n % 2 == 0){
            primefactors.add(2);
            n /= 2;
        }

        for(int i = 3; i <= Math.sqrt(n); i += 2){
            while(n % i == 0){
                primefactors.add(i);
                n /= i;
            }
        }

        if(n > 2){
            primefactors.add(n);
        }
        return primefactors;
    }

    public static boolean[] primeSieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]= false;
        isPrime[1] = false;

        for (int i=2; i*i<=n; i++)
            for (int j=2*i; j<=n; j+=i)
                isPrime[j] = false;
        return isPrime;
    }


}
