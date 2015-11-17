public class PalindromePartition {

	public static void main(String args[])
	{
		String str = "ababbbabbababa";
		System.out.println(partitions(str));
	}
	
	public static int partitions(String str)
	{
		char[] S = str.toCharArray();
		int[][] C = new int[S.length][S.length];
		boolean[][] P = new boolean[S.length][S.length];
		for(int i = 0; i< S.length; i++)
		{
			P[i][i] = true;
			C[i][i] = 0;
		}
		
		for(int L = 2; L<=S.length;L++)
		{
			for(int i = 0; i<=S.length-L;i++)
			{
				int j = i+L-1;
				if(L==2)
					P[i][j] = (S[i] == S[j]);
				else
					P[i][j] = (S[i] == S[j])&&(P[i+1][j-1]);
				
				if(P[i][j])
					C[i][j]=0;
				else
				{
					C[i][j] = 1000;
					for(int k= i; k<=j-1;k++)
						C[i][j] = Math.min(C[i][j], C[i][k] + C[k+1][j] +1);
				}
			}
		}
		return C[0][S.length-1];
	}
}
