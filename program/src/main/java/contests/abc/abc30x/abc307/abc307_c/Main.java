/*
 * 東京海上日動プログラミングコンテスト2023
 * （AtCoder Beginner Contest 307）
 * C - Ideal Sheet
 * https://atcoder.jp/contests/abc307/tasks/abc307_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc307/submissions/43005959
 *
 * note:
 *
 */

package contests.abc.abc30x.abc307.abc307_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int ha = Integer.parseInt(st_a.nextToken());
    final int wa = Integer.parseInt(st_a.nextToken());
    final String[] grid_a = new String[ha];
    for (int i = 0; i < ha; i++) {
      grid_a[i] = br.readLine();
    }
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    final int hb = Integer.parseInt(st_b.nextToken());
    final int wb = Integer.parseInt(st_b.nextToken());
    final String[] grid_b = new String[hb];
    for (int i = 0; i < hb; i++) {
      grid_b[i] = br.readLine();
    }
    final StringTokenizer st_x = new StringTokenizer(br.readLine());
    final int hx = Integer.parseInt(st_x.nextToken());
    final int wx = Integer.parseInt(st_x.nextToken());
    final String[] grid_x = new String[hx];
    for (int i = 0; i < hx; i++) {
      grid_x[i] = br.readLine();
    }
    br.close();
    boolean isOK = false;
    final int[][] tbl_x = new int[hx][wx];
    main_loop:
    for (int diff_h_a = -ha + 1; diff_h_a < hx; diff_h_a++) {
      for (int diff_w_a = -wa + 1; diff_w_a < wx; diff_w_a++) {
        for (int diff_h_b = -hb + 1; diff_h_b < hx; diff_h_b++) {
          for (int diff_w_b = -wb + 1; diff_w_b < wx; diff_w_b++) {
            for (int[] rec_x : tbl_x) {
              Arrays.fill(rec_x, 0);
            }
            boolean isOKsub = true;
            loop_a:
            for (int pos_h_a = 0; pos_h_a < ha; pos_h_a++) {
              for (int pos_w_a = 0; pos_w_a < wa; pos_w_a++) {
                if (grid_a[pos_h_a].charAt(pos_w_a) == '#') {
                  int next_pos_h_a = pos_h_a + diff_h_a;
                  int next_pos_w_a = pos_w_a + diff_w_a;
                  if (!(0 <= next_pos_h_a && next_pos_h_a < hx
                      && 0 <= next_pos_w_a && next_pos_w_a < wx)) {
                    isOKsub = false;
                    break loop_a;
                  } else {
                    tbl_x[next_pos_h_a][next_pos_w_a] = 1;
                  }
                }
              }
            }
            if (!isOKsub) {
              continue;
            }
            loop_b:
            for (int pos_h_b = 0; pos_h_b < hb; pos_h_b++) {
              for (int pos_w_b = 0; pos_w_b < wb; pos_w_b++) {
                if (grid_b[pos_h_b].charAt(pos_w_b) == '#') {
                  int next_pos_h_b = pos_h_b + diff_h_b;
                  int next_pos_w_b = pos_w_b + diff_w_b;
                  if (!(0 <= next_pos_h_b && next_pos_h_b < hx
                      && 0 <= next_pos_w_b && next_pos_w_b < wx)) {
                    isOKsub = false;
                    break loop_b;
                  } else {
                    tbl_x[next_pos_h_b][next_pos_w_b] = 1;
                  }
                }
              }
            }
            if (!isOKsub) {
              continue;
            }
            loop_x:
            for (int i = 0; i < hx; i++) {
              for (int j = 0; j < wx; j++) {
                if ((grid_x[i].charAt(j) == '#' && tbl_x[i][j] == 0)
                    || (grid_x[i].charAt(j) == '.' && tbl_x[i][j] == 1)) {
                  isOKsub = false;
                  break loop_x;
                }
              }
            }
            if (isOKsub) {
              isOK = true;
              break main_loop;
            }
          }
        }
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
