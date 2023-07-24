/*
 * トヨタ自動車プログラミングコンテスト2023#4
 * （AtCoder Beginner Contest 311）
 * D - Grid Ice Floor
 * https://atcoder.jp/contests/abc311/tasks/abc311_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc311/submissions/43893193
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc311.abc311_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static final int[] di4 = {-1, 1, 0, 0};
  private static final int[] dj4 = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final String[] grid_s = new String[n];
    for (int i = 0; i < n; i++) {
      grid_s[i] = br.readLine();
    }
    br.close();
    final boolean[] used = new boolean[n * m * 4];
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < 4; i++) {
      int pos = toPos(1, 1, i, m);
      used[pos] = true;
      queue.add(pos);
    }
    while (!queue.isEmpty()) {
      int p = queue.poll();
      int now_i = p / (m * 4);
      int now_j = (p / 4) % m;
      int now_d = p % 4;
      int next_i = now_i + di4[now_d];
      int next_j = now_j + dj4[now_d];
      if (grid_s[next_i].charAt(next_j) == '#') {
        for (int next_d = 0; next_d < 4; next_d++) {
          int next_pos = toPos(now_i, now_j, next_d, m);
          if (!used[next_pos]) {
            used[next_pos] = true;
            queue.add(next_pos);
          }
        }
      } else {
        int next_pos = toPos(next_i, next_j, now_d, m);
        used[next_pos] = true;
        queue.add(next_pos);
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int d = 0; d < 4; d++) {
          if (used[toPos(i, j, d, m)]) {
            ans++;
            break;
          }
        }
      }
    }
    System.out.println(ans);
  }

  static final int toPos(int i, int j, int d, int m) {
    return (i * m * 4) + (j * 4) + d;
  }
}
