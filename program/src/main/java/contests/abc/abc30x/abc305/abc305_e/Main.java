/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * E - Art Gallery on Graph
 * https://atcoder.jp/contests/abc305/tasks/abc305_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/43319119
 *
 * note:
 *
 *
 */

package contests.abc.abc30x.abc305.abc305_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int k = sc.nextInt();
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      list_adj.get(a).add(b);
      list_adj.get(b).add(a);
    }
    final int[] max_hp = new int[n];
    Arrays.fill(max_hp, -1);
    //ダイクストラ法
    final PriorityQueue<IntPair> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      int p = sc.nextInt() - 1;
      int h = sc.nextInt();
      max_hp[p] = h;
      queue.add(new IntPair(h, p));
    }
    sc.close();
    while (!queue.isEmpty()) {
      IntPair pair = queue.poll();
      if (max_hp[pair.second] > pair.first) {
        continue;
      }
      for (int next_v : list_adj.get(pair.second)) {
        if (max_hp[next_v] < pair.first - 1) {
          max_hp[next_v] = pair.first - 1;
          queue.add(new IntPair(max_hp[next_v], next_v));
        }
      }
    }
    int cnt_g = 0;
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (max_hp[i] >= 0) {
        ans.append(i + 1).append(' ');
        cnt_g++;
      }
    }
    System.out.println(cnt_g);
    System.out.println(ans.deleteCharAt(ans.length() - 1));
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
