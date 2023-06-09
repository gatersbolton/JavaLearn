package ccc;
import java.util.*;
public class lq2301 {
	static int[] a,fa;
	static int n;
	public static int findfa(int x) {
		if(fa[x]==0) {
			fa[x]=x;return x;
		}
		if(x==fa[x]) return x;
		fa[x]=findfa(fa[x]);
		return fa[x];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt(); 
		a=new int [n+1];
		fa=new int [1000001];
		for(int i=1;i<=n;i++) {
			int x=scanner.nextInt();
			x=findfa(x);
			System.out.printf("%d ",x);
			fa[x]=findfa(x+1);
		}
	}

}
