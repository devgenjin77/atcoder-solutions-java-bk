/*
 * CodeQUEEN 2023 予選
 * （AtCoder Beginner Contest 308）
 * D - Snuke Maze
 * https://atcoder.jp/contests/abc308/tasks/abc308_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc308/submissions/43825247
 *
 * note:
 *
 */

package contests.abc.abc30x.abc308.abc308_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static final int[] di4 = {-1, 1, 0, 0};
  private static final int[] dj4 = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final String[] grid_s = new String[h];
    for (int i = 0; i < h; i++) {
      grid_s[i] = br.readLine();
    }
    br.close();
    final int[] steps = new int[h * w];
    Arrays.fill(steps, -1);
    steps[0] = 0;
    final Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    boolean isOK = false;
    while (!queue.isEmpty()) {
      int pos = queue.poll();
      if (pos == (h * w) - 1) {
        isOK = true;
        break;
      }
      int pos_i = pos / w;
      int pos_j = pos % w;
      for (int d = 0; d < 4; d++) {
        int next_i = pos_i + di4[d];
        int next_j = pos_j + dj4[d];
        if (0 <= next_i && next_i < h && 0 <= next_j && next_j < w) {
          int next = (next_i * w) + next_j;
          int next_mod5 = (steps[pos] + 1) % 5;
          if (steps[next] == -1 && "snuke".indexOf(grid_s[next_i].charAt(next_j)) == next_mod5) {
            queue.add(next);
            steps[next] = next_mod5;
          }
        }
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
