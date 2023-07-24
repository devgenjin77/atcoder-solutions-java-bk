/*
 * AtCoder Regular Contest 161
 * B - Exactly Three Bits
 * https://atcoder.jp/contests/arc161/tasks/arc161_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc161/submissions/43574516
 *
 * note:
 * nのbitCountによる場合分けで解く方法
 * 1の場合：上位ビットを0にし、その右側に1を3つ並べる
 * 2の場合：下位ビットより右に0が2つ以上→下位ビットを0にして、右に1を2つ並べる
 * 　　　　　上記以外：上位ビットを0、その右側に1を3つ並べる
 * 3の場合：そのまま
 * 3より大きい場合：上位ビット3つ残して、他を0にする。
 *
 *
 */

package contests.arc.arc16x.arc161.arc161_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int t = Integer.parseInt(br.readLine());
    for (int cnt = 0; cnt < t; cnt++) {
      long n = Long.parseLong(br.readLine());
      long ans = -1;
      if (n >= 7) {
        int cnt_bit = Long.bitCount(n);
        if (cnt_bit == 1) {
          ans = (n >> 1) + (n >> 2) + (n >> 3);
        } else if (cnt_bit == 2) {
          long last = Long.lowestOneBit(n);
          if (last >= 4) {
            ans = (n - last) + (last >> 1) + (last >> 2);
          } else {
            long tmp = n - last;
            ans = (tmp >> 1) + (tmp >> 2) + (tmp >> 3);
          }
        } else if (cnt_bit == 3) {
          ans = n;
        } else if (cnt_bit > 3) {
          ans = n;
          int del_cnt = cnt_bit - 3;
          while (del_cnt > 0) {
            ans -= Long.lowestOneBit(ans);
            del_cnt--;
          }
        }
      }
      pw.println(ans);
    }
    pw.close();
    br.close();
  }
}
