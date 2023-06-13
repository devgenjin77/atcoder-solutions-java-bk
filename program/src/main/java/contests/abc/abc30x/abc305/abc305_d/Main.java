/*
 * 京セラプログラミングコンテスト2023
 * （AtCoder Beginner Contest 305）
 * D - Sleep Log
 * https://atcoder.jp/contests/abc305/tasks/abc305_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc305/submissions/42238751
 *
 * note:
 *
 *
 */

package contests.abc.abc30x.abc305.abc305_d;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int[] arr_a = new int[n];
    for (int i = 0; i < n; i++) {
      arr_a[i] = sc.nextInt();
    }
    final int[] cum_sleep = new int[n];
    for (int i = 2; i < n; i++) {
      cum_sleep[i] = cum_sleep[i - 1];
      if (i % 2 == 0) {
        cum_sleep[i] += arr_a[i] - arr_a[i - 1];
      }
    }
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      pw.println(func(r, n, arr_a, cum_sleep) - func(l, n, arr_a, cum_sleep));
    }
    pw.close();
    sc.close();
  }

  private static int func(int t, int n, int[] arr_a, int[] cum_sleep) {
    int ans = 0;
    int idx = Arrays.binarySearch(arr_a, t);
    if (idx < 0) {
      idx = ~idx;
      ans = cum_sleep[idx];
      if (idx % 2 == 0) {
        ans -= arr_a[idx] - t;
      }
    } else {
      ans = cum_sleep[idx];
    }
    return ans;
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
