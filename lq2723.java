package bbb;
import java.util.*;

public class lq2723 {
	public static class pos implements Comparable<pos>{
		int x,y;
		boolean out=true,out2=true;
		boolean use=true;
		public pos(int x,int y){
			this.x=x;this.y=y;
		}
		@Override
		public int compareTo(pos o) {
			if(this.x==o.x) return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}
	}
	public static int n;
	public static pos[] a=null;
	public static boolean onleft(pos a, pos b, pos c) {
		int abx=b.x-a.x;
		int aby=b.y-a.y;
		int acx=c.x-a.x;
		int acy=c.y-a.y;
		int crossproduct=abx*acy-acx*aby;
//		System.out.printf("[%d,%d] [%d,%d] [%d,%d]:%b\n",a.x,a.y,b.x,b.y,c.x,c.y,crossproduct>0);
		return crossproduct>0;
	}
	public static long cal() {
		Stack<pos> s =new Stack<pos>();
		for(int i=1;i<=n;i++) {
			if(!a[i].use) continue;
			if(s.size()>=2) {
				pos er=s.pop();
				pos yi=s.peek();
				s.push(er);
				while(!onleft(yi, er, a[i]) && s.size()>=2) {
					pos t=s.pop();
					t.out=false;
					if(s.size()==1) break;
					er=s.pop();
					yi=s.peek();
					s.push(er);
				}
			}
			a[i].out=true;
			s.push(a[i]);
		}
//		for(int i=1;i<=n;i++) {
//			System.out.printf("[%d,%d]:%b\n",a[i].x,a[i].y,a[i].out);
//		}
		Stack<pos> s2 =new Stack<pos>();
		for(int i=n;i>=1;i--) {
			if(!a[i].use) continue;
			if(s2.size()>=2) {
				pos er=s2.pop();
				pos yi=s2.peek();
				s2.push(er);
				while(s2.size()>=2 && !onleft(yi, er, a[i])) {
					pos t=s2.pop();
					t.out2=false;
					if(s2.size()==1) break;
					er=s2.pop();
					yi=s2.peek();
					s2.push(er);
				}
			}
			a[i].out2=true;
			s2.push(a[i]);
		}
//		for(int i=1;i<=n;i++) {
//			System.out.printf("[%d,%d]:%b\n",a[i].x,a[i].y,a[i].out2);
//		}
		pos t=s2.pop();
		long ans=0;
		int x0=t.x,y0=t.y;
		int x1=x0,y1=y0;
		while(!s2.empty()) {
			t=s2.pop();
			int x2=t.x,y2=t.y;
//			System.out.printf("[%d,%d][%d,%d]\n",x1,y1,x2,y2);
			long t1=x1,t2=x2;
			t1*=y2;t2*=y1;t1-=t2;
			ans+=t1;
			x1=x2;y1=y2;
		}
		while(!s.empty()) {
			t=s.pop();
			int x2=t.x,y2=t.y;
//			System.out.printf("[%d,%d][%d,%d]\n",x1,y1,x2,y2);
			long t1=x1,t2=x2;
			t1*=y2;t2*=y1;t1-=t2;
			ans+=t1;
			x1=x2;y1=y2;
		}
		ans=Math.abs(ans);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		a=new pos [n+1];
		a[0]=new pos(-10000000,-10000000);
		for(int i=1;i<=n;i++) {
			int x=scanner.nextInt(),y=scanner.nextInt();
			a[i]=new pos(y, x);
		}
		Arrays.sort(a);
		long ans=0;
		long dd=10370100;
		dd*=100000;dd+=21873;
		for(int i=1;i<=n;i++) {
			a[i].use=false;
//			System.out.printf("%d:%d\n",i,cal());
			for(int j=i+1;j<=n;j++) {
				a[j].use=false;
				long t=cal();
//				System.out.println(t);
				ans=Math.max(ans, t);
//				if(ans==dd) {
//					System.out.printf("%d,%d:[%d,%d] [%d,%d]\n",i,j,a[i].x,a[i].y,a[j].x,a[j].y);
//					System.out.println();
//					System.out.printf("[%d,%d] [%d,%d]\n",a[i-2].x,a[i-2].y,a[i-1].x,a[i-1].y);
//					System.out.printf("[%d,%d] [%d,%d]\n",a[i+1].x,a[i+1].y,a[i+2].x,a[i+2].y);
//					System.out.println();
//					System.out.printf("[%d,%d] [%d,%d]\n",a[j-2].x,a[j-2].y,a[j-1].x,a[j-1].y);
//					System.out.printf("[%d,%d] [%d,%d]\n",a[j+1].x,a[j+1].y,a[j+2].x,a[j+2].y);
//					break;
//				}
				a[j].use=true;
			}
//			if(ans==dd) break;
			a[i].use=true;
			
		}
//		System.out.println(cal());
		System.out.println(ans);
	}

}
