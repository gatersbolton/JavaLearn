package ccc;
import java.io.*;
import java.util.Scanner;
public class tryy {
    private static long mod = 998244353L;
    private static long a,b,res;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLong();
        b = scanner.nextLong();
        long n = Euler_pow(a,b);
        System.out.println(n);
        res = n;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    n%=mod;
                }
                res = (res - res / i);
                res%=mod;
                System.out.println(i);
                System.out.println(res);
            }
        }
        if (n > 1) {
            res = (res - res / n);
            res%=mod;
        }
        scanner.close();
        System.out.println(res%=mod);
    }
    private static long Euler_pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = ((ans % mod) * (a % mod)) % mod;
            }
            a = ((a % mod) * (a % mod)) % mod;
            b /= 2;
        }
        return ans;
    }
}