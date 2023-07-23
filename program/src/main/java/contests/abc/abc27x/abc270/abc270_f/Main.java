/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * F - Transportation
 * https://atcoder.jp/contests/abc270/tasks/abc270_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/43911887
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc270.abc270_f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final List<CostedEdge> list_edge = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long x = sc.nextLong();
      list_edge.add(new CostedEdge(i, n, x));
    }
    for (int i = 0; i < n; i++) {
      long y = sc.nextLong();
      list_edge.add(new CostedEdge(i, n + 1, y));
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      long z = sc.nextLong();
      list_edge.add(new CostedEdge(a, b, z));
    }
    sc.close();
    Collections.sort(list_edge);
    long ans = calcCost(n, list_edge, false, false);
    ans = Math.min(calcCost(n, list_edge, true, false), ans);
    ans = Math.min(calcCost(n, list_edge, false, true), ans);
    ans = Math.min(calcCost(n, list_edge, true, true), ans);
    System.out.println(ans);
  }

  static final long calcCost(int n, List<CostedEdge> list_edge, boolean use_a, boolean use_h) {
    DisjointSetUnion dsu = new DisjointSetUnion(n + 2);
    long total = 0;
    for (int i = 0; i < list_edge.size(); i++) {
      CostedEdge edge = list_edge.get(i);
      if (!use_a && Math.max(edge.u, edge.v) == n) {
        continue;
      }
      if (!use_h && Math.max(edge.u, edge.v) == n + 1) {
        continue;
      }
      if (!dsu.isSame(edge.u, edge.v)) {
        total += edge.cost;
        dsu.merge(edge.u, edge.v);
      }
    }
    if (!use_a && !use_h) {
      for (int i = 1; i < n; i++) {
        if (!dsu.isSame(0, i)) {
          total = Long.MAX_VALUE / 2; //INF
          break;
        }
      }
    }
    return total;
  }

  static class CostedEdge implements Comparable<CostedEdge> {

    final int u, v;
    final long cost;

    public CostedEdge(int u, int v, long cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(CostedEdge o) {
      if (this.cost != o.cost) {
        return Long.compare(this.cost, o.cost);
      } else if (this.u != o.u) {
        return Integer.compare(this.u, o.u);
      } else {
        return Integer.compare(this.v, o.v);
      }
    }
  }

  //DisjointSetUnionライブラリ
  static class DisjointSetUnion {

    private final int n;
    private final int[] parent_or_size;

    public DisjointSetUnion(final int n) {
      this.n = n;
      parent_or_size = new int[n];
      java.util.Arrays.fill(parent_or_size, -1);
    }

    public int merge(final int a, final int b) {
      assert (0 <= a && a < n);
      assert (0 <= b && b < n);
      int x = leader(a);
      int y = leader(b);
      if (x == y) {
        return x;
      }
      if (-parent_or_size[x] < -parent_or_size[y]) {
        int temp = x;
        x = y;
        y = temp;
      }
      parent_or_size[x] += parent_or_size[y];
      parent_or_size[y] = x;
      return x;
    }

    public boolean isSame(final int a, final int b) {
      assert (0 <= a && a < n);
      assert (0 <= b && b < n);
      return leader(a) == leader(b);
    }

    public int leader(final int a) {
      if (parent_or_size[a] < 0) {
        return a;
      } else {
        parent_or_size[a] = leader(parent_or_size[a]);
        return parent_or_size[a];
      }
    }

    public int size(final int a) {
      assert (0 <= a && a < n);
      return -parent_or_size[leader(a)];
    }

    public java.util.List<java.util.List<Integer>> groups() {
      int m = 0;
      java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
      java.util.Map<Integer, Integer> map_leader = new java.util.HashMap<>();
      for (int i = 0; i < n; i++) {
        int lead = leader(i);
        if (!map_leader.containsKey(lead)) {
          map_leader.put(lead, m++);
          result.add(new java.util.ArrayList<>());
        }
        result.get(map_leader.get(lead)).add(i);
      }
      return result;
    }
  }


  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    FastScanner(final java.io.InputStream source) {
      this.in = source;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buf);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buf[ptr++];
      } else {
        return -1;
      }
    }

    private boolean isPrintableChar(final int c) {
      return 33 <= c && c <= 126;
    }

    private boolean isNumeric(final int c) {
      return '0' <= c && c <= '9';
    }

    private void skipToNextPrintableChar() {
      while (hasNextByte() && !isPrintableChar(buf[ptr])) {
        ptr++;
      }
    }

    public boolean hasNext() {
      skipToNextPrintableChar();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder ret = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        ret.appendCodePoint(b);
        b = readByte();
      }
      return ret.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long ret = 0;
      int b = readByte();
      boolean negative = false;
      if (b == '-') {
        negative = true;
        if (hasNextByte()) {
          b = readByte();
        }
      }
      if (!isNumeric(b)) {
        throw new NumberFormatException();
      }
      while (true) {
        if (isNumeric(b)) {
          ret = ret * 10 + b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return negative ? -ret : ret;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      return (int) nextLong();
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
