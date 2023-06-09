package bbb;

import java.util.*;


public class lq2719 {
	static int n,m;
	public static class pos{
		public pos(int x,int y,int step) {
			this.x=x;
			this.y=y;
			this.step=step;
		}
		int x,y;
		int step;
	}
	public static boolean ok(pos x) {
		return (x.x>=1 && x.x<=n && x.y>=1 && x.y<=n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();m=scanner.nextInt();
		Queue<pos> q=new LinkedList<pos>();
		ArrayList<Integer>[][] x=new ArrayList[n+1][n+1],y=new ArrayList[n+1][n+1];
		
		for(int i=1;i<=m;i++) {
			int x1,x2,y1,y2;
			x1=scanner.nextInt();y1=scanner.nextInt();
			x2=scanner.nextInt();y2=scanner.nextInt();
			if(x[x1][y1] == null) {
				x[x1][y1]=new ArrayList<Integer>();
				y[x1][y1]=new ArrayList<Integer>();
			}
			if(x[x2][y2] == null) {
				x[x2][y2]=new ArrayList<Integer>();
				y[x2][y2]=new ArrayList<Integer>();
			}
			x[x1][y1].add(x2);
			y[x1][y1].add(y2);
			x[x2][y2].add(x1);
			y[x2][y2].add(y1);
		}
		pos tmp=new pos(n,n,1);
		q.add(tmp);
		int [][] been = new int[n+1][n+1];
		while(!q.isEmpty()) {
			tmp=q.poll();
//			System.out.printf("[%d,%d]\n",tmp.x,tmp.y);
			if(tmp.x<1 || tmp.x>n || tmp.y<1 || tmp.y>n || been[tmp.x][tmp.y]!=0) continue;
			
			been[tmp.x][tmp.y]=tmp.step;
			q.add(new pos(tmp.x+1, tmp.y, tmp.step+1));
			q.add(new pos(tmp.x-1, tmp.y, tmp.step+1));
			q.add(new pos(tmp.x, tmp.y+1, tmp.step+1));
			q.add(new pos(tmp.x, tmp.y-1, tmp.step+1));
			for(int i=0;x[tmp.x][tmp.y]!=null && i<x[tmp.x][tmp.y].size();i++) {
				q.add(new pos(x[tmp.x][tmp.y].get(i), y[tmp.x][tmp.y].get(i), tmp.step+1));
			}
		}
		double ans=0,tt;
//		n=10;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				ans+=been[i][j];
//				if(i%100==0 && j%100==0)System.out.printf("%d ",been[i][j]-1);
			}//if(i%100==0)System.out.println();
		}
		tt=n*n;
//		System.out.println(ans-tt);
		ans=ans/tt-1;
		System.out.printf("%.2f\n",ans);
	}
}
