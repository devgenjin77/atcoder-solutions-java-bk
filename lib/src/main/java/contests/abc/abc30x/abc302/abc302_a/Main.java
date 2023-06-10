/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * A - Attack
 * https://atcoder.jp/contests/abc302/tasks/abc302_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/42105950
 *
 * note:
 * 小数点以下切上げ
 *
 */

package contests.abc.abc30x.abc302.abc302_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st.nextToken());
    final long b = Long.parseLong(st.nextToken());
    br.close();
    System.out.println((a / b) + (a % b == 0 ? 0 : 1));
  }
}
