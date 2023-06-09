package bbb;
import java.util.*;

public class lq2675 {
	static int stm;
	static int n,m,limit;
	static int[][] a;
	static int[][][] bg,sm;
	static int[][][][] stbg,stsm;
	
	public static final int calst(int x) {
		int t=1,ans=0;
		while(true) {
			if(t*2>x) break;
			t*=2;ans++;
		}
		return ans;
	}
	public static final int stfindbg(int u,int d,int l,int r) {
		if(r==l) return stbg[u][d][l][0];
		int t=calst(r-l+1);
		int ans=stbg[u][d][l][t];
		if(l+t<=r) {
			ans=Math.max(ans, stfindbg(u, d, l+t, r));
		}	
		return ans;
	}
	public static final int stfindsm(int u,int d,int l,int r) {
		if(r==l) return stsm[u][d][l][0];
		int t=calst(r-l+1);
		int ans=stsm[u][d][l][t];
		if(l+t<=r) {
			ans=Math.min(ans, stfindsm(u, d, l+t, r));
		}	
		return ans;
	}
	public static final boolean judge(int u,int d,int l,int r) {
		return stfindbg(u, d, l, r)-stfindsm(u, d, l, r)<=limit;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();m=scanner.nextInt();
		stm=calst(m);
		a=new int [n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				a[i][j]=scanner.nextInt();
			}
		}
		limit=scanner.nextInt();
		//bg[u][d][j]=´Óa[u][j]µ½a[d][j]µÄbig
		bg=new int [n+1][n+1][m+1];
		sm=new int [n+1][n+1][m+1];
		stbg=new int [n+1][n+1][m+1][stm+1]; 
		stsm=new int [n+1][n+1][m+1][stm+1]; 
		for(int j=1;j<=m;j++) {
			for(int u=1;u<=n;u++) {
				for(int l=1;l<=n;l++) {
					int d=u+l-1;
					if(d>n) break;
					if(u==d) { 
						bg[u][d][j]=a[d][j];
						sm[u][d][j]=a[d][j];
					}
					else {
						bg[u][d][j]=Math.max(bg[u][d-1][j],a[d][j]);
						sm[u][d][j]=Math.min(sm[u][d-1][j],a[d][j]);
					}
				}
			}
		}
		
		for(int i=0;i<=stm;i++){
			for(int u=1;u<=n;u++) {
				for(int l=1;l<=n;l++) {
					int d=u+l-1;
					if(d>n) break;
					for(int j=1;j<=m;j++) {
						if(i==0) {
							stbg[u][d][j][0]=bg[u][d][j];
							stsm[u][d][j][0]=sm[u][d][j];
							continue;
						}
						int j0=j+(int)Math.pow(2, i-1);
						if(j0>m) break;
//						System.out.printf("%d %d\n",j,j0);
						stbg[u][d][j][i]=Math.max(stbg[u][d][j][i-1],stbg[u][d][j0][i-1]);
						stsm[u][d][j][i]=Math.min(stsm[u][d][j][i-1],stsm[u][d][j0][i-1]);
					}
				}
			}
		}
		int ans=0;
		for(int u=1;u<=n;u++) {
			for(int l=1;l<=n;l++) {
				int d=u+l-1;
				if(d>n) break;
				int i=1,j=1;
				int nowbg=stfindbg(u, d, i, j);
				int nowsm=stfindsm(u, d, i, j);
				while(true) {
					
					if(nowbg-nowsm<=limit) {
						ans=Math.max(ans, l*(j-i+1));
						j++;
						if(j>m) break;
						nowbg=Math.max(nowbg, bg[u][d][j]);
						nowsm=Math.min(nowsm, sm[u][d][j]);
					}else {
						i++;if(i>j)j=i;
						if(i>m)break;
						nowbg=stfindbg(u, d, i, j);
						nowsm=stfindsm(u, d, i, j);
					}
					if(i>m) break;
				}
			}
		}
//		print();
		System.out.println(ans);
	}
}
