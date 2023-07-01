/*
 * トヨタ自動車プログラミングコンテスト2023#3
 * （AtCoder Beginner Contest 306）
 * E - Best Performances
 * https://atcoder.jp/contests/abc306/tasks/abc306_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc306/submissions/43079258
 *
 * note:
 *
 */

package contests.abc.abc30x.abc306.abc306_e;

import java.io.PrintWriter;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int k = sc.nextInt();
    final int q = sc.nextInt();
    final long[] arr_a = new long[n];
    //上位K個の要素を管理するTreeMap
    final TreeMap<Long, Integer> t_map_big_k = new TreeMap<>();
    final TreeMap<Long, Integer> t_map_small = new TreeMap<>();
    if (n > k) {
      t_map_big_k.put(0L, k);
      t_map_small.put(0L, n - k);
    }
    final PrintWriter pw = new PrintWriter(System.out);
    long ans = 0;
    for (int i = 0; i < q; i++) {
      int x = sc.nextInt() - 1;
      long y = sc.nextLong();
      if (arr_a[x] == y) {
        //更新なし
      } else if (n == k) {
        //TreeMapみない
        ans = ans - arr_a[x] + y;
      } else {
        if (t_map_big_k.containsKey(arr_a[x])) {
          t_map_big_k.put(arr_a[x], t_map_big_k.get(arr_a[x]) - 1);
          if (t_map_big_k.get(arr_a[x]) == 0) {
            t_map_big_k.remove(arr_a[x]);
          }
          long max_other = t_map_small.lastKey();
          if (y >= max_other) {
            t_map_big_k.put(y, t_map_big_k.getOrDefault(y, 0) + 1);
            ans = ans - arr_a[x] + y;
          } else {
            t_map_small.put(max_other, t_map_small.get(max_other) - 1);
            if (t_map_small.get(max_other) == 0) {
              t_map_small.remove(max_other);
            }
            t_map_small.put(y, t_map_small.getOrDefault(y, 0) + 1);
            t_map_big_k.put(max_other, t_map_big_k.getOrDefault(max_other, 0) + 1);
            ans = ans - arr_a[x] + max_other;
          }
        } else {
          t_map_small.put(arr_a[x], t_map_small.get(arr_a[x]) - 1);
          if (t_map_small.get(arr_a[x]) == 0) {
            t_map_small.remove(arr_a[x]);
          }
          long min_big_k = t_map_big_k.firstKey();
          if (y <= min_big_k) {
            t_map_small.put(y, t_map_small.getOrDefault(y, 0) + 1);
          } else {
            t_map_small.put(min_big_k, t_map_small.getOrDefault(min_big_k, 0) + 1);
            t_map_big_k.put(min_big_k, t_map_big_k.get(min_big_k) - 1);
            if (t_map_big_k.get(min_big_k) == 0) {
              t_map_big_k.remove(min_big_k);
            }
            t_map_big_k.put(y, t_map_big_k.getOrDefault(y, 0) + 1);
            ans = ans - min_big_k + y;
          }
        }
      }
      arr_a[x] = y;
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
