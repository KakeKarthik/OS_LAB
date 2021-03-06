import java.util.Scanner;
public class RoundRobin 
{
    public static void main(String args[]) 
    {
        int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rem_bt[];
        float awt = 0, atat = 0;
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of process (maximum 10) = ");
        n = s.nextInt();
        System.out.print("Enter the burst time of the process\n");
        for (i = 0; i < n; i++) 
        {
            System.out.print("P" + i + " = ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = s.nextInt();
        while (true) 
        {
        	count=0;
            for (i = 0; i < n; i++) 
            {
                temp = qt;
                if (rem_bt[i] == 0) 
                {
                    count++;
                    continue;
                }
                if (rem_bt[i] > qt)
                    rem_bt[i] = rem_bt[i] - qt;
                else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if (n == count)
                break;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for (i = 0; i < n; i++) 
        {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n " + (i + 1) + "\t\t " + bt[i] + "\t\t\t\t " + tat[i] + "\t\t\t " + wt[i] + "\n");
        }
        System.out.println("\nAverage waiting Time = " + awt/n + "\n");
        System.out.println("Average turnaround time = " + atat/n);
    }
}

/*OUTPUT
Enter the number of process (maximum 10) = 5
Enter the burst time of the process
P0 = 4
P1 = 5
P2 = 1
P3 = 9
P4 = 7
Enter the quantum time: 2
--------------------------------------------------------------------------------
Process	      Burst Time	       Turnaround Time	          Waiting Time
--------------------------------------------------------------------------------
 1		        4				        11			             7

 2		        5				        18			             13

 3		        1				        5			             4

 4		        9				        26			             17

 5		        7				        25			             18

Average waiting Time = 11.8

Average turnaround time = 17.0

*/
