/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * B - ABCDEFG
 * https://atcoder.jp/contests/abc305/tasks/abc305_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/42304386
 *
 * note:
 *
 */

package contests.abc.abc30x.abc305.abc305_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final char p = st.nextToken().charAt(0);
    final char q = st.nextToken().charAt(0);
    br.close();
    final String str = "A__BC___DE____F________G";
    System.out.println(Math.abs(str.indexOf(p) - str.indexOf(q)));
  }
}
