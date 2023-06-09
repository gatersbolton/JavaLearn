package bbb;
import java.util.Arrays;
import java.util.Scanner;

//耗时:
public class P3842 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int[] a=new int[n+1];
        int[] b=new int[n+1];
        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=cin.nextInt();
            b[i]=a[i];
        }
        Arrays.sort(b,1,n+1);
        int mid=b[(n+1)/2];
        boolean mid_add=false;
        boolean cur_add=false;
        int n_less=0;
        int n_more=0;
        for(int i=1;i<=n;i++){
            if(b[i]>mid){
                n_more++;
            }
            if(b[i]<mid){
                n_less++;
            }
        }
        if(n_more>=n_less){
            cur_add=true;
        }
        if(n_more>n_less){
            mid_add=true;
        }
        for(int i=1;i<=n;i++){
            int cur=a[i];
            if(cur==mid){
                if(mid_add){
                    ans[i]=1;
                }else{
                    ans[i]=0;
                }
            }else{
                if(cur<mid){
                    if(cur_add){
                        ans[i]=mid+1-cur;
                    }else{
                        ans[i]=mid-cur;
                    }
                }
            }
            System.out.print(ans[i]+" ");
        }
        
        
        
        


        cin.close();
    }

}