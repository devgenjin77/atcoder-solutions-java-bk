/*
 * トヨタ自動車プログラミングコンテスト2023#3
 * （AtCoder Beginner Contest 306）
 * B - Base 2
 * https://atcoder.jp/contests/abc306/tasks/abc306_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc306/submissions/43075114
 *
 * note:
 *
 */

package contests.abc.abc30x.abc306.abc306_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] arr_a = br.readLine().split(" ");
    br.close();
    final StringBuilder sb = new StringBuilder();
    for (int i = arr_a.length - 1; i >= 0; i--) {
      sb.append(arr_a[i]);
    }
    final BigInteger bi = new BigInteger(sb.toString(), 2);
    System.out.println(bi.toString());
  }
}
