package bbb;
import java.util.*;
public class P1439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		Integer n=scanner.nextInt(),m=0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=0;i<=n;i++) {
			b.add(i);
		}
		for(int i=1;i<=n;i++) {
			Integer x=scanner.nextInt();
//			3 2 4 1 5
//			4 2 1 3 5
			b.set(x, i);
		}
//		for(int i=1;i<=n;i++) {
//			System.out.printf("%d ",b.get(i));
//		}
//		System.out.println("\n");
		a.add(9999999);
		for(int i=1;i<=n;i++) {
//			for(int j=0;j<a.size();j++) {
//				System.out.printf("%d ",a.get(j));
//			}System.out.println("");
			Integer x=scanner.nextInt();
			x=b.get(x);
//			System.out.printf("%d ",x);
			if(x>a.get(m)) {
				a.add(x);m++;continue;
			}
			if(m==0) {
				if(x<a.get(0)) a.set(0, x);
				continue;
			}
			Integer l=0,r=m;
			Integer mid=(l+r)/2;
			while(!(a.get(mid)<x && a.get(mid+1)>x) && r>=l) {
				
				if(a.get(mid)>x) r=mid-1;
				else l=mid+1;
				mid=(l+r)/2;
				
			}
//			System.out.printf("%d %d %d:[%d]\n",l,r,mid,a.get(mid));
			if(r<0) a.set(mid, x);
			else a.set(mid+1, x);
		}
//		for(int j=0;j<a.size();j++) {
//			System.out.printf("%d ",a.get(j));
//		}System.out.println("");
		System.out.println(a.size());
	}

}
