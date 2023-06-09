package bbb;
import java.util.*;
public class P1020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer n=scanner.nextInt(),m=0;
		a.add(0);
		for(int i=1;i<=n;i++) {
//			System.out.println(i);
			Integer x=scanner.nextInt();
			if(x<=a.get(m)) {
				a.add(x);m++;continue;
			}
			if(m==0) {
				if(x>a.get(0)) a.set(0, x);
				continue;
			}
			Integer l=0,r=m;
			Integer mid=(l+r)/2;
			while(!(a.get(mid)>=x && a.get(mid+1)<x) && r>=l) {
//				System.out.printf("%d %d %d:[%d,%d]\n",l,r,mid,a.get(mid-1),a.get(mid));
				if(a.get(mid)<x) r=mid-1;
				else l=mid+1;
				mid=(l+r)/2;
				
			}
			
			a.set(mid+1, x);
		}
		System.out.println(a.size());
	}

}
