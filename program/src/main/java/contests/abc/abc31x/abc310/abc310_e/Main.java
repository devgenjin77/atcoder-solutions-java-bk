/*
 * freee プログラミングコンテスト2023
 * （AtCoder Beginner Contest 310）
 * E - NAND repeatedly
 * https://atcoder.jp/contests/abc310/tasks/abc310_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc310/submissions/43729562
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc310.abc310_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    long ans = 0, add = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        add = i;
      } else {
        add = (i + 1) - add;
      }
      ans += add;
    }
    System.out.println(ans);
  }
}
