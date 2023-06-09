package ccc;
import java.util.*;
import java.io.*;
public class lq3152 {
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
		int[] rr=new int[10];
		int[]dp=new int[n+1];
		int[] l=new int[n+1];
		int[] r=new int[n+1];
		int ans=0;
		for(int i=1;i<=n;i++) {
			int x=I();
			r[i]=x%10;
			while(x>=10) x/=10;
			l[i]=x;
			
			dp[i]=dp[rr[l[i]]]+1;
			
			if(dp[i]>dp[rr[r[i]]]) rr[r[i]]=i;
			ans=Math.max(ans, dp[i]);
//			System.out.println(dp[i]);
		}
		System.out.println(n-ans);
	}

}
