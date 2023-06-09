package ccc;
import java.util.*;
import java.io.*;

public class lq3179 {
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st=new StreamTokenizer(bf);
	static PrintWriter pw=new PrintWriter(System.out);
	static int I() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	
	public static void main(String[] args) throws IOException {
		int n;
		n=I();
		PriorityQueue<Integer>[] a=new PriorityQueue[11];
		for(int i=0;i<=9;i++) {
			a[i]=new PriorityQueue<Integer>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1-o2;
				}
			}); 
		}
		for(int i=1;i<=n;i++) {
			int x,y;
			x=I();y=I();
			a[x].add(y);
		}
		
		long ans=0;
		for(int i=0;i<=9;i++) {
			while(a[i].size()>n/10) {
				int x=a[i].poll();
				ans+=x;
			}
		}
		pw.print(ans);
		pw.flush();
	}
}
