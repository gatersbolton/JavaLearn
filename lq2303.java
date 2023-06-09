package ccc;
import java.util.*;
public class lq2303 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		int k=scanner.nextInt(),t=scanner.nextInt();
		while(k>=0) {
			k--;
			int n=scanner.nextInt(),m=scanner.nextInt();
			int ans;
			if(m<t) {
				if(n%t<=m)
					ans=(n/t)*(m*(m+1)/2+(t-m)*m)+(n%t)*(n%t+1)/2;
				else 
					ans=(n/t)*(m*(m+1)/2+(t-m)*m)+m*(m+1)/2+(n%t-m)*m;
			}else {
				ans=(n/t)*t*(t-1)/2+(n%t)*(n%t+1)/2;
				ans=ans*2-t*(t-1)/2;
			}
			int tot;
			System.out.println(ans);
			if(m<=n)
				tot=(1+m)*m/2+(n-m)*m;
			else {
				tot=(1+n)*n/2;
			}
			System.out.println(tot);
		}
	}
}
