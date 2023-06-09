package bbb;
import java.util.*;

public class lq2674 {
	public static void test() {
		long x=2147483647;
		x*=x;
		System.out.println(count5(x));
	}
	public static long count5(long x) {
		long ans=0;
		while(x>0) {
			ans+=x/5;
			x/=5;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		long n,m,l,r,mid=0;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextLong();
		l=5;r=2147483647;r*=r;
		while(l<r) {
			mid=(l+r)/2;
			if(count5(mid)<=n) l=mid+1;
			else r=mid-1;
		}
		boolean found=false;
		for(long i=Math.max(5, mid-25);i<=mid+25;i++) {
			if(count5(i)==n) {
				found=true;
				System.out.println(i);break;
			}
		}
		if(!found) {
			System.out.println(-1);
		}
	}

}
