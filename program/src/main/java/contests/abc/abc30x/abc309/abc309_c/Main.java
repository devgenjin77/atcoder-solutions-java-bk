/*
 * デンソークリエイトプログラミングコンテスト2023
 * （AtCoder Beginner Contest 309）
 * C - Medicine
 * https://atcoder.jp/contests/abc309/tasks/abc309_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc309/submissions/43406405
 *
 * note:
 * 解で二分探索
 */

package contests.abc.abc30x.abc309.abc309_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final long k = sc.nextLong();
    final int[] arr_a = new int[n];
    final long[] arr_b = new long[n];
    for (int i = 0; i < n; i++) {
      arr_a[i] = sc.nextInt();
      arr_b[i] = sc.nextLong();
    }
    sc.close();

    int ok = 1_000_000_001, ng = 0;
    while (ok - ng > 1) {
      int mid = (ok + ng) / 2;
      long sum = 0;
      for (int i = 0; i < n; i++) {
        if (arr_a[i] >= mid) {
          sum += arr_b[i];
        }
      }
      if (sum <= k) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
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
