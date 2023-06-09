package bbb;
import java.util.*;
public class lq2722 {
	public static int INF =2147483647;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n,m,d;
		n=scanner.nextInt();m=scanner.nextInt();d=scanner.nextInt();
		int[] a=new int [n+1];
		int[] b=new int [m+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=1;i<=m;i++) {
			b[i]=scanner.nextInt();
		}
		Arrays.sort(a);Arrays.sort(b);
		double [][][] dp = new double [n+1][m+1][2];
		for(int i=1;i<=n;i++) {
			dp[i][0][0]=a[i];
			dp[i][0][1]=INF;
		}
		for(int j=1;j<=m;j++) {
			dp[0][j][0]=INF;
			dp[0][j][1]=b[j]+d;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				double t1=(a[i]-b[j]),t2=d;
				double t=t1*t1+t2*t2;
				dp[i][j][0]=dp[i-1][j][0]+(a[i]-a[i-1]);
				dp[i][j][0]=Math.min(dp[i][j][0],dp[i-1][j][1]+Math.sqrt(t));
				dp[i][j][1]=dp[i][j-1][1]+(b[j]-b[j-1]);
				dp[i][j][1]=Math.min(dp[i][j][1],dp[i][j-1][0]+Math.sqrt(t));
//				System.out.printf("[%.2f,%.2f] ",dp[i][j][0],dp[i][j][1]);
			}//System.out.println();
		}
		System.out.printf("%.2f\n",Math.min(dp[n][m][0], dp[n][m][1]));
	}

}
