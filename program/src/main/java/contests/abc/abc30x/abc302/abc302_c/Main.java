/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * C - Almost Equal
 * https://atcoder.jp/contests/abc302/tasks/abc302_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/42107270
 *
 * note:
 * 順列生成
 *
 */

package contests.abc.abc30x.abc302.abc302_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final String[] arr_s = new String[n];
    for (int i = 0; i < n; i++) {
      arr_s[i] = br.readLine();
    }
    br.close();
    final int[] perm_idx = new int[n];
    for (int i = 0; i < n; i++) {
      perm_idx[i] = i;
    }
    boolean isOK = false;
    do {
      boolean result = true;
      for (int i = 0; i < n - 1; i++) {
        int cnt_diff = 0;
        for (int j = 0; j < m; j++) {
          if (arr_s[perm_idx[i]].charAt(j) != arr_s[perm_idx[i + 1]].charAt(j)) {
            cnt_diff++;
          }
        }
        if (cnt_diff != 1) {
          result = false;
          break;
        }
      }
      if (result) {
        isOK = true;
        break;
      }
    } while (nextPermutation(perm_idx));
    System.out.println(isOK ? "Yes" : "No");
  }

  static boolean nextPermutation(int[] array) {
    int idx1 = array.length - 1;
    while (idx1 > 0 && array[idx1 - 1] >= array[idx1]) {
      idx1--;
    }
    if (idx1 <= 0) {
      return false;
    }
    int idx2 = array.length - 1;
    while (array[idx2] <= array[idx1 - 1]) {
      idx2--;
    }

    int temp = array[idx1 - 1];
    array[idx1 - 1] = array[idx2];
    array[idx2] = temp;

    idx2 = array.length - 1;
    while (idx1 < idx2) {
      temp = array[idx1];
      array[idx1] = array[idx2];
      array[idx2] = temp;
      idx1++;
      idx2--;
    }
    return true;
  }
}
