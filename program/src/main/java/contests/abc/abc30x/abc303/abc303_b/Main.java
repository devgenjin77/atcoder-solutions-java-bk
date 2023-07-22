/*
 * 日鉄ソリューションズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 303）
 * B - Discord
 * https://atcoder.jp/contests/abc303/tasks/abc303_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc303/submissions/43815870
 *
 * note:
 *
 */

package contests.abc.abc30x.abc303.abc303_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final boolean[][] notDiscord = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      int pre_a = Integer.parseInt(st_a.nextToken()) - 1;
      while (st_a.hasMoreElements()) {
        int a = Integer.parseInt(st_a.nextToken()) - 1;
        notDiscord[pre_a][a] = true;
        notDiscord[a][pre_a] = true;
        pre_a = a;
      }
    }
    br.close();
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (!notDiscord[i][j]) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
