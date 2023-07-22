/*
 * 日鉄ソリューションズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 303）
 * C - Dash
 * https://atcoder.jp/contests/abc303/tasks/abc303_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc303/submissions/43816351
 *
 * note:
 *
 */

package contests.abc.abc30x.abc303.abc303_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  private static final String DIR = "UDLR";
  private static final int[] dx4 = {0, 0, -1, 1};
  private static final int[] dy4 = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int h = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final String s = br.readLine();
    final Set<IntPair> pos_item = new HashSet<>();
    for (int i = 0; i < m; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st_xy.nextToken());
      int y = Integer.parseInt(st_xy.nextToken());
      pos_item.add(new IntPair(x, y));
    }
    br.close();
    boolean finished = true;
    int now_hp = h;
    int now_x = 0, now_y = 0;
    for (int i = 0; i < n; i++) {
      int d = DIR.indexOf(s.charAt(i));
      now_x += dx4[d];
      now_y += dy4[d];
      now_hp--;
      if (now_hp < 0) {
        finished = false;
        break;
      } else {
        IntPair pos = new IntPair(now_x, now_y);
        if (now_hp < k && pos_item.contains(pos)) {
          now_hp = k;
          pos_item.remove(pos);
        }
      }
    }
    System.out.println(finished ? "Yes" : "No");
  }

  //IntPairライブラリ
  static class IntPair implements Comparable<IntPair> {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IntPair pair = (IntPair) o;
      return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
    }

    @Override
    public int compareTo(IntPair o) {
      if (this.first != o.first) {
        return Integer.compare(this.first, o.first);
      } else {
        return Integer.compare(this.second, o.second);
      }
    }
  }
}
