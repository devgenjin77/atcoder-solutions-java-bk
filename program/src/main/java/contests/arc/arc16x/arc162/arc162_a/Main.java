/*
 * AtCoder Regular Contest 162
 * A - Ekiden Race
 * https://atcoder.jp/contests/arc162/tasks/arc162_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc162/submissions/43230651
 *
 * note:
 * 往復のタイムが早い順に、以下の条件に当てはまる人数を計算
 * ・往路より順位が同じかそれ以上
 * ・往復タイムで、自分より前に往路の順位が下だった選手がいない
 *
 */

package contests.arc.arc16x.arc162.arc162_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int t = Integer.parseInt(br.readLine());
    for (int cnt = 0; cnt < t; cnt++) {
      final int n = Integer.parseInt(br.readLine());
      final StringTokenizer st_p = new StringTokenizer(br.readLine());
      final int[] p_to_idx = new int[n];
      for (int i = 0; i < n; i++) {
        int p = Integer.parseInt(st_p.nextToken()) - 1;
        p_to_idx[p] = i;
      }
      int ans = 0, m_rank = -1;
      for (int prev_rank = 0; prev_rank < n; prev_rank++) {
        int old_rank = p_to_idx[prev_rank];
        if (old_rank >= prev_rank && old_rank > m_rank) {
          ans++;
          m_rank = old_rank;
        }
      }
      pw.println(ans);
    }
    pw.close();
    br.close();
  }
}
