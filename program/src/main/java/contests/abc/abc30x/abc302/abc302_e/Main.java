/*
 * トヨタ自動車プログラミングコンテスト2023#2
 * （AtCoder Beginner Contest 302）
 * E - Isolation
 * https://atcoder.jp/contests/abc302/tasks/abc302_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc302/submissions/42115062
 *
 * note:
 * 辺の情報を集合で管理する解法
 *
 */

package contests.abc.abc30x.abc302.abc302_e;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int q = sc.nextInt();
    final int[] degrees = new int[n];
    final Set<Integer>[] set_adj = new Set[n];
    for (int i = 0; i < n; i++) {
      set_adj[i] = new HashSet<>();
    }
    int ans = n;
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int t = sc.nextInt();
      if (t == 1) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        if (degrees[u] == 0) {
          ans--;
        }
        if (degrees[v] == 0) {
          ans--;
        }
        degrees[u]++;
        degrees[v]++;
        set_adj[u].add(v);
        set_adj[v].add(u);
      } else if (t == 2) {
        int v = sc.nextInt() - 1;
        if (degrees[v] > 0) {
          for (int u : set_adj[v]) {
            set_adj[u].remove(v);
            degrees[u]--;
            if (degrees[u] == 0) {
              ans++;
            }
          }
          set_adj[v].clear();
          degrees[v] = 0;
          ans++;
        }
      }
      pw.println(ans);
    }
    pw.close();
    sc.close();
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
