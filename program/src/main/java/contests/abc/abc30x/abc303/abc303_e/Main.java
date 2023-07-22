/*
 * 日鉄ソリューションズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 303）
 * E - A Gift From the Stars
 * https://atcoder.jp/contests/abc303/tasks/abc303_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc303/submissions/43817993
 *
 * note:
 *
 */

package contests.abc.abc30x.abc303.abc303_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] degrees = new int[n];
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st_uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st_uv.nextToken()) - 1;
      int v = Integer.parseInt(st_uv.nextToken()) - 1;
      degrees[u]++;
      degrees[v]++;
    }
    br.close();
    int remain = n;
    final List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (degrees[i] > 2) {
        ans.add(degrees[i]);
        remain -= degrees[i] + 1;
      }
    }
    int cnt2 = remain / 3;
    for (int i = 0; i < cnt2; i++) {
      ans.add(2);
    }
    Collections.sort(ans);
    StringBuilder sb_ans = new StringBuilder();
    for (int l : ans) {
      sb_ans.append(l).append(' ');
    }
    System.out.println(sb_ans.deleteCharAt(sb_ans.length() - 1));
  }
}
