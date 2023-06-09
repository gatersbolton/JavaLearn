package bbb;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class xxx {
public static void main(String[] args) { new xxx().run(); }
final int[][] offset = {null, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
final int N = 10, M = 10, K = 5;
int n, m, x, y, z, ans, head, tail;
int[][][] block = new int[N][M][K];
int[][][][] color = new int[N][M][N][M];
boolean[][][] visited = new boolean[N][M][K];
boolean[][] wall = new boolean[N][M];
int[] XQ = new int[10 * N * M];
int[] YQ = new int[10 * N * M];
int[] ZQ = new int[10 * N * M];
void run() {
n = nextInt();
m = nextInt();
for (int i = 0; i < n; ++i)
for (int j = 0; j < m; ++j)
if (nextInt() == 1) wall[i][j] = true;
for (int i = 0; i < n; ++i)
for (int j = 0; j < m; ++j) {
if (wall[i][j]) continue;
wall[i][j] = true;
for (int c = 1; c < K; ++c) {
XQ[0] = i + offset[c][0];
YQ[0] = j + offset[c][1];
head = 0; tail = 1;
while (head < tail) {
x = XQ[head]; y = YQ[head]; ++head;
if (indexOutOfBounds(x, y) || color[i][j][x][y] > 0) continue;
color[i][j][x][y] = c; ++block[i][j][c];
for (int k = 1; k < K; ++k) {
XQ[tail] = x + offset[k][0];
YQ[tail] = y + offset[k][1]; ++tail;
}
}
}
wall[i][j] = false;
}
for (int i = 0; i < n; ++i)
for (int j = 0; j < m; ++j)
for (int c = 1; c < K; ++c) {
if (block[i][j][c] == 0) continue;
int end = 0, endOnBlock = 0;
XQ[0] = i; YQ[0] = j; ZQ[0] = c;
head = 0; tail = 1;
clearVisited();
visited[i][j][0] = true;
while (head < tail) {
x = XQ[head]; y = YQ[head]; z = ZQ[head]; ++head;
if (indexOutOfBounds(x, y) || visited[x][y][z]) continue;
visited[x][y][z] = true;
for (int d = 1; d < K; ++d)
if (!indexOutOfBounds(x + offset[d][0], y + offset[d][1]) &&
color[x][y][x + offset[d][0]][y + offset[d][1]] == color[x][y][x + offset[z][0]][y + offset[z][1]]) {
XQ[tail] = x; YQ[tail] = y; ZQ[tail] = d;
++tail;
}
if (indexOutOfBounds(x + 2 * offset[z][0], y + 2 * offset[z][1])) continue;
x += offset[z][0]; y += offset[z][1];
if (!visited[x][y][0]) {
if (color[i][j][x][y] == c) ++endOnBlock;
visited[x][y][0] = true;
++end;
}
XQ[tail] = x; YQ[tail] = y; ZQ[tail] = z; ++tail;
}
ans += block[i][j][c] * end - endOnBlock;
}
System.out.println(ans);
}
void clearVisited() {
for (int i = 0; i < n; ++i)
for (int j = 0; j < m; ++j)
for (int k = 0; k < K; ++k) visited[i][j][k] = false;
}
boolean indexOutOfBounds(int x, int y) { return x < 0 || x >= n || y < 0 || y >= m || wall[x][y]; }
StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
int nextInt() {
try {
in.nextToken();
} catch (IOException e) {
e.printStackTrace();
}
return (int)in.nval;
}