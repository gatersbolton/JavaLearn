package bbb;
import java.util.*;

public class lq1449 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,s,a,b,ans=0;
		int mod=100000007;
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();s=scanner.nextInt();a=scanner.nextInt();b=scanner.nextInt();
//		System.out.printf("%d %d %d %d\n",n,s,a,b);
		int[][] dp = new int[n+1][n+1];
		dp[0][0]=1;
		for(int i=1;i<=n-1;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]+=dp[i-1][((j-(n-i)*a)%n+n)%n];
				dp[i][j]%=mod;
				dp[i][j]+=dp[i-1][((j+(n-i)*b)%n+n)%n];
				dp[i][j]%=mod;
			}
		}
		ans=dp[n-1][(s%n+n)%n];
		System.out.println(ans);
	}

}
