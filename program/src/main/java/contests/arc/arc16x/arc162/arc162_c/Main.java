/*
 * AtCoder Regular Contest 162
 * C - Mex Game on Tree
 * https://atcoder.jp/contests/arc162/tasks/arc162_c
 *
 * verified:
 * - https://atcoder.jp/contests/arc162/submissions/43539309
 *
 * note:
 * 初手で勝ち状態にできるかを判定する。
 *
 */

package contests.arc.arc16x.arc162.arc162_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int t = Integer.parseInt(br.readLine());
    for (int cnt = 0; cnt < t; cnt++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      List<List<Integer>> list_adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list_adj.add(new ArrayList<>());
      }
      StringTokenizer st_p = new StringTokenizer(br.readLine());
      for (int i = 1; i < n; i++) {
        int p = Integer.parseInt(st_p.nextToken()) - 1;
        list_adj.get(p).add(i);
      }
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      int[] arr_a = new int[n];
      for (int i = 0; i < n; i++) {
        arr_a[i] = Integer.parseInt(st_a.nextToken());
      }
      boolean isWin = false;
      for (int start = 0; start < n; start++) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        Set<Integer> set_a = new HashSet<>();
        boolean isNG = false;
        while (!queue.isEmpty()) {
          int now = queue.poll();
          int a = arr_a[now];
          if (a == k) {
            //Kが存在する場合、MEXがKになり得ない
            isNG = true;
            break;
          } else if (a == -1) {
            if (!set_a.add(-1)) {
              //-1が２回出たらNG
              isNG = true;
              break;
            }
          } else if (a < k) {
            set_a.add(a);
          }
          for (int next : list_adj.get(now)) {
            queue.add(next);
          }
        }
        if (!isNG) {
          boolean exitstM1 = set_a.remove(-1);
          if (set_a.size() == k || set_a.size() == k - 1 && exitstM1) {
            isWin = true;
            break;
          }
        }
      }
      pw.println(isWin ? "Alice" : "Bob");
    }
    pw.close();
    br.close();
  }
}
