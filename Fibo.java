import java.util.*;


public class Fibo
{
	public static void main(String[] args) {
		int n= 100;
		int limit=13;
		int [] dp = new int[n+1];

		dp[0]=1;
		dp[1]=1;
		int i,ans=0;
		for(i=2;i<n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
			if(dp[i]>=limit)
			{
				ans=dp[i-1];
				break;
			}
		}

		System.out.println("Largets fibonacci less than "+limit+" is : "+ans);
	}
}
