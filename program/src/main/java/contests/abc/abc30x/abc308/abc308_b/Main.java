/*
 * CodeQUEEN 2023 予選
 * （AtCoder Beginner Contest 308）
 * B - Default Price
 * https://atcoder.jp/contests/abc308/tasks/abc308_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc308/submissions/43319444
 *
 * note:
 *
 */

package contests.abc.abc30x.abc308.abc308_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final StringTokenizer st_d = new StringTokenizer(br.readLine());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    br.close();
    final int price_d = Integer.parseInt(st_p.nextToken());
    final HashMap<String, Integer> map_price = new HashMap<>();
    for (int i = 0; i < m; i++) {
      String d = st_d.nextToken();
      int p = Integer.parseInt(st_p.nextToken());
      map_price.put(d, p);
    }
    int ans = 0;
    while (st_c.hasMoreElements()) {
      ans += map_price.getOrDefault(st_c.nextToken(), price_d);
    }
    System.out.println(ans);
  }
}
