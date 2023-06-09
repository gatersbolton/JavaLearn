package ccc;
import java.util.*;
public class lq2264 {
	public static int[] a,c;
	public static ArrayList<Integer>[] b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		a=new int[n+1];c=new int[n+1];
		b=new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=1;i<=n-1;i++) {
			int u=scanner.nextInt(),v=scanner.nextInt();
			if(b[u]==null) b[u]=new ArrayList<Integer>();
			if(b[v]==null) b[v]=new ArrayList<Integer>();
			b[u].add(v);
			b[v].add(u);
		}
		Queue<Integer> q=new LinkedList<Integer>();
		Queue<Integer> ql=new LinkedList<Integer>();
		ArrayList<Integer>[] level = new ArrayList[n+1]; 
		q.add(1);ql.add(1);
		int maxlevel=0;
		boolean[] been=new boolean[n+1];
		while(!q.isEmpty()) {
			int x=q.poll(),y=ql.poll();
			if(been[x]) continue;
//			System.out.printf("%d %d\n",x,y);
			been[x]=true;
			if(level[y]==null) level[y]=new ArrayList<Integer>();
			level[y].add(x);c[x]=y;
			if(y>maxlevel) maxlevel=y;
			for(int i:b[x]) {
				q.add(i);ql.add(y+1);
			}
		}
		long[] dp=new long [n+1];
		long ans=0;
		for(int i=maxlevel;i>=1;i--) {
			if(level[i].size()==0) continue;
			for(int j:level[i]) {
				long t1=0,t2=0;
				for(int k:b[j]) {
					if(c[k]<i) continue;
					if(dp[k]>0) t1+=dp[k];
				}
				if(t1+a[j]>ans) ans=t1+a[j];
				dp[j]=t1+a[j];
			}
		}
		System.out.println(ans);
	}

}
