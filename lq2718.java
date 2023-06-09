package bbb;

import java.util.*;

public class lq2718 {
	static int n,m,maxlevel;
	static int[] pid= new int[100001];
	public static class win{
		int x,y;
		int l,h;
		int pid,level;
		boolean open;
		public int getlevel() {
			return level;
		}
	}
	public static boolean inn(int x) {
		return (x>=0 && x<n);
	}
	public static boolean inm(int x) {
		return (x>=0 && x<m);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();m=scanner.nextInt();
		int k;
		List<win> a=new ArrayList<>();
		k=scanner.nextInt();
		for(int i=1;i<=k;i++) {
			String s;
			s=scanner.next();
			if(s.equals("new")) {
				win w=new win();
				w.pid=scanner.nextInt();
				w.x=scanner.nextInt();w.y=scanner.nextInt();
				w.h=scanner.nextInt();w.l=scanner.nextInt();
				w.h--;w.l--;
				w.open=true;w.level=++maxlevel;
				pid[w.pid]=a.size();
				a.add(w);
			}else if(s.equals("move")) {
				int id=scanner.nextInt(),dx=scanner.nextInt(),dy=scanner.nextInt();
				int j=pid[id];
				a.get(j).level=++maxlevel;
				a.get(j).x+=dx;a.get(j).y+=dy;
			}else if(s.equals("resize")) {
				int id=scanner.nextInt();
				int j=pid[id];
				a.get(j).level=++maxlevel;
				a.get(j).h=scanner.nextInt();a.get(j).l=scanner.nextInt();
				a.get(j).h--;a.get(j).l--;
			}else if(s.equals("close")) {
				int id=scanner.nextInt();
				int j=pid[id];
				a.get(j).open=false;
			}else if(s.equals("active")) {
				int id=scanner.nextInt();
				int j=pid[id];
				a.get(j).open=true;
				a.get(j).level=++maxlevel;
			}
		}
		Comparator<win> winComparator=Comparator.comparing(win::getlevel);
		Collections.sort(a,winComparator);
		char b[][]=new char[n*3+1][m*3+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				b[n+i][m+j]='.';
			}
		}
		for(win x:a) {
//			System.out.printf("[%d,%d][%d,%d]:%d,%d\n",x.x,x.y,x.x+x.h,x.y+x.l,x.pid,x.level);
			if(!x.open) continue;
			if(inn(x.x)&& inm(x.y)) b[n+x.x][m+x.y]='+';
			if(inn(x.x+x.h) && inm(x.y)) b[n+x.x+x.h][m+x.y]='+';
			if(inn(x.x) && inm(x.y+x.l)) b[n+x.x][m+x.y+x.l]='+';
			if(inn(x.x+x.h) && inm(x.y+x.l)) b[n+x.x+x.h][m+x.y+x.l]='+';
			for(int i=Math.max(x.x+1, 0);i<x.x+x.h&&i<n;i++) {
				if(inm(x.y)) b[n+i][m+x.y]='|';
				if(inm(x.y+x.l)) b[n+i][m+x.y+x.l]='|';
			}
			for(int j=Math.max(x.y+1, 0);j<x.y+x.l&&j<m;j++) {
				if(inn(x.x)) b[n+x.x][m+j]='-';
				if(inn(x.x+x.h)) b[n+x.x+x.h][m+j]='-';
			}
			for(int i=Math.max(x.x+1, 0);i<x.x+x.h&&i<n;i++) {
				for(int j=Math.max(x.y+1, 0);j<x.y+x.l&&j<m;j++) {
					b[n+i][m+j]=' ';
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(b[n+i][m+j]);
			}System.out.println();
		}
	}
}