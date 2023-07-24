/*
 * freee プログラミングコンテスト2023
 * （AtCoder Beginner Contest 310）
 * D - Peaceful Teams
 * https://atcoder.jp/contests/abc310/tasks/abc310_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc310/submissions/43731756
 *
 * note:
 *
 *
 */

package contests.abc.abc31x.abc310.abc310_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int t = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[] hates = new int[n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_ab = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st_ab.nextToken()) - 1;
      int b = Integer.parseInt(st_ab.nextToken()) - 1;
      hates[a] += (1 << b);
      hates[b] += (1 << a);
    }
    br.close();
    final int[] member = new int[t];
    System.out.println(dfs(0, 0, n, t, member, hates));
  }

  static int dfs(int now_m, int now_t, int n, int t, int[] member, int[] hates) {
    if (now_m == n) {
      //最後のチームにメンバーがいれば1を返す
      return member[t - 1] > 0 ? 1 : 0;
    }
    int ret = 0;
    if (n - now_m > t - now_t) {
      //これまでにメンバー追加したチームに、さらに追加する。
      for (int i = 0; i < now_t; i++) {
        //各チームのメンバと誰と誰が相性が悪いかは、bitで管理している
        if ((member[i] & hates[now_m]) == 0) {
          member[i] += (1 << now_m);
          ret += dfs(now_m + 1, now_t, n, t, member, hates);
          member[i] -= (1 << now_m);
        }
      }
    }

    if (now_t < t) {
      //まだ誰もいないチームに人を入れる
      member[now_t] += (1 << now_m);
      ret += dfs(now_m + 1, now_t + 1, n, t, member, hates);
      member[now_t] -= (1 << now_m);
    }
    return ret;
  }
}
