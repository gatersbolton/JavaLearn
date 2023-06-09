package ccc;
import java.util.*;
public class lq3172 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		long x1,x2,x3,x4,y1,y2,y3,y4,x0,y0,xn,yn,ans;
		x1=scanner.nextLong();y1=scanner.nextLong();
		x2=scanner.nextLong();y2=scanner.nextLong();
		x3=scanner.nextLong();y3=scanner.nextLong();
		x4=scanner.nextLong();y4=scanner.nextLong();
		x0=Math.max(x1, x3);y0=Math.max(y1, y3);
		xn=Math.min(x2, x4);yn=Math.min(y2, y4);
		if(x0<=xn&&y0<=yn) ans=-(xn-x0)*(yn-y0); else ans=0;
		ans+=(x2-x1)*(y2-y1);
		ans+=(x4-x3)*(y4-y3);
		System.out.println(ans);
	}

}
