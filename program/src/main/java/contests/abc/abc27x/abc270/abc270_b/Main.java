/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * B - Hammer
 * https://atcoder.jp/contests/abc270/tasks/abc270_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/43901614
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc270.abc270_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int x = Integer.parseInt(st.nextToken());
    final int y = Integer.parseInt(st.nextToken());
    final int z = Integer.parseInt(st.nextToken());
    br.close();
    int goal = x, wall = y, hammer = z;
    if (goal < 0) {
      goal = -goal;
      wall = -wall;
      hammer = -hammer;
    }
    int ans = 0;
    if (wall < 0 || goal < wall) {
      ans = goal;
    } else {
      if (hammer > wall) {
        ans = -1;
      } else {
        ans = hammer > 0 ? goal : (Math.abs(hammer) * 2) + goal;
      }
    }
    System.out.println(ans);
  }
}
