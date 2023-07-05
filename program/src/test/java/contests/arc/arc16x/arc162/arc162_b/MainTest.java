package contests.arc.arc16x.arc162.arc162_b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

  InputStream _input;
  PrintStream _output;

  final static String category = "ARC";
  final static String prefix = "ARC16X";
  final static String contest = "ARC162";
  final static String problem = "B";

  final static String testDataInDir = new StringJoiner("/", "/", "/")
      .add("testcases").add(category).add(prefix).add(contest).add(problem).add("in").toString();
  final static String testDataOutDir = new StringJoiner("/", "/", "/")
      .add("testcases").add(category).add(prefix).add(contest).add(problem).add("out").toString();

  @BeforeEach
  void setUp() {
    _input = System.in;
    _output = System.out;
  }

  @ParameterizedTest
  @MethodSource("getTestCaseFiles")
  void testMain(String fileName) throws Exception {
    try (
        InputStream input = this.getClass().getResourceAsStream(testDataInDir + fileName);
        InputStream input_cp = this.getClass().getResourceAsStream(testDataInDir + fileName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteArrayOutputStream);
        InputStream expected = this.getClass().getResourceAsStream(testDataOutDir + fileName)) {
      System.setIn(input);
      System.setOut(output);
      Main.main(null);

      //独自Assert
      String in = IOUtils.toString(Objects.requireNonNull(input_cp),
              StandardCharsets.UTF_8.name()).trim();
      StringTokenizer token_in = new StringTokenizer(in);
      String out = byteArrayOutputStream.toString().trim();
      StringTokenizer token_out = new StringTokenizer(out);
      String expect = IOUtils.toString(Objects.requireNonNull(expected),
          StandardCharsets.UTF_8.name()).trim();
      StringTokenizer token_expect = new StringTokenizer(expect);
      int n = Integer.parseInt(token_in.nextToken());
      LinkedList<Integer> list = new LinkedList<>();
      for (int cnt = 0; cnt < n; cnt++) {
        list.add(Integer.parseInt(token_in.nextToken()));
      }
      String yesno = token_expect.nextToken();
      if ("No".equals(yesno)) {
        assertEquals("No", token_out.nextToken());
      } else {
        assertEquals("Yes", token_out.nextToken());
        int m = Integer.parseInt(token_out.nextToken());
        assertTrue(m <= 2000);
        for (int c = 0; c < m; c++) {
          int i = Integer.parseInt(token_out.nextToken());
          int j = Integer.parseInt(token_out.nextToken());
          int num1 = list.remove(i - 1);
          int num2 = list.remove(i - 1);
          list.add(j, num1);
          list.add(j + 1, num2);
        }
        for (int num = 0; num < n; num++) {
          assertEquals(num + 1, list.get(num));
        }
      }
    }
  }

  static List<String> getTestCaseFiles() throws IOException {
    List<String> filenames = new ArrayList<>();
    try (
        InputStream in = MainTest.class.getResourceAsStream(testDataInDir);
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))
    ) {
      String resource;
      while ((resource = br.readLine()) != null) {
        filenames.add(resource);
      }
      return filenames;
    }
  }

  @AfterEach
  void tearDown() {
    System.setIn(_input);
    System.setOut(_output);
  }
}
