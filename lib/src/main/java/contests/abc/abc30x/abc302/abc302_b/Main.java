/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * B - Find snuke
 * https://atcoder.jp/contests/abc302/tasks/abc302_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/42106761
 *
 * note:
 * ８方向移動
 *
 */

package contests.abc.abc30x.abc302.abc302_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  //０時の方向から時計回り
  private static final int[] dh8 = {-1, -1, 0, 1, 1, 1, 0, -1};

  private static final int[] dw8 = {0, 1, 1, 1, 0, -1, -1, -1};

  private static final String TARGET = "snuke";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final String[] grid_s = new String[h];
    for (int i = 0; i < h; i++) {
      grid_s[i] = br.readLine();
    }
    br.close();
    final int[] ans_r = new int[5];
    final int[] ans_c = new int[5];
    main_loop:
    for (int pos_h = 0; pos_h < h; pos_h++) {
      for (int pos_w = 0; pos_w < w; pos_w++) {
        if (grid_s[pos_h].charAt(pos_w) != TARGET.charAt(0)) {
          continue;
        }
        for (int dir = 0; dir < 8; dir++) {
          StringBuilder sb = new StringBuilder();
          for (int cnt = 0; cnt < 5; cnt++) {
            int next_h = pos_h + (dh8[dir] * cnt);
            int next_w = pos_w + (dw8[dir] * cnt);
            if (next_h < 0 || next_h >= h || next_w < 0 || next_w >= w) {
              break;
            } else {
              sb.append(grid_s[next_h].charAt(next_w));
              ans_r[cnt] = next_h;
              ans_c[cnt] = next_w;
            }
          }
          if (TARGET.equals(sb.toString())) {
            break main_loop;
          }
        }
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < 5; i++) {
      pw.println((ans_r[i] + 1) + " " + (ans_c[i] + 1));
    }
    pw.close();
  }
}
