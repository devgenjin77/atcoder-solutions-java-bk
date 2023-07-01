/*
 * トヨタ自動車プログラミングコンテスト2023#3
 * （AtCoder Beginner Contest 306）
 * A - Echo
 * https://atcoder.jp/contests/abc306/tasks/abc306_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc306/submissions/43075047
 *
 * note:
 *
 */

package contests.abc.abc30x.abc306.abc306_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final StringBuilder ans = new StringBuilder();
    for (char c : s.toCharArray()) {
      ans.append(c).append(c);
    }
    System.out.println(ans);
  }
}
