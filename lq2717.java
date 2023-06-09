package bbb;
import java.util.*;

public class lq2717 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l=new ArrayList<Integer>();
		ArrayList<Integer> r=new ArrayList<Integer>();
		ArrayList<Integer> num=new ArrayList<Integer>();
		ArrayList<String> s=new ArrayList<String>();
		Scanner scanner=new Scanner(System.in);
		int n,m;
		n=scanner.nextInt();m=scanner.nextInt();
		boolean[] used = new boolean[n+1];
		for(int i=1;i<=m;i++) {
			String ss=scanner.next();
			int x=scanner.nextInt();
			s.add(ss);
			num.add(x);
		}
		for(int i=s.size()-1;i>=0;i--) {
			int x=num.get(i);
//			System.out.printf("[%d,%s]\n",x,s.get(i));
			if(!used[x]) {
				if(s.get(i).equals("L")) {
					l.add(x);
				}else {
					r.add(x);
				}
				used[x]=true;
			}
		}
		for(int i=0;i<l.size();i++) {
			System.out.printf("%d ",l.get(i));
		}
		for(int i=1;i<=n;i++) {
			if(used[i]) continue;
			System.out.printf("%d ",i);
		}
		for(int i=r.size()-1;i>=0;i--) {
			System.out.printf("%d ",r.get(i));
		}
	}

}
