package ccc;
import java.util.*;
import java.io.*;
public class lq3155 {
	static Scanner sc = new Scanner (System.in);
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(bf);
    static PrintWriter pw = new PrintWriter(System.out);
    static int I() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    static class num{
    	num(int val,int i) {
    		this.i=i;
    		this.val=val;
    	}
    	int val;
    	int i;
    }
    static Comparator<num> cmp = new Comparator<num>() {
        public int compare(num e1, num e2) {
          return e1.val - e2.val;
        }
      };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n,m;
		int INF=2147483647;
		n=I();m=I();
		int[] a=new int[n+1];
		int[] b=new int[n+1];
		int[] used=new int[n+1];
		PriorityQueue<num> heap=new PriorityQueue<>(cmp);
		for(int i=1;i<=n;i++) {
			int x=I();
			a[i]=x;
			heap.add(new num(x,i));
		}
		for(int i=1;i<=m;i++) {
			num t=heap.poll();
			while(used[t.i]!=0) {
				used[t.i]--;
				t=heap.poll();
			}
			used[t.i]=-1;
			a[t.i-1]+=a[t.i];used[t.i-1]++;
			a[t.i+1]+=a[t.i];used[t.i+1]++;
			if(t.i-1>=1) heap.add(new num(a[t.i-1], t.i-1));
			if(t.i+1<=n) heap.add(new num(a[t.i+1], t.i+1));
		}
		while(!heap.isEmpty()) {
			num t=heap.poll();
			if(used[t.i]!=0) {
				used[t.i]--;
			}else {
				b[t.i]=t.val;
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.printf("%d ",b[i]);
		}
	}

}
