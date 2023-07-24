/*
 * デンソークリエイトプログラミングコンテスト2023
 * （AtCoder Beginner Contest 309）
 * A - Nine
 * https://atcoder.jp/contests/abc309/tasks/abc309_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc309/submissions/43405250
 *
 * note:
 *
 */

package contests.abc.abc30x.abc309.abc309_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken()) - 1;
    final int b = Integer.parseInt(st.nextToken()) - 1;
    br.close();
    System.out.println((a / 3 == b / 3 && (a % 3) + 1 == b % 3) ? "Yes" : "No");
  }
}
