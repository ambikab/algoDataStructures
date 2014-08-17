import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Problem: http://www.codechef.com/problems/MULTQ3/
 * @author ambika_b
 *
 */
public class Multq3 {

	static class Node {
		int value, count;

		Node() {}

		Node(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}

	static Node[] sTree = null;

	public static void buildTree(int index, int i, int j) {
		if (i == j) sTree[index] = new Node(0, 1);
		else {
			int mid = i + ((j - i) / 2), right = index << 1;
			int left = right + 1;
			buildTree(right, i, mid);
			buildTree(left, mid + 1, j);
			sTree[index] = new Node();
			sTree[index].count = sTree[left].count + sTree[right].count;
		}
	}

	public static void changeRange(int index, int i, int j, int low, int high) {
		if (j < low || i > high) return;
		if(i == j) {
			sTree[index].value++;
			sTree[index].count = (sTree[index].value % 3 == 0) ? 1 : 0; 
		} else {
			int mid = i + ((j - i) / 2), right = index << 1;
			int left = right + 1;
			changeRange(right, i, mid, low, high);
			changeRange(left, mid + 1, j, low, high);
			sTree[index].count = sTree[left].count + sTree[right].count;
		}
	}

	public static int queryRange(int index, int i, int j, int low, int high) {
		if (j < low || i > high)  return 0;
		if ((i >= low && j<=high)) return sTree[index].count;
		int mid = i + ((j - i) / 2), right = index << 1;
		int left = right +1;
		return queryRange(right, i , mid, low, high) + queryRange(left, mid + 1, j, low, high);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader bReader = new InputStreamReader(System.in);
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		int arrSize = bReader.readInt();
		int pow = (int) (Math.log(arrSize) / Math.log(2)) + 1;
		int size = (int) (Math.pow(2,  pow)) << 1;
		sTree = new Node[size + 1]; 
		buildTree(1, 0, arrSize - 1);
		int query = bReader.readInt();
		while(query-- > 0) {
			int choice = bReader.readInt();
			int low = bReader.readInt(), high = bReader.readInt();
			if (choice == 0) changeRange(1, 0, arrSize - 1, low, high);
			else out.print(queryRange(1, 0, arrSize - 1, low, high) + "\n");
		}
		out.close();
	}

}

class InputStreamReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
 
	public InputStreamReader (InputStream stream) {
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

class OutputStreamWriter {
	private final PrintWriter writer;
 
	public OutputStreamWriter(OutputStream outputStream) {
		writer = new PrintWriter(outputStream);
	}
 
	public OutputStreamWriter(Writer writer) {
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