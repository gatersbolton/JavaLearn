package bbb;
import java.lang.reflect.Array;
import java.util.*;
public class lq2673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n;
		n=scanner.nextInt();
		int[] a=new int[n+1];
		int[] b=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
			b[i]=a[i];
		}
		Arrays.sort(b);
		int mid,r,x,y,lans,rans,midans;
		mid=(n+1)/2;
		r=mid;
		while(r<=n && b[r]==b[mid]) r++;
		if(r>n) rans=b[mid];else rans=b[r];
		x=0;y=0;
		for(int i=1;i<=n;i++) {
			if(a[i]<b[mid]) x++;
			if(a[i]>b[mid]) y++;
		}
		if(x>=y) midans=b[mid]; else midans=b[mid]+1;
		if(x>y) lans=b[mid];
		else lans=b[mid]+1;
		for(int i=1;i<=n;i++) {
			int ans;
			if(n%2==1) {
				if(a[i]==b[mid]) ans=midans;
				else if(a[i]<b[mid]) ans=lans; else ans=a[i];
			}else {
				if(a[i]<=b[mid]) ans=rans; else ans=a[i];
			}
			System.out.printf("%d ",ans-a[i]);
		}
//		1 2 2 2 4 4 4 4
//		1 2 2 2 4 4 4
	}

}
