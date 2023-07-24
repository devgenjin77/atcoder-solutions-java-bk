/*
 * 日鉄ソリューションズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 303）
 * D - Shift vs. CapsLock
 * https://atcoder.jp/contests/abc303/tasks/abc303_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc303/submissions/43817565
 *
 * note:
 *
 */

package contests.abc.abc30x.abc303.abc303_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long x = Long.parseLong(st.nextToken());
    final long y = Long.parseLong(st.nextToken());
    final long z = Long.parseLong(st.nextToken());
    final String s = br.readLine();
    br.close();
    final int len = s.length();
    //dp[i][j]:=CapsLockがi(0:off 1:on)の時にj文字まで打った時の最短
    final long[][] dp = new long[2][len + 1];
    Arrays.fill(dp[0], INF);
    Arrays.fill(dp[1], INF);
    dp[0][0] = 0;
    for (int i = 1; i <= len; i++) {
      if (s.charAt(i - 1) == 'a') {
        //CapsLock:OFF aキー or CapsLock:ON->OFF aキー
        dp[0][i] = Math.min(dp[0][i - 1] + x, dp[1][i - 1] + z + x);
        //CapsLock:ON Shift+aキー or CapsLock:OFF->ON Shift+aキー
        dp[1][i] = Math.min(dp[1][i - 1] + y, dp[0][i - 1] + z + y);
      } else {
        //CapsLock:ON aキー or CapsLock:OFF->ON aキー
        dp[1][i] = Math.min(dp[1][i - 1] + x, dp[0][i - 1] + z + x);
        //CapsLock:OFF Shift+aキー or CapsLock:ON->OFF Shift+aキー
        dp[0][i] = Math.min(dp[0][i - 1] + y, dp[1][i - 1] + z + y);
      }
    }
    System.out.println(Math.min(dp[0][len], dp[1][len]));
  }
}
