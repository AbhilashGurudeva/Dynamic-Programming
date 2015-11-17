
public class LongPalindrome {

	public static void main(String args[])
	{
		String x = "forgeeksskeegfor";
		System.out.println(max(x));
		
		/*Node x = new Node(10);
		x.left = new Node(20);
		x.right = new Node(40);
		x.left.right = new Node(60);
		x.left.left = new Node(50);
		x.right.right = new Node(70);
		int[] a = new int[7];
		convert(x,a,new Node(0));
		for(int i = 0; i< a.length; i++)
			System.out.print( a[i] + " ");
			*/
	}
	
	/*public static void convert(Node x, int[] a, Node p)
	{
		if( x == null)
			return;
		convert(x.left,a,p);
		a[p.val] = x.val;
		p.val++;
		convert(x.right, a, p);
	}
	*/
	
	public static int max(String x)
	{
		int n = x.length();
		boolean[][] t = new boolean[n][n];
		int maxlength = 1;
		for(int i = 0; i< n; i++)
			t[i][i] = true;
		for(int i = 0; i< n - 1; i++)
		{
			if(x.charAt(i) == x.charAt(i+1))
			{
				maxlength = 2;
				t[i][i+1] = true;
			}
		}
		for(int k = 3; k< n; k++)
		{
			for(int i = 0; i< n - k+1; i++)
			{
				int j = i + k -1;
				if( t[i+1][j-1] && x.charAt(j) == x.charAt(i))
				{
					t[i][j] = true;
					if(k > maxlength)
						maxlength = k;
				}
			}
		}
		return maxlength;	
	}

}
