package ccc;

import java.io.*;
import java.util.*;

public class lq3180 {
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st=new StreamTokenizer(bf);
	static PrintWriter pw= new PrintWriter(System.out);
	static int I() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n,m;
		n=I();m=I();
		int a[][]=new int[n+2][n+2];
		int b[][]=new int[n+2][n+2];
		for(int i=1;i<=m;i++) {
			int x1=I(),y1=I(),x2=I(),y2=I();
			a[x1][y1]++;
			a[x1][y2+1]++;
			a[x2+1][y1]++;
			a[x2+1][y2+1]++;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				b[i][j]=b[i-1][j]+b[i][j-1]-b[i-1][j-1]+a[i][j];
				if(b[i][j]%2==1) pw.printf("1"); else pw.printf("0");
//				pw.printf("%d ",a[i][j]);
			}pw.printf("\n");
		}
		pw.flush();
	}

}
