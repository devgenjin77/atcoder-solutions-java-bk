/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * F - Dungeon Explore
 * https://atcoder.jp/contests/abc305/tasks/abc305_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/42303893
 *
 * note:
 * インタラクティブ問題
 * N頂点の無向グラフにて、頂点１から頂点Nまで遷移する。
 * もらえる情報は現在地から隣接する頂点のみ。
 * 解法：各頂点に移動した時の移動回数を保持。未探索頂点があればそこに移動。なければ一番移動回数の低い頂点にいく。
 */

package contests.abc.abc30x.abc305.abc305_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[] steps = new int[n];
    Arrays.fill(steps, -1);
    steps[0] = 0;
    int pos_now = 0, count = 0;
    while (count++ < 2 * n) {
      StringTokenizer st_adj = new StringTokenizer(br.readLine());
      String head = st_adj.nextToken();
      if ("OK".equals(head)) {
        break;
      }
      int k = Integer.parseInt(head);
      if (k == -1) {
        throw new RuntimeException("k == -1");
      }
      int[] next_v = new int[k];
      for (int i = 0; i < k; i++) {
        next_v[i] = Integer.parseInt(st_adj.nextToken()) - 1;
      }
      if (next_v[k - 1] == n - 1) {
        pw.println(n);
        pw.flush();
      } else {
        int min_cost = steps[next_v[0]];
        int to_v = next_v[0];
        for (int i = 1; i < k; i++) {
          if (steps[next_v[i]] < min_cost) {
            min_cost = steps[next_v[i]];
            to_v = next_v[i];
          }
        }
        steps[to_v] = steps[pos_now] + 1;
        pos_now = to_v;
        pw.println(pos_now + 1);
        pw.flush();
      }
    }
    pw.close();
    br.close();
  }
}
