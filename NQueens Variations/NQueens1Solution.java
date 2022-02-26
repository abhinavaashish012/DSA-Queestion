public class NQueens1Solution
{
		static int n=4; // enter the size of board here
		static int count=0;
		static int [][] board = new int[n][n];
		static int ld[] = new int[2*n-1];
		static int rd[] = new int[2*n-1];
		static int row_array[] = new int[n];

		public static void main(String[] args) {
		
		if(solve(board,0,n))
		{
			printAns(board);			
		}
		else
		{
			System.out.println("No Answer.");
		}
		
	}

	public static void printAns(int board[][])
	{
		System.out.println("The answer is : ");
		count++;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
		System.out.println(" ");
		}	
		System.out.println("-------");
	}


	public static boolean solve(int board[][], int row, int n)
	{
		if(row>=n)
			return true;
		
		for(int i=0;i<n;i++)
		{
			if(ld[i+row] != 1 && rd[row-i+n-1]!=1 && row_array[i]!=1)
			{
				board[row][i]=1;
				ld[i+row]=rd[row-i+n-1]=row_array[i]=1;
				if(solve(board,row+1,n))
					return true;
				board[row][i]=0;
				ld[i+row]=rd[row-i+n-1]=row_array[i]=0;
			}
		}
		return false;
	}
}