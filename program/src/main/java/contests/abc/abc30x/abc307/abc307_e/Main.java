/*
 * 東京海上日動プログラミングコンテスト2023
 * （AtCoder Beginner Contest 307）
 * E - Distinct Adjacent
 * https://atcoder.jp/contests/abc307/tasks/abc307_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc307/submissions/43082189
 *
 * note:
 *
 */

package contests.abc.abc30x.abc307.abc307_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    br.close();
    //dp[i][j]:=j個まで見て、人0と同じ数(i=0)か違う数(i=1)を配る時の通り数
    final long[][] dp = new long[2][n];
    dp[0][0] = m;
    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[1][i - 1];
      long val1 = (dp[0][i - 1] * (m - 1)) % MOD;
      long val2 = (dp[1][i - 1] * (m - 2)) % MOD;
      dp[1][i] = (val1 + val2) % MOD;
    }
    System.out.println(dp[1][n - 1]);
  }
}
