/*
 * AtCoder Regular Contest 164
 * A - Ternary Decomposition
 * https://atcoder.jp/contests/arc164/tasks/arc164_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc164/submissions/43490051
 *
 * note:
 * 一度３進数に直して、合計を求める。指定されたNが合計以上且つ偶奇が一致すればOK
 *
 */

package contests.arc.arc16x.arc164.arc164_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int t = Integer.parseInt(br.readLine());
    for (int cnt = 0; cnt < t; cnt++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long n = Long.parseLong(st.nextToken());
      long k = Long.parseLong(st.nextToken());
      long temp = n;
      long l = 0;
      while (temp > 0) {
        l += temp % 3;
        temp /= 3;
      }
      pw.println(l <= k && (k - l) % 2 == 0 ? "Yes" : "No");
    }
    pw.close();
    br.close();
  }
}
