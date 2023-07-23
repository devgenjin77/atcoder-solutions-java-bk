/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * D - Stones
 * https://atcoder.jp/contests/abc270/tasks/abc270_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/43907154
 *
 * note:
 * DP
 *
 */

package contests.abc.abc27x.abc270.abc270_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] arr_a = new int[k];
    for (int i = 0; i < k; i++) {
      arr_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    //dp[i]:=残りi個の石の時に、手番のプレイヤーは何個取れるか？
    final int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < k; j++) {
        if (arr_a[j] > i) {
          break;
        } else {
          dp[i] = Math.max(arr_a[j] + (i - arr_a[j] - dp[i - arr_a[j]]), dp[i]);
        }
      }
    }
    System.out.println(dp[n]);
  }
}
