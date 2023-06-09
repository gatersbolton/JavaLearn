package bbb;
import java.util.*;
public class lq2676 {
	public static int n;
	public static int mod=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		int[] a= new int [n+1];
		int[] dp= new int [n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			int bg=a[i],sm=a[i];
			for(int j=i;j<=n;j++) {
				bg=Math.max(bg, a[j]);
				sm=Math.min(sm, a[j]);
				if(bg-sm==j-i) {
					dp[j]+=dp[i-1];
					dp[j]%=mod;
				}
			}
		}
		System.out.println(dp[n]);
	}

}
