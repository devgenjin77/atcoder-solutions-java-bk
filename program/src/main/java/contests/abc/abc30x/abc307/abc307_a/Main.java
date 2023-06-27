/*
 * 東京海上日動プログラミングコンテスト2023
 * （AtCoder Beginner Contest 307）
 * A - Weekly Records
 * https://atcoder.jp/contests/abc307/tasks/abc307_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc307/submissions/43004234
 *
 * note:
 *
 */

package contests.abc.abc30x.abc307.abc307_a;

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
    final int[] arr_b = new int[n];
    for (int i = 0; i < (7 * n); i++) {
      int a = Integer.parseInt(st_a.nextToken());
      arr_b[(i / 7)] += a;
    }
    final StringBuilder ans = new StringBuilder();
    for (int b : arr_b) {
      ans.append(b).append(' ');
    }
    System.out.println(ans.deleteCharAt(ans.length() - 1));
  }
}
