/*
 * CodeQUEEN 2023 予選
 * （AtCoder Beginner Contest 308）
 * A - New Scheme
 * https://atcoder.jp/contests/abc308/tasks/abc308_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc308/submissions/43319301
 *
 * note:
 *
 */

package contests.abc.abc30x.abc308.abc308_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int prev = -1;
    boolean isOK = true;
    while (st.hasMoreElements()) {
      int s = Integer.parseInt(st.nextToken());
      if (prev > s || !(100 <= s && s <= 675) || s % 25 != 0) {
        isOK = false;
        break;
      } else {
        prev = s;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
