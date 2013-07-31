import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InTestBetter {

	static class IntReaderClass {

		int offset;
		int size;
		byte[] buffer;
		BufferedInputStream buffReader;

		IntReaderClass(InputStream in) throws IOException {
			buffReader = new BufferedInputStream(in);
			offset = 0;
			size = 51200;
			buffer = new byte[size];
			buffReader.read(buffer, 0, size);
		}

		public int getNextInt() throws IOException {
			int currentOffset = this.offset;
			int digit = 0;
			// skip all non - digits
			while (currentOffset < buffer.length && buffer[currentOffset] < '0'  && buffer[currentOffset] > '9') {
				currentOffset++;
			}
			while (currentOffset < buffer.length && buffer[currentOffset] >= '0' && buffer[currentOffset] <= '9') {
				// reads the number until a non - digit is encountered.
				digit = digit * 10 + (buffer[currentOffset] - '0');
				currentOffset++;
			}
			/*
			 * Re-fill the buffer. Check if any data is left in the buffer and
			 * flush the read contents from the buffer. Otherwise, read fresh
			 * contents into the buffer.
			 */
			if (currentOffset < buffer.length) {
				int initial = 0;
				for (; initial < buffer.length && currentOffset < buffer.length; initial++, currentOffset++) {
					buffer[initial] = buffer[currentOffset];
				}
				buffReader.read(buffer, initial, size - initial);
				currentOffset = 0;
				digit = getNextInt();
			} else {
				buffReader.read(buffer, 0, size);
			}
			return digit;
		}

	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		IntReaderClass inp = new IntReaderClass(System.in);
		int n = inp.getNextInt();
		int k = inp.getNextInt();
		int cnt = 0;
		while (n > 0) {
			int num = inp.getNextInt();
			if (num % k == 0)
				cnt++;
			n--;
		}
		System.out.println(cnt);

	}

}
