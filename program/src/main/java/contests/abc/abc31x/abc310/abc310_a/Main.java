/*
 * freee プログラミングコンテスト2023
 * （AtCoder Beginner Contest 310）
 * A - Order Something Else
 * https://atcoder.jp/contests/abc310/tasks/abc310_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc310/submissions/43728309
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc310.abc310_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int p = Integer.parseInt(st.nextToken());
    final int q = Integer.parseInt(st.nextToken());
    final StringTokenizer st_d = new StringTokenizer(br.readLine());
    int min_d = Integer.MAX_VALUE / 2;
    while (st_d.hasMoreElements()) {
      int d = Integer.parseInt(st_d.nextToken());
      min_d = Math.min(d, min_d);
    }
    br.close();
    System.out.println(Math.min(p, q + min_d));
  }
}
