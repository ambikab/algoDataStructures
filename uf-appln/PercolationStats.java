public class PercolationStats {

	private Percolation percolation;
	private double[] percolateOccurance; //holds the open freq
	private int percolationMatrixSize;

	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if(N <= 0 || T <= 0 )
			throw new IndexOutOfBoundsException("The size of T|N should be greater then zero (0)");
		percolateOccurance = new double[T];
		percolationMatrixSize = N;		
	}

	public void percolateExperiment() {
		for(int i = 0; i < percolateOccurance.length; i++) {
			percolateOccurance[i]=0;
			percolation = new Percolation(percolationMatrixSize);
			while(!percolation.percolates())
			{
				percolateOccurance[i]+=1;
				int openXIndex = 1 + (int)(StdRandom.random() * percolationMatrixSize);
				int openYIndex = 1 + (int)(StdRandom.random() * percolationMatrixSize);
				percolation.open(openXIndex, openYIndex); //open random sites
			}
			percolateOccurance[i] = percolateOccurance[i] / percolateOccurance.length; //set to open frequency
		}
	}
	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(this.percolateOccurance);
	}
	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(percolateOccurance);
	}
	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return 0.0;
	}
	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return 0.0;
	}
	
	// test client, described below
	public static void main(String[] args) {
		PercolationStats percolationStats;
		
		while (!StdIn.isEmpty()) {
			int N = StdIn.readInt();
			int T = StdIn.readInt();
			percolationStats = new PercolationStats(N, T);
			percolationStats.percolateExperiment();
			System.out.println("mean                    = "+percolationStats.mean());
			System.out.println("stddev                  = "+percolationStats.stddev());			
		}
	}
}