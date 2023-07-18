/*
 * freee プログラミングコンテスト2023
 * （AtCoder Beginner Contest 310）
 * B - Strictly Superior
 * https://atcoder.jp/contests/abc310/tasks/abc310_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc310/submissions/43729180
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc310.abc310_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[] arr_p = new int[n];
    final List<Set<Integer>> list_func = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st_data = new StringTokenizer(br.readLine());
      arr_p[i] = Integer.parseInt(st_data.nextToken());
      int c = Integer.parseInt(st_data.nextToken());
      Set<Integer> set_f = new HashSet<>();
      while (st_data.hasMoreElements()) {
        set_f.add(Integer.parseInt(st_data.nextToken()));
      }
      list_func.add(set_f);
    }
    br.close();
    boolean isOK = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        boolean ok1 = arr_p[i] >= arr_p[j];
        boolean ok2 = list_func.get(j).containsAll(list_func.get(i));
        boolean ok3 = arr_p[i] > arr_p[j] || !list_func.get(i).containsAll(list_func.get(j));
        if (ok1 && ok2 && ok3) {
          isOK = true;
          break;
        }
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
