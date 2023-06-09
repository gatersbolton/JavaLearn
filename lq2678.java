package bbb;
import java.util.*;
public class lq2678 {
	public static int n,m,k,v;
	public static int[] a,b,c,d;
	public static long[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();m=scanner.nextInt();k=scanner.nextInt();v=scanner.nextInt();
		a=new int[m+1];b=new int[m+1];c=new int[m+1];d=new int[m+1];
		dp=new long[m+1][k+1];
		for(int i=1;i<=m;i++) {
			a[i]=scanner.nextInt();b[i]=scanner.nextInt();c[i]=scanner.nextInt();
			d[i]=a[i]-a[i-1];
		}
		long ans=20000000;ans*=ans;
		for(int i=1;i<=m;i++) {
			for(int j=0;j<k;j++) {
				if(j==k-1){
					dp[i][j]=dp[i-1][0];
					long wait=b[i]+c[i];wait-=dp[i][j]%(b[i]+c[i]);
					if(wait>c[i] || wait==0) wait=0;//green;
					dp[i][j]+=wait;
				}else if(j==0) {
					long dd=d[i];dd*=v;
					dp[i][j]=dp[i-1][0]+dd;
					long wait=b[i]+c[i];wait-=dp[i][j]%(b[i]+c[i]);
					if(wait>c[i] || wait==0) wait=0;//green;
					dp[i][j]+=wait;
					long t=dp[i-1][1]+dd;
					wait=b[i]+c[i];wait-=t%(b[i]+c[i]);
					if(wait>c[i] || wait==0) wait=0;//green;
					t+=wait;
					dp[i][j]=Math.min(dp[i][j], t);
				}else if(j<k-1){
					long dd=d[i];dd*=v;
					dp[i][j]=dp[i-1][j+1]+dd;
					long wait=b[i]+c[i];wait-=dp[i][j]%(b[i]+c[i]);
					if(wait>c[i] || wait==0) wait=0;//green;
					dp[i][j]+=wait;
				}
				if(i==m) {
					if(j==0) ;
					else {
						long t=n-a[m];t*=v;
						dp[i][j]+=t;
					}
					ans=Math.min(ans, dp[i][j]);
//					System.out.println(dp[i][j]);
				}
			}
		}
		System.out.println(ans);
	}

}
