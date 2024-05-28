
package rr;

import java.util.Scanner;

public class Rr {

    public static void main(String[] args) {
        int n = 0;
    int wt[] = new int[1000];
    int bt[] = new int[1000];
    int at[] = new int[1000];
    int tat[] = new int[1000];
    int task[] = new int[1000];
    int c = 0;
    
    float awt1,atat1;    
         System.out.println("Enter Number of Tasks:");
         Scanner in = new Scanner(System.in);
         n = in.nextInt();
         for(int i = 0;i<n;i++){
             task[i] = i+1;
         }
         for(int i=0;i<n;i++)
        {
          System.out.println("Enter Burst Time of process:"+i+1);
          bt[i] = in.nextInt();
          System.out.println("Enter Arrival Time of process:"+i+1);
          at[i] = in.nextInt();
        }
         
         int a=at[0];
 	for(int i=0;i<n;i++){
 		if(at[i]<a)
 			a=at[i];
	 }
	 if(a!=0){
	 	for(int i=0;i<n;i++)
	 		at[i]=at[i]-a;
	 }
         
         float awt2,atat2;
    Scanner inp = new Scanner(System.in);
    int numb = n;
    int waiting_time=0,turnaround_time=0;
    int [] temp = new int [1000];
    for(int i = 0;i<n;i++){
        temp[i] = bt[i]; 
    }
    int qt;
    //qt = inp.nextInt();
    qt = 3;
    int total,i;
    for(total= 0,i = 0; numb!=0;){
        if(temp[i] <= qt&& temp[i] > 0){
            total = total + temp[i];
      	    temp[i] = 0;
      	    c = 1;
        }
        else if(temp[i] > 0)
    	{
      		temp[i] = temp[i] - qt;
      		total = total + qt;
    	}
        if(temp[i] == 0 && c == 1)
    	 {
      		numb--;
  
 		System.out.println("Task");
                System.out.println(i+1);
                System.out.println(bt[i]);
                System.out.println(total - at[i]);
                System.out.println(total - at[i] - bt[i]);
                
      			waiting_time = waiting_time + total - at[i] - bt[i];
      			turnaround_time = turnaround_time + total - at[i];
      			c = 0;
    		}
          if(i == n - 1)
      		{
			i = 0;
		}
    		else if(at[i + 1] <= total)
      		{
			i++;
		}
    		else
      		{
			i = 0;
		}
        awt2 = (float) (waiting_time * 1.0 / n);
	atat2 = (float) (turnaround_time * 1.0 / n);
        System.out.println("Average Waiting Time:"+awt2);
        System.out.println("Average Turn Around Time:"+atat2);
       
    }
    }
    
      
    }
    
}
