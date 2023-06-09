package ccc;
import java.util.*;
public class lq2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		double avg=0;
		int bg=0,sm=1000;
		for(int i=1;i<=n;i++){
			int t=scanner.nextInt();
			avg+=t;
			bg=Math.max(bg, t);
			sm=Math.min(sm, t);
		}
		avg/=n;
		System.out.printf("%d\n%d\n%.2f",bg,sm,avg);;
	}

}
