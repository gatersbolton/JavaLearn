package ccc;

import java.io.*;
import java.util.*;

public class lq3162 {
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st=new StreamTokenizer(bf);
	static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);
	static int I() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long n,m,T,N;
		n=sc.nextLong();m=sc.nextLong();
		N=n;
		boolean isprime[]=new boolean[32000];
		T=31622;
		for(int i=2;i<=T;i++) {
			isprime[i]=true;
		}
		for(int i=2;i<=T;i++) {
			if(isprime[i]) {
				for(int j=i;j*i<=T;j++) {
					isprime[j*i]=false;
				}
			}
		}
		long ans=n,tt=n,mod=998244353;
		for(int i=2;i<=T;i++) {
			if(isprime[i] && tt%i==0) {
//				pw.printf("%d\n",i);
				ans/=i;ans*=(i-1);
				while(tt%i==0) tt/=i;
			}
		}
		if(tt>1) {
			ans/=tt;ans*=(tt-1);
		}
//		m--;
		long t=1;
		while(m>0) {
//			pw.printf("%d %d\n",m,t);
			if((m&1)==1) t*=n;
			n*=n;
			t%=mod;
			n%=mod;
			m>>=1;
		}
		pw.printf("%d\n",t);
		for(int i=2;i<=T;i++) {
			if(isprime[i] && N%i==0) {
				
				t=t-t/i;
				pw.printf("%d\n%d\n",i,t);
			}
		}
//		ans*=t;ans%=mod;
		pw.print(t);
//		pw.print(ans);
		pw.flush();
		
	}

}
