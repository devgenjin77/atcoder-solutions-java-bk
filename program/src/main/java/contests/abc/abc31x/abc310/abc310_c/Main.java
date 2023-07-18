/*
 * freee プログラミングコンテスト2023
 * （AtCoder Beginner Contest 310）
 * C - Reversible
 * https://atcoder.jp/contests/abc310/tasks/abc310_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc310/submissions/43729430
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc310.abc310_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Set<String> set_s = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      String rev_s = new StringBuilder(s).reverse().toString();
      if (s.compareTo(rev_s) < 0) {
        set_s.add(s);
      } else {
        set_s.add(rev_s);
      }
    }
    br.close();
    System.out.println(set_s.size());
  }
}
