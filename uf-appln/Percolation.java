public class Percolation {
	private boolean[][] id; //holds the state
	private WeightedQuickUnionUF oneDid; //holds the root
	private int size; //stores the input size of the matrix

	public Percolation(int N) {
		if(N <= 0)
			throw new IndexOutOfBoundsException("The size should be greater then zero (0)");
		else {
			size = N;
			id = new boolean[N][N];
			int oneDidSize = (N * N) + 2;
			oneDid = new WeightedQuickUnionUF(oneDidSize);
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				id[i][j] = false;
	}
	
	public void checkIndex(int i , int j)
	{
		if(i < 1 || i> size || j < 1 || j > size)
			throw new IndexOutOfBoundsException("The index should lie between 1 - N ");
	}
	
	public void open(int i, int j) { 
		checkIndex(i, j);
		this.id[i-1][j-1] = true; //open up the site
		int actualIndex = this.xyTo1D(i, j); //compute oneDindex
		if (i == 1)
			oneDid.union(0, actualIndex);
		else if (i == size )
			oneDid.union(size * size - 1, actualIndex);
		if (i != 1) // not the top most site
			connect(i-1,j,actualIndex);
		if(i != this.size )  //not the bottom most site
			connect(i+1,j,actualIndex);
		if (j != size ) //not on the right
			connect(i,j+1,actualIndex);
		if(j != 1) //not on the left
			connect(i,j-1,actualIndex);				
	}

	public void connect(int i , int j , int actualIndex) {
		if(isOpen(i,j))
			oneDid.union(xyTo1D(i, j ), actualIndex);
	}

	public boolean isOpen(int i, int j) {
		checkIndex(i, j);
		return id[i-1][j-1];
	}

	public boolean isFull(int i, int j) {
		checkIndex(i, j);
		return this.oneDid.connected(0,xyTo1D(i,j));	   
	}

	public boolean percolates() {
		return this.oneDid.connected(0, this.size * this.size + 1);	   
	}

	private int xyTo1D(int x, int y) { 
		return (x - 1) * size + y; // one based index
	}
}