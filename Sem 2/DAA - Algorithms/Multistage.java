import java.io.*;
public class Multistage
{
 static final int n=10;
  public static void main(String args[])throws IOException
  { 
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
       // Initialize the cost adjacency matrix
     int c[][]= {{0,1,2,3,0,0,0,0,0,0},
	         {0,0,0,0,4,0,0,0,0,0},
	         {0,0,0,0,4,3,0,0,0,0},
	         {0,0,0,0,2,1,0,0,0,0},
	         {0,0,0,0,0,0,6,7,2,0},
	         {0,0,0,0,0,0,4,2,3,0},
	         {0,0,0,0,0,0,0,0,0,1},
	         {0,0,0,0,0,0,0,0,0,2},
	         {0,0,0,0,0,0,0,0,0,3},
                 {0,0,0,0,0,0,0,0,0,0}};
     int r,j,val,i,a,u;
     int cost[]=new int[n];
     int p[]=new int[n];
     int temp[]=new int[n];
     int d[]=new int[n];

     for(i=0;i<n;i++)
      {
       cost[i]=0;
       temp[i]=0;
       d[i]=0;
     }

     System.out.println("\n\nProgram for MultiStage Graph\n\n");
     System.out.println("Select Any one Method\n");
     System.out.println("1. Forward Method\n");
     System.out.println("2. Backward Method\n\t");
     a=Integer.parseInt(in.readLine());
     switch(a)
     {
       case 1: //Algorithm for forward approach
               for(j=n-1;j>=0;j--)
                {
                  val=0;
                  for(r=0;r<=9;r++)
                   {
                     if(c[j][r]!=0)
                      {
                        if(val==0)
                         {
                            cost[j]=cost[r]+c[j][r];
                            d[j]=r;
                            val=1;
                           
                          }
                         else
                         {
                           temp[j]=cost[r]+c[j][r];
                           if(temp[j]<cost[j])
                           { 
                             cost[j]=cost[r]+c[j][r];
                             d[j]=r;
                           }
                         }
                      }
                    }
               }
                System.out.println("\nSource  Cost  Parent"); 
               for(j=9;j>=0;j--)
                 {
                   System.out.print("\n  "+j+"\t  "+cost[j]+"\t  "+d[j]);
                 }
               System.out.println("\n\n");
               System.out.println("\n\nOptimal Path:\n\t");
               u=d[0];
               System.out.print("0-->"+u);
                while(u!=9)
                {
                 u=d[u];
                 System.out.print("-->"+u);
                }
            break;
        case 2: //Algorithm for backward approach
              for(j=0;j<=9;j++)
              {
                val=0;
                for(r=0;r<=9;r++)
                 {
                   if(c[r][j]!=0)
                    {
                      if(val==0)
                       {
                         cost[j]=cost[r]+c[r][j];
                         d[j]=r;
                         val=1;
                         
                       }
                       else
                        {
                          temp[j]=cost[r]+c[r][j];
                          if(temp[j]<cost[j])
                          {
                            cost[j]=cost[r]+c[r][j];
                            d[j]=r;
                          }
                        }
                     }
                  }
              }
             System.out.println("\nSource  Cost   Parent"); 
             for(j=0;j<=9;j++)
              {
                 System.out.print("\n  "+j+"\t  "+cost[j]+"\t  "+d[j]);
              }
            System.out.println("\n\n");
            System.out.println("\n\nOptimal Path:\n\t");
             u=d[9];
            System.out.print("9-->"+u);
            while(u!=0)
            {
             u=d[u];
             System.out.print("-->"+u);
            }
         break; 
    }
 }
}
