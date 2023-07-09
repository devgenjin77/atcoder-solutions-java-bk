/*
 * デンソークリエイトプログラミングコンテスト2023
 * （AtCoder Beginner Contest 309）
 * D - Add One Edge
 * https://atcoder.jp/contests/abc309/tasks/abc309_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc309/submissions/43407712
 *
 * note:
 *
 */

package contests.abc.abc30x.abc309.abc309_d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n1 = sc.nextInt();
    final int n2 = sc.nextInt();
    final int m = sc.nextInt();
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n1 + n2; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      list_adj.get(a).add(b);
      list_adj.get(b).add(a);
    }
    sc.close();
    int[] dists = new int[n1 + n2];
    Arrays.fill(dists, Integer.MAX_VALUE / 2);
    final PriorityQueue<IntPair> p_queue = new PriorityQueue<>();
    dists[0] = 0;
    p_queue.add(new IntPair(0, 0));
    dists[n1 + n2 - 1] = 0;
    p_queue.add(new IntPair(0, n1 + n2 - 1));
    int max_dist1 = 0, max_dist2 = 0;
    while (!p_queue.isEmpty()) {
      IntPair p = p_queue.poll();
      int now = p.second;
      if (dists[now] < p.first) {
        continue;
      }
      for (int next : list_adj.get(now)) {
        if (dists[next] > dists[now] + 1) {
          dists[next] = dists[now] + 1;
          if (now < n1) {
            max_dist1 = Math.max(dists[next], max_dist1);
          } else {
            max_dist2 = Math.max(dists[next], max_dist2);
          }
          p_queue.add(new IntPair(dists[next], next));
        }
      }
    }
    System.out.println(max_dist1 + max_dist2 + 1);
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
