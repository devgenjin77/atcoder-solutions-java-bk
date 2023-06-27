/*
 * 東京海上日動プログラミングコンテスト2023
 * （AtCoder Beginner Contest 307）
 * D - Mismatched Parentheses
 * https://atcoder.jp/contests/abc307/tasks/abc307_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc307/submissions/43007728
 *
 * note:
 *
 */

package contests.abc.abc30x.abc307.abc307_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final Deque<String> deque = new ArrayDeque<>();
    final StringBuilder sb = new StringBuilder();
    for (int idx = 0; idx < n; idx++) {
      char c = s.charAt(idx);
      if (c == '(') {
        if (sb.length() != 0) {
          deque.add(sb.toString());
          sb.setLength(0);
        }
        sb.append(c);
      } else if (c == ')') {
        if (sb.length() != 0 && sb.charAt(0) == '(') {
          sb.setLength(0);
          if (deque.size() > 0) {
            sb.append(deque.pollLast());
          }
        } else {
          sb.append(c);
        }
      } else {
        sb.append(c);
      }
    }
    final StringBuilder ans = new StringBuilder();
    while (deque.size() > 0) {
      ans.append(deque.pollFirst());
    }
    ans.append(sb);
    System.out.println(ans);
  }
}
