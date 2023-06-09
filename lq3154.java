package ccc;
import java.util.*;
import java.io.*;
public class lq3154 {
	static Scanner sc = new Scanner (System.in);
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(bf);
    static PrintWriter pw = new PrintWriter(System.out);
    static int I() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n;
		int INF=2147483647;
		n=sc.nextInt();
		String s,a,b;
		s=sc.next();a=sc.next();b=sc.next();
		int[] r=new int [s.length()*2+2];
		for(int i=s.length()-1;i>=0;i--) {
			r[i]=r[i+1];
			if(s.charAt(i)==b.charAt(0)) {
				r[i]++;
			}
		}
		long ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==a.charAt(0)) {
				if(i+n-1<s.length()) {
					ans+=r[i+n-1];
				}
			}
		}
		System.out.println(ans);
	}

}
