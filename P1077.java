package bbb;
import java.util.*;

public class P1077 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dp = new int[101][101];
		int[] a=new int[101];
//		dp[i][j]//前i种共j个
//		=dp[i-1][j-v]
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(),m=scanner.nextInt(); 
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
			dp[i][0]=1;
		}
		dp[0][0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k<=j && k<=a[i];k++) {
					dp[i][j]+=dp[i-1][j-k];
					dp[i][j]%=1e6+7;
				}
				//System.out.printf("%d ", dp[i][j]);
			}//System.out.println();
		}
		System.out.println(dp[n][m]);
	}

}
