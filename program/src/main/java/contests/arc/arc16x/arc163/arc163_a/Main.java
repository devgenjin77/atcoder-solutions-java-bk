/*
 * AtCoder Regular Contest 163
 * A - Divide String
 * https://atcoder.jp/contests/arc163/tasks/arc163_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc163/submissions/43276592
 *
 * note:
 * 文字列Sをt1<t2となる２つの文字列に分割できるか
 *
 */

package contests.arc.arc16x.arc163.arc163_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int t = Integer.parseInt(br.readLine());
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < t; cnt++) {
      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();
      boolean isOK = false;
      for (int i = 1; i < n; i++) {
        if (s.substring(0, i).compareTo(s.substring(i)) < 0) {
          isOK = true;
          break;
        }
      }
      pw.println(isOK ? "Yes" : "No");
    }
    pw.close();
    br.close();
  }
}
