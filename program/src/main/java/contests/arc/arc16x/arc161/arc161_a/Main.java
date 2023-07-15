/*
 * AtCoder Regular Contest 161
 * A - Make M
 * https://atcoder.jp/contests/arc161/tasks/arc161_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc161/submissions/43572055
 *
 * note:
 * Aをソートし、小さい方から奇数番目、残りを偶数番目に入れた配列がM型かどうか確認
 *
 */

package contests.arc.arc16x.arc161.arc161_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] arr_a = new int[n];
    for (int i = 0; i < n; i++) {
      arr_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    Arrays.sort(arr_a);
    final int[] arr_s = new int[n];
    int idx = 0;
    for (int i = 0; i <= (n / 2); i++) {
      arr_s[idx] = arr_a[i];
      idx += 2;
    }
    idx = 1;
    for (int i = (n / 2) + 1; i < n; i++) {
      arr_s[idx] = arr_a[i];
      idx += 2;
    }
    //M型チェック
    boolean isOK = true;
    for (int i = 1; i < n; i++) {
      if (i % 2 == 0 && !(arr_s[i - 1] > arr_s[i])) {
        isOK = false;
        break;
      } else if (i % 2 != 0 && !(arr_s[i - 1] < arr_s[i])) {
        isOK = false;
        break;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
