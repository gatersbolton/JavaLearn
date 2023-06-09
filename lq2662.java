package bbb;
import java.util.*;
public class lq2662 {
	public static int mod=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(),m=scanner.nextInt();
		//n*2 m-1
		int [][][] dp=new int [n+m+1][n+1][m+1];
		dp[0][0][2]=1;
		for(int i=1;i<=n+m;i++) {
			for(int j=0;j<=n;j++) {
				int t=i-j;//t ge -1
				if(t<0 || t>m) continue;
				for(int k=0;k<=m;k++) {
					//now is *2
					if(k%2==0 && j>0)
						dp[i][j][k]+=dp[i-1][j-1][k/2];
					//now is -1
					dp[i][j][k]%=mod;
					if(i-1>=j && k<m)
					dp[i][j][k]+=dp[i-1][j][k+1];
					dp[i][j][k]%=mod;
				}
			}
		}
		System.out.println(dp[n+m-1][n][1]);
	}

}
