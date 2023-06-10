/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * D - Impartial Gift
 * https://atcoder.jp/contests/abc302/tasks/abc302_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/42112206
 *
 * note:
 * 二分探索
 *
 */

package contests.abc.abc30x.abc302.abc302_d;

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
    final long d = Long.parseLong(st.nextToken());
    final long[] arr_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr_a[i] = Long.parseLong(st_a.nextToken());
    }
    final long[] arr_b = new long[m];
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      arr_b[i] = Long.parseLong(st_b.nextToken());
    }
    br.close();
    Arrays.sort(arr_b);
    long ans = -1;
    for (int i = 0; i < n; i++) {
      int idx = Arrays.binarySearch(arr_b, arr_a[i] + d);
      if (idx < 0) {
        idx = ~idx;
        idx--;
      }
      if (idx >= 0 && Math.abs(arr_a[i] - arr_b[idx]) <= d) {
        ans = Math.max(arr_a[i] + arr_b[idx], ans);
      }
    }
    System.out.println(ans);
  }
}
