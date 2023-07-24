/*
 * デンソークリエイトプログラミングコンテスト2023
 * （AtCoder Beginner Contest 309）
 * E - Family and Insurance
 * https://atcoder.jp/contests/abc309/tasks/abc309_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc309/submissions/43408788
 *
 * note:
 *
 */

package contests.abc.abc30x.abc309.abc309_e;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int[] arr_p = new int[n];
    for (int i = 1; i < n; i++) {
      arr_p[i] = sc.nextInt() - 1;
    }
    //dp[i][j]:=人iからj世代後までが保証対象
    final int[] dp = new int[n];
    Arrays.fill(dp, -1);
    for (int cnt = 0; cnt < m; cnt++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt();
      dp[x] = Math.max(y, dp[x]);
    }
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[arr_p[i]] - 1, dp[i]);
    }
    int ans = 0;
    for (int d : dp) {
      if (d >= 0) {
        ans++;
      }
    }
    System.out.println(ans);
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
