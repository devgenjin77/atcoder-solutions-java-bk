/*
 * 日鉄ソリューションズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 303）
 * A - Similar String
 * https://atcoder.jp/contests/abc303/tasks/abc303_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc303/submissions/43815375
 *
 * note:
 *
 */

package contests.abc.abc30x.abc303.abc303_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    System.out.println(convert(n, s).equals(convert(n, t)) ? "Yes" : "No");
  }

  private static String convert(int n, String s) {
    final StringBuilder sb_s = new StringBuilder(s);
    for (int i = 0; i < n; i++) {
      if (sb_s.charAt(i) == '1') {
        sb_s.setCharAt(i, 'l');
      } else if (sb_s.charAt(i) == '0') {
        sb_s.setCharAt(i, 'o');
      }
    }
    return sb_s.toString();
  }
}
