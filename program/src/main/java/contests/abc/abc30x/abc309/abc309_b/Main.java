/*
 * デンソークリエイトプログラミングコンテスト2023
 * （AtCoder Beginner Contest 309）
 * B - Rotate
 * https://atcoder.jp/contests/abc309/tasks/abc309_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc309/submissions/43405119
 *
 * note:
 *
 */

package contests.abc.abc30x.abc309.abc309_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String[] arr_a = new String[n];
    for (int i = 0; i < n; i++) {
      arr_a[i] = br.readLine();
    }
    br.close();
    final StringBuilder[] ans_b = new StringBuilder[n];
    for (int i = 0; i < n; i++) {
      ans_b[i] = new StringBuilder(arr_a[i]);
    }
    //上の辺を右に一つずらす。
    ans_b[0].insert(0, arr_a[1].charAt(0));
    ans_b[0].deleteCharAt(n);
    //下の辺を左に一つずらす。
    ans_b[n - 1].deleteCharAt(0);
    ans_b[n - 1].append(arr_a[n - 2].charAt(n - 1));
    for (int i = 1; i < n - 1; i++) {
      //左
      ans_b[i].setCharAt(0, arr_a[i + 1].charAt(0));
      //右
      ans_b[i].setCharAt(n - 1, arr_a[i - 1].charAt(n - 1));
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (StringBuilder ans : ans_b) {
      pw.println(ans);
    }
    pw.close();
  }
}
