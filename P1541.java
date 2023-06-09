package bbb;

import java.util.Scanner;


public class P1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n,m,i,j,x,y,yi=0,er=0,san=0,si=0;
		n=scanner.nextInt();m=scanner.nextInt();
		int [] a=new int[351];
		for(i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		for(i=1;i<=m;i++) {
			x=scanner.nextInt();
			if(x==1) yi++;
			else if(x==2) er++;
			else if(x==3) san++;
			else si++;
		}
		int [][][][] dp=new int [n+1][si+1][san+1][er+1]; 
		for(i=1;i<=n;i++) {
			for(int i4=0;i4*4<=i-1 && i4<=si;i4++) {
				for(int i3=0;i3*3+i4*4<=i-1 && i3<=san;i3++) {
					for(int i2=0;i2*2+i3*3+i4*4<=i-1 && i2<=er;i2++) {
						int i1=(i-1)-i2*2+i3*3+i4*4;
						int ans=0;
						if(i1>0 && i>1) ans=Math.max(ans, dp[i-1][i4][i3][i2]);
						if(i2>0 && i>2) ans=Math.max(ans, dp[i-2][i4][i3][i2-1]);
						if(i3>0 && i>3) ans=Math.max(ans, dp[i-3][i4][i3-1][i2]);
						if(i4>0 && i>4) ans=Math.max(ans, dp[i-4][i4-1][i3][i2]);
						dp[i][i4][i3][i2]=ans+a[i];
					}
				}	
			}
		}
		System.out.println(dp[n][si][san][er]);
	}

}
