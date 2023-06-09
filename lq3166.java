package ccc;
import java.io.*;
import java.util.*;
public class lq3166 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st=new StreamTokenizer(br);
	static PrintWriter pw=new PrintWriter(System.out);
	static int I() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n;
		n=I();
		int a[] = new int[n+2];
		for(int i=1;i<=n;i++) {
			a[i]=I();
		}
		Arrays.sort(a,1,n+1);
		int now=a[1],cnt=0,i=1;
		while(true){
			while(a[i]==now && i<=n) {
				cnt++;i++;
			}
			if(cnt%(now+1)==0) {
				now++;
				cnt/=now;
			}else {
				break;
			}
		}
		pw.print(now);
		pw.flush();
	}

}
