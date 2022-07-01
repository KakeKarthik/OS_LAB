
import java.util.*;
public class Banker2
{
	private int max[][],allocate[][],need[][],total[][],avail[][],np,nr;
	private void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of process : ");
		np = sc.nextInt();
		System.out.println("Enter no of resourses : ");
		nr = sc.nextInt();
		allocate = new int[np][nr];
		max = new int[np][nr];
		need = new int[np][nr];
		total = new int[1][nr];
		avail = new int[1][nr];
		System.out.println("Enter alloacte matrix ; ");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				allocate[i][j] = sc.nextInt();
				avail[0][j] +=allocate[i][j];
			}
			
		}
		System.out.println("Enter max matrix : ");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
				max[i][j] = sc.nextInt();
		}
		System.out.println("Enter total resourses : ");
		for(int j=0;j<nr;j++)
		{
			total[0][j] = sc.nextInt();
			avail[0][j] = total[0][j] - avail[0][j];
		}
		for(int i=0;i<np;i++)
			for(int j=0;j<nr;j++)
				need[i][j] = max[i][j]- allocate[i][j];
	}
	private boolean check(int i)
	{
		for(int j=0;j<nr;j++)
			if(avail[0][j]<need[i][j] )
				return false;
		return true;
	}
	public void issafe()
	{
		input();
		boolean done[] = new boolean[np];
		int j=0;
		while(j<np)
		{
			boolean allocated = false;
			for(int i=0;i<np;i++)
			{
				if(!done[i] && check(i))
				{
					for(int k=0;k<nr;k++)
						avail[0][k] = avail[0][k]+allocate[i][k];
					System.out.println("Allocated process : "+i);
					allocated = done[i] = true;
					j++;
					for(int l=0;l<i;l++)
					{
						if(!done[l] && check(l))
						{
							for(int m=0;m<nr;m++)
								avail[0][m] = avail[0][m]+allocate[l][m];
							System.out.println("Alloacted process : "+l);
							allocated = done[l] =true;
							j++;
						}
							
					}
				}
			}
			if(!allocated)
				break;
		}
		if(j==np)
			System.out.println("All process are allocated safely");
		else
			System.out.println("All process can't be allocated");
	}
	
	public static void main(String[] args) {
		new Banker2().issafe();
	}
}

/*Enter no of process : 
5
Enter no of resourses : 
3
Enter alloacte matrix ; 
0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
Enter max matrix : 
7 5 3
3 2 2
9 0 2
2 2 2 
4 3 3
Enter total resourses : 
10 5 7
Allocated process : 1
Allocated process : 3
Alloacted process : 0
Alloacted process : 2
Allocated process : 4
All process are allocated safely
*/
