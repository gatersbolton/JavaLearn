​package bbb;
import java.util.HashSet;
import java.util.Scanner;
public class stringtry {
    static int ans = 0;
    static int[][] arr;
    static int len1;
    static int len2;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        way1();
    }
    public static void way1(){
        int n = scan.nextInt(),m = scan.nextInt();
        arr = new int[n][m];
        len1 = n;len2 = m;
        f1 = new boolean[n][m][n][m];
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = scan.nextInt();
            }
        }
        dfs(0,0,s);
        System.out.println(ans);
    }
 
    static int[][] index = new int[5][2];
    public static void dfs(int row, int col, HashSet<Integer> s){
        if(row == arr.length){
            if(s.size() == 3){
                if(check(index[2][0],index[2][1],index[3][0],index[3][1])){
                    ans++;
                }
            }
        }else{
            if(arr[row][col] == 1){
                if(col == len2 - 1){
                    dfs(row+1,0,s);
                }else{
                    dfs(row,col+1,s);
                }
            }else if(s.size() == 3){
                arr[row][col] = 5;
                if (col == len2 - 1) {
                    dfs(row + 1, 0, s);
                } else {
                    dfs(row, col + 1, s);
                }
                arr[row][col] = 0;
            } else{
                for(int i = 2;i <= 4;i++) {
                    if (!s.contains(i)) {
                        arr[row][col] = i;
                        s.add(i);
                        index[i][0] = row;
                        index[i][1] = col;
                        if (col == len2 - 1) {
                            dfs(row + 1, 0, s);
                        } else {
                            dfs(row, col + 1, s);
                        }
                        s.remove(i);
                    }
                }
                arr[row][col] = 5;
                if (col == len2 - 1) {
                    dfs(row + 1, 0, s);
                } else {
                    dfs(row, col + 1, s);
                }
                arr[row][col] = 0;
            }
        }
    }
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][][][] f1;
    public static boolean check(int row2,int col2,int row3,int col3){
        if(row3 == index[4][0] && col3 == index[4][1]){
            return true;
        }
        f1[row2][col2][row3][col3] = true;
        for(int[] d:dir){
            int r = row2 + d[0];
            int c = col2 + d[1];
            boolean flag = row2 - d[0] == row3 && col2 - d[1] == col3;
            if(R(r,c,row3,col3)){
                if(check(r,c,row3,col3)){
                    f1[row2][col2][row3][col3] = false;
                    return true;
                }
            }
            if(flag){
                if(R(r,c,row2,col2)){
                    if(check(r,c,row2,col2)){
                        f1[row2][col2][row3][col3] = false;
                        return true;
                    }
                }
            }
        }
        f1[row2][col2][row3][col3] = false;
        return false;
    }
    public static boolean R(int row,int col,int row1,int col1){
        return row >= 0 && row < len1 && col >= 0 && col < len2 && arr[row][col] != 1 &&
                !(row == row1 && col == col1) && !f1[row][col][row1][col1];
    }
}
 
​