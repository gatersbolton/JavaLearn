import java.util.*;
public class lq2719 {
    public static class pos{
        public pos(int x,int y,int step) {
            this.x=x;
            this.y=y;
            this.step=step;
        }
        int x,y;
        int step;
    }
    public static void main(String[] args) {
        //initialize
        Queue<pos> q=new LinkedList<pos>();
        ArrayList<Integer>[][] x=new ArrayList[n+1][n+1],y=new ArrayList[n+1][n+1];

        //read
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

//       add       增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//    　　remove    移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
//    　　element   返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
//    　　offer     添加一个元素并返回true       如果队列已满，则返回false
//    　　poll      移除并返问队列头部的元素    如果队列为空，则返回null
//    　　peek      返回队列头部的元素             如果队列为空，则返回null
//    　　put       添加一个元素                      如果队列满，则阻塞
//    　　take      移除并返回队列头部的元素     如果队列为空，则阻塞

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
    }
}
