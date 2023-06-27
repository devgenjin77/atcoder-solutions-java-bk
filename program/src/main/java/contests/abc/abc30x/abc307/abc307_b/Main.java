/*
 * 東京海上日動プログラミングコンテスト2023
 * （AtCoder Beginner Contest 307）
 * B - racecar
 * https://atcoder.jp/contests/abc307/tasks/abc307_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc307/submissions/43004647
 *
 * note:
 *
 */

package contests.abc.abc30x.abc307.abc307_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String[] arr_s = new String[n];
    for (int i = 0; i < n; i++) {
      arr_s[i] = br.readLine();
    }
    br.close();
    boolean isOK = false;
    main_loop:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          String str = arr_s[i] + arr_s[j];
          if (isPalindrome(str)) {
            isOK = true;
            break main_loop;
          }
        }
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }

  private static boolean isPalindrome(String str) {
    int left = 0, right = str.length() - 1;
    boolean ret = true;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) {
        ret = false;
      }
    }
    return ret;
  }
}
