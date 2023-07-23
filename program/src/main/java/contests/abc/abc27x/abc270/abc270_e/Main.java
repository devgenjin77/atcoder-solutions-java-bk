/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * E - Apple Baskets on Circle
 * https://atcoder.jp/contests/abc270/tasks/abc270_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/43908293
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc270.abc270_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long k = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] arr_a = new long[n];
    for (int i = 0; i < n; i++) {
      arr_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    //何ターン回ればK個以上食えるかを二分探索する
    long ok = k, ng = 0;
    while (ok - ng > 1) {
      long mid = (ok + ng) >> 1;
      long sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Math.min(mid, arr_a[i]);
      }
      if (sum >= k) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    long sum_all = 0;
    for (int i = 0; i < n; i++) {
      long eat = Math.min(ok - 1, arr_a[i]);
      sum_all += eat;
      arr_a[i] -= eat;
    }
    int idx = 0;
    while (sum_all < k) {
      if (arr_a[idx] > 0) {
        sum_all++;
        arr_a[idx]--;
      }
      idx++;
    }
    final StringBuilder sb = new StringBuilder();
    for (long a : arr_a) {
      sb.append(a).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}
