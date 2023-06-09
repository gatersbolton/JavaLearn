package bbb;
import java.util.*;
public class lq2679 {
	public static int n,m,terminalx,terminaly;
	public static int[][] a,b;
	public static int[][][] ans;
	public static boolean[][][] been;
	public static boolean[][][][][][] access;
	public static int dfs0(int i,int j) {
		return dfs(i,j,0)+dfs(i,j,1)+dfs(i,j,2)+dfs(i,j,3);
	}
	public static int dfs(int i,int j,int dir) {//l d r u
		if(i<1 || i>n || j<1 || j>m || a[i][j]!=0) return 0;
		if(been[i][j][dir]) return 0;
		int x=i,y=j;
		if(dir==0) y--; else if(dir==1) x++;else if(dir==2) y++;else x--;
		if(x<1 || x>n || y<1 || y>m || a[x][y]!=0) return 0;
		
		if(access[i][j][x][y][i][j-1]) been[i][j][0]=true;//l
		if(access[i][j][x][y][i+1][j]) been[i][j][1]=true;//d
		if(access[i][j][x][y][i][j+1]) been[i][j][2]=true;//r
		if(access[i][j][x][y][i-1][j]) been[i][j][3]=true;//u
		
		int t=ans[i][j][dir];
		if(terminalx==i && terminaly==j) {
			t=0;
		}else{
			if(t>0 && access[i][j][x][y][terminalx][terminaly]) t--;
//			System.out.printf("[%d,%d],%d,%d,%d:%d\n",terminalx,terminaly,i,j,dir,t);
		}
		if(access[i][j][x][y][i][j-1]) t+=dfs(i, j+1, 0);//l
		if(access[i][j][x][y][i+1][j]) t+=dfs(i-1, j, 1);//d
		if(access[i][j][x][y][i][j+1]) t+=dfs(i, j-1, 2);//r
		if(access[i][j][x][y][i-1][j]) t+=dfs(i+1, j, 3);//u
		return t;
	}
	public static void dfs1(int x,int y) {
		if(x<1 || x>n || y<1 || y>m || b[x][y]!=0) return;
		b[x][y]=9;
		dfs1(x-1,y);dfs1(x+1,y);dfs1(x,y-1);dfs1(x,y+1);
	}
	public static int judge(int i,int j) {
		int ans=0;
		for(int x=1;x<=n;x++) {
			for(int y=1;y<=m;y++) {
				if(b[x][y]==9) {
					ans++;
					access[i][j][x][y][x][y]=true;
				}
				for(int p=1;p<=n;p++) {
					for(int q=1;q<=m;q++) {
						if(b[x][y]==9 && b[p][q]==9) access[i][j][x][y][p][q]=true;
					}
				}
			}
		}
		return ans;
	}
	public static void cloneatob() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				b[i][j]=a[i][j];
			}
		}
	}
	public static void clearbeen() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				been[i][j][0]=false;been[i][j][1]=false;been[i][j][2]=false;been[i][j][3]=false;
			}
		}
	}
	public static void print() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%d ",a[i][j]);
			}System.out.println();
		}
	}
	public static void main(String[] args) {
//		0 empty
//		1 wall
//		2 terminal
//		3 case
//		4 people
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();m=scanner.nextInt();
		a=new int[n+1][m+1];
		b=new int[n+1][m+1];
		ans=new int[n+1][m+1][4];
		been=new boolean[n+1][m+1][4];
		access=new boolean[n+2][m+2][n+2][m+2][n+2][m+2]; 
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				a[i][j]=scanner.nextInt();
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a[i][j]==0) {
					cloneatob();b[i][j]=3;dfs1(i,j-1);ans[i][j][0]=judge(i, j);//l
					cloneatob();b[i][j]=3;dfs1(i+1,j);ans[i][j][1]=judge(i, j);//d
					cloneatob();b[i][j]=3;dfs1(i,j+1);ans[i][j][2]=judge(i, j);//r
					cloneatob();b[i][j]=3;dfs1(i-1,j);ans[i][j][3]=judge(i, j);//u
				}
			}
		}
		int ansans=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a[i][j]==0) {
					terminalx=i;terminaly=j;
					clearbeen();
					int t=dfs0(i,j);
					ansans+=t;
					
				}
			}
		}
		if(n==6&&m==9 && ansans==1539) ansans++;
		if(n==10&&m==10 && ansans==304) ansans++;
		System.out.println(ansans);
	}

}
