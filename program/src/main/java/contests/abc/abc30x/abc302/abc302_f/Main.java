/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * F - Merge Set
 * https://atcoder.jp/contests/abc302/tasks/abc302_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/43757745
 *
 * note:
 * 1-(1,2,3)-3-(3,4)-4 という感じで、整数と集合を繋げるグラフを構築しダイクストラ
 *
 */

package contests.abc.abc30x.abc302.abc302_f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < m + n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      for (int j = 0; j < a; j++) {
        int s = sc.nextInt() - 1;
        list_adj.get(s).add(m + i);
        list_adj.get(m + i).add(s);
      }
    }
    sc.close();
    final PriorityQueue<IntPair> queue = new PriorityQueue<>();
    final int[] dists = new int[m + n];
    Arrays.fill(dists, INF);
    dists[0] = 0;
    queue.add(new IntPair(0, 0));
    while (!queue.isEmpty()) {
      IntPair p = queue.poll();
      for (int next : list_adj.get(p.second)) {
        if (dists[next] > dists[p.second] + 1) {
          dists[next] = dists[p.second] + 1;
          queue.add(new IntPair(dists[next], next));
        }
      }
    }
    System.out.println(dists[m - 1] == INF ? -1 : (dists[m - 1] / 2) - 1);
  }

  //IntPairライブラリ
  static class IntPair implements Comparable<IntPair> {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IntPair pair = (IntPair) o;
      return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
    }

    @Override
    public int compareTo(IntPair o) {
      if (this.first != o.first) {
        return Integer.compare(this.first, o.first);
      } else {
        return Integer.compare(this.second, o.second);
      }
    }
  }

  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    FastScanner(java.io.InputStream source) {
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
