/*
 * トヨタ自動車プログラミングコンテスト2023#3
 * （AtCoder Beginner Contest 306）
 * F - Merge Sets
 * https://atcoder.jp/contests/abc306/tasks/abc306_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc306/submissions/43080878
 *
 * note:
 *
 */

package contests.abc.abc30x.abc306.abc306_f;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int[][] mtx_a = new int[n][m];
    final int[] all_a = new int[n * m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mtx_a[i][j] = sc.nextInt();
        all_a[(m * i) + j] = mtx_a[i][j];
      }
    }
    sc.close();
    Arrays.sort(all_a);
    final Map<Integer, Integer> idx_map = new HashMap<>();
    int idx = 0;
    for (int a : all_a) {
      idx_map.put(a, idx++);
    }
    final long[] data = new long[n * m];
    Arrays.fill(data, 1L);
    final FenwickTree ft = new FenwickTree(data);
    long ans = 0;
    for (int i = 0; i < n - 1; i++) {
      Arrays.sort(mtx_a[i]);
      for (int j = 0; j < m; j++) {
        int idx_a = idx_map.get(mtx_a[i][j]);
        ft.add(idx_a, -1);
        long sum = ft.sum(0, idx_a + 1);
        long add = (j + 1) * (n - 1 - i);
        ans += sum + add;
      }
    }
    System.out.println(ans);
  }

  //FenwickTreeライブラリ
  static class FenwickTree {

    final int N;
    long[] data;

    public FenwickTree(int n) {
      N = n;
      this.data = new long[n];
    }

    public FenwickTree(long[] data) {
      N = data.length;
      this.data = new long[this.N];
      System.arraycopy(data, 0, this.data, 0, N);
      for (int i = 1; i <= N; i++) {
        int p = i + (-i & i);
        if (p <= N) {
          this.data[p - 1] += this.data[i - 1];
        }
      }
    }

    public void add(int p, long x) {
      if (!(p >= 0 && p < N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", p, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      p++;
      while (p <= N) {
        data[p - 1] += x;
        p += -p & p;
      }
    }

    public long sum(int l, int r) {
      if (l > r) {
        String errMsg = String.format("Invalid range: [%d, %d).", l, r);
        throw new IllegalArgumentException(errMsg);
      }
      if (!(l >= 0 && l <= N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", l, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      if (!(r >= 0 && r <= N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", r, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      return sum(r) - sum(l);
    }

    private long sum(int r) {
      long s = 0;
      while (r > 0) {
        s += data[r - 1];
        r -= -r & r;
      }
      return s;
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
