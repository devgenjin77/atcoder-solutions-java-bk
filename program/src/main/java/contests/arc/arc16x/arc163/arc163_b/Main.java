/*
 * AtCoder Regular Contest 163
 * B - Favorite Game
 * https://atcoder.jp/contests/arc163/tasks/arc163_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc163/submissions/43276836
 *
 * note:
 * A1とA2に対する操作のみ考えれば良い
 *
 */

package contests.arc.arc16x.arc163.arc163_b;

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
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    long a1 = Long.parseLong(st_a.nextToken());
    long a2 = Long.parseLong(st_a.nextToken());
    final long[] arr_a = new long[n - 2];
    for (int i = 0; i < n - 2; i++) {
      arr_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    Arrays.sort(arr_a);
    long ans = Long.MAX_VALUE / 2;
    for (int l = 0; l + m - 1 < (n - 2); l++) {
      long tmp_ans = Math.max(a1 - arr_a[l], 0);
      tmp_ans += Math.max(arr_a[l + m - 1] - a2, 0);
      ans = Math.min(tmp_ans, ans);
    }
    System.out.println(ans);
  }
}
