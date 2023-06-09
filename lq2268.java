package ccc;
import java.util.*;
public class lq2268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		int n=str.length();
		int[] a=new int[n+1];
		for(int i=0;i<n;i++) {
			a[i+1]=str.charAt(i)-'A';
		}
		boolean[][] hw=new boolean [n+1][n+1];
		int[][] dp=new int [n+1][n+1];
		for(int i=1;i<=n;i++) {
			hw[i][i]=true;
//			System.out.println(a[i]);
		}
		int ans=0;
		for(int l=2;l<=n;l++) {
			 for(int i=1;i<=n;i++){
				int j=i+l-1;
//				if(i==1 && j==5) System.out.printf("%d %d %b\n",a[i],a[j],hw[i+1][j-1]);
				if(j>n) break;
				else if(i==j-1) {
					hw[i][j]=(a[i]==a[j]);
				}else {
					hw[i][j]=((a[i]==a[j]) && hw[i+1][j-1]);
				}
			}
		}
		for(int l=1;l<=n;l++){
			for(int i=1;i<=n;i++) {
				int j=i+l-1;
				if(j>n) break;
				if(hw[i][j]) dp[i][j]=0;
				else {
					if(a[i]==a[j]) {
						if(i==j-1) dp[i][j]=0;
						else dp[i][j]=dp[i+1][j-1];
					}else {
						dp[i][j]=Math.min(dp[i+1][j], dp[i][j-1])+1;
					}
				}
			}
		}
		System.out.println(dp[1][n]);
	}

}
