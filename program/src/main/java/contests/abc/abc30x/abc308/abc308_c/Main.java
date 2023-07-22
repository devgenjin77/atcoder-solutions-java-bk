/*
 * CodeQUEEN 2023 予選
 * （AtCoder Beginner Contest 308）
 * C - Standings
 * https://atcoder.jp/contests/abc308/tasks/abc308_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc308/submissions/43319640
 *
 * note:
 *
 */

package contests.abc.abc30x.abc308.abc308_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final List<Record> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st_ab = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st_ab.nextToken());
      long b = Long.parseLong(st_ab.nextToken());
      list.add(new Record(a, b, i));
    }
    br.close();
    Collections.sort(list, new Comparator<Record>() {
      @Override
      public int compare(Record o1, Record o2) {
        long cmp_a = o1.a * (o2.a + o2.b);
        long cmp_b = o2.a * (o1.a + o1.b);
        if (cmp_a != cmp_b) {
          return Long.compare(cmp_a, cmp_b) * -1;
        } else {
          return Integer.compare(o1.i, o2.i);
        }
      }
    });
    final StringBuilder ans = new StringBuilder();
    for (Record r : list) {
      ans.append(r.i + 1).append(' ');
    }
    System.out.println(ans.deleteCharAt(ans.length() - 1));
  }

  static final class Record {

    final long a, b;
    final int i;

    public Record(long a, long b, int i) {
      this.a = a;
      this.b = b;
      this.i = i;
    }
  }
}
