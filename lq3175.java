package ccc;
import java.util.*;
import java.io.*;
public class lq3175 {
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
		n=I();
		Integer [] a=new Integer[n+1];
		boolean[] used=new boolean[n+1];
		PriorityQueue<Integer> bigheap=new PriorityQueue<Integer>();
		for(int i=1;i<=n;i++) {
			int x=I();
			bigheap.add(x);
		}
		for(int i=1;i<=n;i++) {
			a[n+1-i]=bigheap.poll();
		}
		a[0]=2147483647;
		Queue<Integer> q=new LinkedList<Integer>();
//		PriorityQueue<Integer> q=new PriorityQueue<Integer>(new Comparator<Integer>() {
//		    @Override
//		    public int compare(Integer o1, Integer o2) {
//		        return o2-o1;
//		    }
//		});
//		Arrays.sort(a, Collections.reverseOrder());
//		Arrays.sort(a, new Comparator<Integer>() {
//				@Override
//				public int compare(Integer x, Integer y) {
//					return y-x;
//				}
//		});
		long ans=0,t=0;
		for(int i=1;i<=n;i++) {
			if(used[i]) continue;
			if(!q.isEmpty() && a[i]<=q.peek()) {
				q.poll();used[i]=true;continue;
			}
			used[i]=true;t++;
			ans+=a[i];
			if(t%2==1) continue;
			q.add(a[i]/2);
		}
		System.out.println(ans);
	}

}
