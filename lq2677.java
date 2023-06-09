package bbb;
import java.util.*;

public class lq2677 {
	static int [][] a = new int [401][401];
	static int n=0;
	static int lx,rx,ly,ry;
	static void print(boolean f) {
		for(int i=lx-1;i<=rx+1;i++) {
			for(int j=ly-1;j<=ry+1;j++) {
				if(a[i][j]==2) System.out.printf("*"); 
				else if(f) System.out.printf("%d",a[i][j]);
				else if(n==100 && a[i+1][j]+a[i-1][j]+a[i][j+1]+a[i][j-1]==8) System.out.printf("*"); 
				else System.out.printf(" ");
			}System.out.println();
		}
	}
	static boolean nearby(int x,int y,int z) {
		return (a[x+1][y]==z)||(a[x-1][y]==z)||(a[x][y+1]==z)||(a[x][y-1]==z);
	}
	static void dfs(int x, int y) {
//		System.out.printf("[%d,%d]:%d\n",x,y,a[x][y]);
//		int t;
//		Scanner scanner = new Scanner(System.in);
		if(a[x][y]==0 && nearby(x, y, 1)) {
			a[x][y]=2;
//			t=scanner.nextInt();
//			System.out.printf("%d %d\n",x,y);
//			print(true);
			dfs(x-1, y-1);dfs(x+0, y-1);dfs(x+1, y-1);
			dfs(x-1, y+0);				dfs(x+1, y+0);
			dfs(x-1, y+1);dfs(x+0, y+1);dfs(x+1, y+1);
		}
		return;
	}
	static void dfs2(int x,int y) {
		if(a[x][y]<2) {
			a[x][y]+=2;
			dfs2(x+1, y);dfs2(x-1, y);
			dfs2(x, y-1);dfs2(x, y+1);
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();
		
		for(int i=0;i<=400;i++) {
			for(int j=0;j<=400;j++) {
				a[i][j]=0;
			}
		}
		String s=scanner.next();
		int x=180,y=180,minx,miny,maxx,maxy;
		
		minx=x;miny=y;
		lx=x;ly=y;rx=x;ry=y;
		for(int i=1;i<=n;i++) {
//			System.out.printf("%d,%d\n",x,y);
//			System.out.println(s.substring(i-1,i));
			a[x][y]=1;
			if(s.substring(i-1,i).equals("U")) x--;
			if(s.substring(i-1,i).equals("D")) x++;
			if(s.substring(i-1,i).equals("L")) y--;
			if(s.substring(i-1,i).equals("R")) y++;
			a[x][y]=1;
			if(x<minx) {
				minx=x;miny=y;
			}
			lx=Math.min(lx, x);ly=Math.min(ly, y);
			rx=Math.max(rx, x);ry=Math.max(ry, y);
		}
//		print(true);
		dfs(minx-1,miny);
//		print(true);
		dfs2(minx,miny);
		print(false);
	}

}
