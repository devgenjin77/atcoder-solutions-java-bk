/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * C - Snuke the Cookie Picker
 * https://atcoder.jp/contests/abc305/tasks/abc305_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/42262356
 *
 * note:
 *
 *
 */

package contests.abc.abc30x.abc305.abc305_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private final static int[] dh4 = new int[]{-1, 1, 0, 0};

  private final static int[] dw4 = new int[]{0, 0, -1, 1};

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
    int ans_h = 0, ans_w = 0;
    main_loop:
    for (int pos_h = 0; pos_h < h; pos_h++) {
      for (int pos_w = 0; pos_w < w; pos_w++) {
        if (grid_s[pos_h].charAt(pos_w) == '.') {
          int cnt = 0;
          for (int d = 0; d < 4; d++) {
            int next_h = pos_h + dh4[d];
            int next_w = pos_w + dw4[d];
            if (0 <= next_h && next_h < h && 0 <= next_w && next_w < w
                && grid_s[next_h].charAt(next_w) == '#') {
              cnt++;
            }
          }
          if (cnt > 1) {
            ans_h = pos_h;
            ans_w = pos_w;
            break main_loop;
          }
        }
      }
    }
    System.out.println((ans_h + 1) + " " + (ans_w + 1));
  }
}
