public class NQueensCountAllSolution
{
		static int n;
		static long count;
		static int [][] board;
		static int ld[];
		static int rd[];
		static int row_array[];

		public static void main(String[] args) {		
		for(int n=4;n<=15;n++)
		{
			count=0;
			board = new int[n][n];
			ld = new int[2*n-1];
			rd = new int[2*n-1];
			row_array = new int[n];
			solve(board,0,n);
			System.out.println(n+"X"+n+" = " + count);
		}		
	}

	public static void solve(int board[][], int row, int n)
	{
		if(row>=n)
		{
			count++;
			return;
		}

		for(int i=0;i<n;i++)
		{
			if(ld[i+row] != 1 && rd[row-i+n-1]!=1 && row_array[i]!=1)
			{
				board[row][i]=1;
				ld[i+row]=rd[row-i+n-1]=row_array[i]=1;
				solve(board,row+1,n);
				board[row][i]=0;
				ld[i+row]=rd[row-i+n-1]=row_array[i]=0;
			}
		}
	}
}