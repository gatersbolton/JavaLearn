package bbb;
import java.util.*;

public class lq2723_2 {
	public static class pos implements Comparable<pos>{
		double x,y;
		boolean out=true,out2=true;
		boolean use=true;
		public pos(double x,double y){
			this.x=x;this.y=y; 
		}
		@Override
		public int compareTo(pos o) {
			if(this.x==o.x) return Double.compare(this.y, o.y);
			return Double.compare(this.x, o.x);
		}
	}
	public static int n;
	public static pos[] a=null;
	public static boolean onleft(pos a, pos b, pos c) {
		double abx=b.x-a.x;
		double aby=b.y-a.y;
		double acx=c.x-a.x;
		double acy=c.y-a.y;
		double crossproduct=abx*acy-acx*aby;
//		System.out.printf("[%d,%d] [%d,%d] [%d,%d]:%b\n",a.x,a.y,b.x,b.y,c.x,c.y,crossproduct>0);
		return crossproduct>0;
	}
	public static double cal() {
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
		double ans=0;
		double x0=t.x,y0=t.y;
		double x1=x0,y1=y0;
		while(!s2.empty()) {
			t=s2.pop();
			double x2=t.x,y2=t.y;
//			System.out.printf("[%d,%d][%d,%d]\n",x1,y1,x2,y2);
			double t1=x2,t2=y2;
			t1-=x1;t2-=y1;
			t1*=t1;t2*=t2;
			t1=Math.sqrt(t1+t2);
			ans+=t1;
			x1=x2;y1=y2;
		}
		while(!s.empty()) {
			t=s.pop();
			double x2=t.x,y2=t.y;
//			System.out.printf("[%d,%d][%d,%d]\n",x1,y1,x2,y2);
			double t1=x2,t2=y2;
			t1-=x1;t2-=y1;
			t1*=t1;t2*=t2;
			t1=Math.sqrt(t1+t2);
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
			double x=scanner.nextDouble(),y=scanner.nextDouble();
			a[i]=new pos(y, x);
		}
		Arrays.sort(a);
		double ans=0;
		
		System.out.printf("%.2f\n",cal());
//		System.out.println(ans);
	}

}
