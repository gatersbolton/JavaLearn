package bbb;
import java.util.*;

public class lq2720 {
	public static int n,m;
	public static class num{
		public num(int bad, boolean good) {
			this.bad=bad;this.good=good;
		}
		int bad;
		boolean good=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Map<Integer, num> mp = new HashMap<Integer,num>();
		ArrayList<Integer> numlist=new ArrayList<Integer>();
		n=scanner.nextInt();m=scanner.nextInt();
		int allbad=0;
		boolean allequal=true;
		for(int i=1;i<=m;i++) {
			int k=scanner.nextInt();
			int[] a=new int[k+1];int[] b=new int[k+1];  
			for(int j=1;j<=k;j++) a[j]=scanner.nextInt();
			for(int j=1;j<=k;j++) b[j]=scanner.nextInt();
			String s=scanner.next();
			if(s.equals("=")) {
				for(int j=1;j<=k;j++) {
					if(mp.get(a[j])==null) {
						numlist.add(a[j]);
						mp.put(a[j],new num(0,true));
					}else {
						num x=mp.get(a[j]);
						x.good=true;
						mp.put(a[j], x);
					}
					if(mp.get(b[j])==null) {
						numlist.add(b[j]);
						mp.put(b[j],new num(0,true));
					}else {
						num x=mp.get(b[j]);
						x.good=true;
						mp.put(b[j], x);
					}
				}
			}else if(s.equals(">")){
				allequal=false;
				allbad++;
				for(int j=1;j<=k;j++) {
					if(mp.get(a[j])==null) {
						numlist.add(a[j]);
						mp.put(a[j],new num(0,true));
					}else {
						num x=mp.get(a[j]);
						x.good=true;
						mp.put(a[j], x);
					}
					if(mp.get(b[j])==null) {
						numlist.add(b[j]);
						mp.put(b[j],new num(1,false));
					}else {
						num x=mp.get(b[j]);
						x.bad++;
						mp.put(b[j], x);
					}
				}
			}else if(s.equals("<")){
				allequal=false;
				allbad++;
				for(int j=1;j<=k;j++) {
					if(mp.get(b[j])==null) {
						numlist.add(b[j]);
						mp.put(b[j],new num(0,true));
					}else {
						num x=mp.get(b[j]);
						x.good=true;
						mp.put(b[j], x);
					}
					if(mp.get(a[j])==null) {
						numlist.add(a[j]);
						mp.put(a[j],new num(1,false));
					}else {
						num x=mp.get(a[j]);
						x.bad++;
						mp.put(a[j], x);
					}
				}
			}
		}
		int ans=0;
		if(allequal) {
			ans=n-numlist.size();
		}else {
			for(int i:numlist) {
				num x=mp.get(i);
	//			System.out.printf("%d:%d,good:%b\n",i,x.bad,x.good);
				if(!x.good && x.bad==allbad) ans++;
			}
		}
		System.out.println(ans);
	}

}
