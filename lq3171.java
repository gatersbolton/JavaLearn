package ccc;
import java.util.*;
public class lq3171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		long T,n,mod=1000000007,erni;
		erni=(mod+1)/2;
		T=scanner.nextInt();
		for(int TT=1;TT<=T;TT++) {
			n=scanner.nextInt();
			long ji=0,ou=0,ans=0;
			for(int i=1;i<=n;i++) {
				int x=scanner.nextInt();
				if(x%2==1) ji++;
				else ou++;
			}
			if(ji%2==0) {
				ans=1;if(ji==0) ji=1;
				for(int j=1;j<=ou+ji-1;j++) {
					ans*=2;ans%=mod;
				}
//				for(int j=1;j<=ji;j++) {
//					ans*=j;ans%=mod;
//				}
//				if(ou-ji/2>=0) {
//					for(int j=1;j<=ou-ji/2;j++) {
//						ans*=2;ans%=mod;
//					}
//				}else {
//					for(int j=1;j<=-ou+ji/2;j++) {
//						ans*=erni;ans%=mod;
//					}
//				}
			}
//			System.out.println(ji);
			System.out.println(ans);
		}
	}

}
