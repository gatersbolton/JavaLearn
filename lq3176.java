package ccc;
import java.util.*;
import java.io.*;
public class lq3176 {
	static Scanner sc = new Scanner (System.in);
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(bf);
    static PrintWriter pw = new PrintWriter(System.out);
    static int I() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n;
		int INF=2147483647;
		n=I();
		int[] a=new int[n+1];
		int[] b=new int[n+1];
		int[][][] dp=new int[n+1][n+1][4];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int c=0;c<=2;c++) {
					dp[i][j][c]=INF;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			b[i]=I();
		}
		for(int i=1;i<=n;i++) {
			a[i]=I();
			dp[i][i][a[i]]=b[i];
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				int t=INF;
				for(int c=0;c<=2;c++) {
					for(int k=i;k<=j;k++) {
						int co=c-1;if(c<0) co+=3;
						if(dp[i][k][co]<t && dp[k][j][co]<t)
							t=Math.min(t, dp[i][k][co]+dp[k][j][co]);
					}
					dp[i][j][c]=t;
				}
			}
		}
	}

}
