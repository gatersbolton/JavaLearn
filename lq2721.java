package bbb;
import java.util.*;

public class lq2721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n,m,k;
		n=scanner.nextInt();m=scanner.nextInt();k=scanner.nextInt();
		int[][][] dp=new int[n+1][m+1][2];
		int[] w=new int [n+1], v=new int [n+1];
		for(int i=1;i<=n;i++) {
			w[i]=scanner.nextInt();v[i]=scanner.nextInt();
		}
		int ans=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i][j][0]);
				if(j>=w[i]) dp[i][j][0]=Math.max(dp[i][j][0],dp[i-1][j-w[i]][0]+v[i]);
				dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i][j][1]);
				if(j>=w[i]) dp[i][j][1]=Math.max(dp[i][j][1],dp[i-1][j-w[i]][1]+v[i]);
				if(j>=w[i]+k) dp[i][j][1]=Math.max(dp[i][j][1],dp[i-1][j-w[i]-k][0]+2*v[i]);
				ans=Math.max(ans, dp[i][j][0]);
				ans=Math.max(ans, dp[i][j][1]);
				//System.out.printf("[%d,%d] ",dp[i][j][0],dp[i][j][1]);
			}//System.out.println();
		}
//		System.out.println(ans);
		System.out.println(Math.max(dp[n][m][1],dp[n][m][1]));
	}

}
