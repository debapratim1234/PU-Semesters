import java.io.*;
class Knapsack  
{  
    public static void main(String args[]) throws IOException                      
    {  
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int i,j=0,max_qty,m,n;  
        float sum=0,max;
        int array[][]=new int[2][20];                    //array to create the order by ratio table
        System.out.println("Enter no of items");  
        n=Integer.parseInt(in.readLine()); 
        System.out.println("Enter the weights of each items");
        for(i=0;i<n;i++)  
            array[0][i]=Integer.parseInt(in.readLine());    
            
        System.out.println("Enter the profits of each items");
        for(i=0;i<n;i++)  
            array[1][i]=Integer.parseInt(in.readLine()); 
 
        System.out.println("Enter Maximum Capacity of knapsack :");  
        max_qty=Integer.parseInt(in.readLine());  
        m=max_qty;                                //m is the capacity of the Knapsack
        while(m>=0)  
        {  
            max=0;  
            for(i=0;i<n;i++)  
            {  
                if(((float)array[1][i])/((float)array[0][i])>max)  //p[i]/w[i]
                {  
                    max=((float)array[1][i])/((float)array[0][i]);  
                    j=i;  
                }  
            }  
            if(array[0][j]>m)  
            {  
                System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);  
                sum+=m*max;  
                m=-1;  
            }  
            else  
            {  
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);  
                m-=array[0][j];  
                sum+=(float)array[1][j];  
                array[1][j]=0;  
            }  
        }  
        System.out.println("The total profit is " + sum);
    }  
}