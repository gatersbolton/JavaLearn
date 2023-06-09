package bbb;
import java.math.BigInteger;
import java.util.*;
public class lq2724 {
	public static long [] num= {0, 2022, 20220, 202200, 2022000, 20220000, 202200000};
	public static long [] ten= {0,10000,100000,1000000,10000000,100000000,1000000000};
	public static long [] one= {0,	  1,    10,    100,    1000,    10000,    100000};
	public static long [] tmp= {0,    0,     0,      0,       0,        0,         0};
	public static BigInteger big(long x) {
		return BigInteger.valueOf(x);
	}
	public static BigInteger solve(long x) {
		long lv,l=0,r;
		BigInteger ans=new BigInteger("0");
		BigInteger t=new BigInteger("0");
		for(int ii=1;ii<=6;ii++) {
			if(num[ii]>x) break;
			l=x/ten[ii]-1;
			r=x%ten[ii]-num[ii];
			if(0<=r && r<one[ii]) {
				r++;
			}else {
				r=0;
			}
			
//			ans+=(1+l)*l/2*ten[ii];
			t=big(l);t=t.multiply(big(1+l));t=t.multiply(big(ten[ii]/2));t=t.multiply(big(one[ii]));
			ans=ans.add(t);
//			ans+=(1+l)*one[ii]*2022*one[ii];
			t=big(one[ii]);t=t.multiply(big(1+l));t=t.multiply(big(2022));t=t.multiply(big(one[ii]));
			ans=ans.add(t);
//			ans+=(num[ii]+1+num[ii]+r-1)*(r-1)/2;
			if(ii==1) t=big(0);
			else if(r%2==1) {
				t=BigInteger.valueOf((r-1)/2);t=t.multiply(big(num[ii]+1+num[ii]+r-1));
			}else {
				t=BigInteger.valueOf(r-1);t=t.multiply(big(num[ii]+r/2));
			}
			System.out.println(t);
			ans=ans.add(t);
		}
		if(x>2022022) {
			long i=0;
			while(true) {
				if((i+1)*10000000+2022022>x) break;
				i++;
			}
//			(2022022+2022022+i*10000000)*(i+1)/2
			t=big(i+1);t=t.multiply(big(2022022+i*5000000));
			ans=ans.subtract(t);
		}
		if(x>20220220) {
			for(int j=0;j<=9;j++) {
				long y=20220220+j*100000000;
				if(y>x) break;
				for(long i=0;i<=9;i++) {
					if(y+i<=x)ans=ans.subtract(big(y+i));
				}
			}
		}
		if(x>202202200) {
			long y=202202200;
			for(long i=0;i<=99;i++) {
				if(y+i<=x)ans=ans.subtract(big(y+i));
			}
		}
		System.out.println();
		return ans;
	}
	public static void main(String[] args) {
//		System.out.println(solve(374144573));
//		System.out.println();
//		System.out.println(solve(305390303));
		Scanner scanner=new Scanner(System.in);
//		long n=scanner.nextLong(),m=scanner.nextLong();
		long n=305390303,m=374144573;
		BigInteger ans2=solve(n),ans1=solve(m);
		System.out.println(ans1);
		System.out.println();
		System.out.println(ans2);
		System.out.println();
		ans1=ans1.subtract(ans2);
		System.out.println(ans1);
	}

}
//9409504588451
//12574323397511