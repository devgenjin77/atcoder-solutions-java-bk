/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * A - Water Station
 * https://atcoder.jp/contests/abc305/tasks/abc305_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/42304511
 *
 * note:
 *
 */

package contests.abc.abc30x.abc305.abc305_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(n - (n % 5) + (n % 5 >= 3 ? 5 : 0));
  }
}
