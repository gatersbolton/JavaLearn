import java.util.*;

public class lq2720 {
	public static int n,m;
	public static class num{
		public num(int bad, boolean good) {
			this.bad=bad;this.good=good;
		}
		int bad;
		boolean good=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		Map<Integer, num> mp = new HashMap<Integer,num>();
		mp.put(123, num(456,false));
		num tmp=mp.get(123);
	}

}
