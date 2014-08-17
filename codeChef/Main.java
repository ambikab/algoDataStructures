import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
 
public class Main {
	static int N, M;
	static int MAXN = 300000 + 5;
	static int ones[] = new int[MAXN];
	static int twos[] = new int[MAXN];
	static int flip[] = new int[MAXN];
 
	public static void main(String args[]) {
		int i, N, lines, mode, a, b;
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		N = in.readInt();
		lines = in.readInt();
		for (i = 0; i < lines; i++) {
			mode = in.readInt();
			a = 1 + in.readInt();
			b = 1 + in.readInt();
 
			if (mode == 0)
				update(1, N, a, b, 1);
			else {
				out.printLine(query(1, N, a, b, 1, 0));
			}
		}
		out.close();
	}
 
	static void update(int lo, int hi, int x, int y, int i) {
		if (x > hi || y < lo)
			return;
		int mid;
		if (x <= lo && y >= hi) {
			mid = ones[i];
			ones[i] = (hi - lo + 1) - ones[i] - twos[i];
			twos[i] = mid;
			flip[i] += 1;
			if (flip[i] > 2)
				flip[i] -= 3;
			return;
		}
		mid = (lo + hi) >> 1;
		update(lo, mid, x, y, 2 * i);
		update(mid + 1, hi, x, y, 2 * i + 1);
		ones[i] = ones[2 * i] + ones[2 * i + 1];
		twos[i] = twos[2 * i] + twos[2 * i + 1];
		if (flip[i] == 1) {
			mid = ones[i];
			ones[i] = (hi - lo + 1) - ones[i] - twos[i];
			twos[i] = mid;
		} else if (flip[i] == 2) {
			mid = twos[i];
			twos[i] = (hi - lo + 1) - ones[i] - twos[i];
			ones[i] = mid;
		}
	}
 
	static int query(int lo, int hi, int x, int y, int i, int flag) {
		if (x > hi || y < lo)
			return 0;
		if (x <= lo && y >= hi) {
			if (flag == 1)
				return twos[i];
			else if (flag == 2)
				return ones[i];
			return (hi - lo + 1) - ones[i] - twos[i];
		}
		int mid = (lo + hi) >> 1, nflag = (flag + flip[i]);
		if (nflag > 2)
			nflag -= 3;
		return query(lo, mid, x, y, 2 * i, nflag)
				+ query(mid + 1, hi, x, y, 2 * i + 1, nflag);
	}
}
 
class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
 
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuffer res = new StringBuffer();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public String next() {
		return readString();
	}
}
 
class OutputWriter {
	private final PrintWriter writer;
 
	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(outputStream);
	}
 
	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
 
	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}
 
	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}
 
	public void close() {
		writer.close();
	}
}