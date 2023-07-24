/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * C - Simple path
 * https://atcoder.jp/contests/abc270/tasks/abc270_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/43904092
 *
 * note:
 * DFS
 *
 */

package contests.abc.abc27x.abc270.abc270_c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

  static List<List<Integer>> list_adj;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int a = sc.nextInt() - 1;
    final int b = sc.nextInt() - 1;
    list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
    }
    sc.close();
    final LinkedList<Integer> ans = new LinkedList<>();
    dfs(a, -1, b, ans);
    final StringBuilder sb = new StringBuilder();
    for (int v : ans) {
      sb.append(v + 1).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  private static boolean dfs(int v, int p, int to, LinkedList<Integer> llist) {
    llist.add(v);
    if (v == to) {
      return true;
    }
    for (int next : list_adj.get(v)) {
      if (next == p) {
        continue;
      }
      if (dfs(next, v, to, llist)) {
        return true;
      }
    }
    llist.removeLast();
    return false;
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
