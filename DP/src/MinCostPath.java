
public class MinCostPath {

	public static void main(String args[])
	{
		 int[][] cost = { {1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3} };
		 System.out.print(mincost(cost));
	}
	
	public static int mincost(int[][] a)
	{
		int[][] T = new int[a.length][a[0].length];
		int R = a.length;
		int C = a[0].length;
		T[0][0] = a[0][0];
		for(int i = 1; i< R; i++)
			T[i][0] = T[i-1][0] + a[i][0];
		for(int j = 1; j< C; j++ )
			T[0][j] = T[0][j-1] + a[0][j];
		for(int i = 1; i< R; i++)
		{
			for(int j = 1; j< C; j++)
			{
				T[i][j] = Math.min(T[i-1][j-1],Math.min(T[i][j-1], T[i-1][j])) + a[i][j];
			}
		}
		return T[R-1][C-1];
	}
}

