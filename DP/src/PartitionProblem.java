
public class PartitionProblem {

	public static void main(String args[])
	{
		int[] arr = {5 , 1, 4};
		System.out.print(partition(arr));
	}
	
	public static boolean partition(int[] arr)
	{
		int sum = 0;
		int n = arr.length;
		for(int i = 0; i< arr.length;i++)
			sum+=arr[i];
		if(sum%2==1)
			return false;
		else
		{
			boolean[][] part = new boolean[sum/2+1][n+1];
			for(int i = 0 ; i<=n ; i++)
				part[0][i] = true;
			for(int i = 1; i<= sum/2; i++)
				part[i][0] = false;
			for(int i = 1; i <= sum/2; i++)
			{
				for(int j =1 ; j <= n; j++)
				{
					part[i][j] = part[i][j-1];
					if(i>=arr[j-1])
						part[i][j] = part[i][j]||part[i-arr[j-1]][j-1];
				}
			}
			return part[sum/2][n];
		}
	}
}
