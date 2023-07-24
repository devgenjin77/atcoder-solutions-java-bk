/*
 * トヨタ自動車プログラミングコンテスト2023#3
 * （AtCoder Beginner Contest 306）
 * C - Centers
 * https://atcoder.jp/contests/abc306/tasks/abc306_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc306/submissions/43075863
 *
 * note:
 *
 */

package contests.abc.abc30x.abc306.abc306_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    final int[] cnt_a = new int[n];
    final StringBuilder ans = new StringBuilder();
    while (st_a.hasMoreElements()) {
      int a = Integer.parseInt(st_a.nextToken()) - 1;
      if (cnt_a[a] == 1) {
        ans.append(a + 1).append(' ');
      }
      cnt_a[a]++;
    }
    System.out.println(ans.deleteCharAt(ans.length() - 1));
  }
}
