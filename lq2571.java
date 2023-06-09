package ccc;
import java.util.*;
public class lq2571 {
	public static boolean ishuiwen(String x) {
		return (x.charAt(0)==x.charAt(7) && x.charAt(1)==x.charAt(6) && x.charAt(2)==x.charAt(5) && x.charAt(3)==x.charAt(4));
	}
	public static int rev(int x) {
		int a,b,c,d;
		d=x%10;x/=10;c=x%10;x/=10;b=x%10;a=x/10;
		return d*1000+c*100+b*10+a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String s=scanner.next();
		int ans1,ans2;
		int x=Integer.valueOf(s);
		x/=10000;
		int revx=rev(x);
		ans1=x*10000+revx;
		if(ans1<=Integer.valueOf(s)){
			x=Integer.valueOf(s);
			x/=10000;x++;
			revx=rev(x);
			ans1=x*10000+revx;
		}
		x=Integer.valueOf(s);
		x/=1000000;x=x*101;
		revx=rev(x);
		ans2=x*10000+revx;
		if(ans2<=Integer.valueOf(s)) {
			x=Integer.valueOf(s);
			x/=1000000;x++;x=x*101;
			revx=rev(x);
			ans2=x*10000+revx;
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}

}
