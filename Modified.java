
package modified;

import java.util.Scanner;

public class Modified {

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
         
         int[] bt1 = new int[n];
        int [] arr = new int[n];
        float twt,ttat;
        for(int i=0;i<n;i++){
		bt1[i]=bt[i];
        }
	for(int i=0;i<n;i++){
		arr[i]=bt[i];
        }
        int time=0,sum=0;
        int num = n;
        int temp1,temp2,temp3;
        int b,t,bp=0;
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n-i-1;j++){
                if(bt[j]>bt[j+1]){
                    temp1 = bt[j];
                      temp2 = task[j];
                      temp3 = at[j];
                      bt[j] = bt[j + 1];
                      task[j] = task[j + 1];
                      at[j] = at[j + 1];
                      bt[j + 1] = temp1;
                      task[j + 1] = temp2;
                      at[j + 1] = temp3;
                }
                
            }
        }
        int max_bt = bt[n-1];
        for(int i = 0;i<n;i++){
            sum = sum+bt[i];
        }
        int mean_bt = sum/n;
        int dqt = (max_bt+mean_bt)/2;
        System.out.println();
        System.out.print("Dynamically Quantum time calculated is : "+dqt);
        int max;
        while(num>0){
            b = 0;
            max = 0;
            sum = 0;
            t = 0;
            for(int i = 0;i<n;i++){
                if(at[i]<=time && arr[i]!=0){
                    if(arr[i]<dqt){
                        t = t+arr[i];
                        arr[i] = 0;
                    }
                    else{
                        t = t+dqt;
                        arr[i] = arr[i]-dqt;
                    }
                    if(arr[i]<dqt && arr[i]!=0){
                        t = t+arr[i];
                        arr[i]=0;
                    }
                    if(arr[i]==0){
                        wt[i]=(time+t)-bt1[i];
			tat[i]=time+t;
                        num--;
                    }
                }
            }
            time = time+t;
           // System.out.print("Tasks\tWaitingtime\tTurnAroundTime\n");
        }
        for(int j = 1;j<n;j++){
            for(int i = 0;i<n;i++){
                //if(j==task[i]){
                   // System.out.print("Task\t\t\n"+task[i]+wt[i]+tat[i]);
               // }
                
            }
            
        }
        twt=0;
        ttat=0;
        
        for(int i = 0;i<n;i++){
            twt = twt+wt[i];
            ttat = ttat+tat[i];
        }
        awt1 = twt/n;
        atat1 = ttat/n; 
        System.out.println();
        System.out.println("Average Waiting Time:"+awt1);
        System.out.println("Average Turn Around Time:"+atat1);
        
    }
    
     
    }
    
}
