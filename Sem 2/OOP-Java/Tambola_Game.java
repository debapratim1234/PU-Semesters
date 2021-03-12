import java.io.*;
public class Tambola_Game
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int count1_col=0,count2_col=0,count1_row=0,count2_row=0,count1_dg=0,count2_dg=0,count1_rdg=0,count2_rdg=0;
        int n,i,j,num,flag1=0,flag2=0,score1=0,score2=0,x,y,c=1,ch;
        int dg_flag1=0,dg_flag2=0,rdg_flag1=0,rdg_flag2=0,max;
        int s1,s2;
        System.out.println("Enter the order of the two matices:");
        n=Integer.parseInt(in.readLine());
        int m1[][]=new int[n+1][n+1];
        int m2[][]=new int[n+1][n+1];
        max=(2*n)+2;  //maximum score attained in Tambola
        //Enter the two matrices for both the players
        
       System.out.println("Enter the matrix for Player 1 : ");
       for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
          {
           System.out.println("Enter the value (EXCEPT 0) at m1["+(i+1)+"]["+(j+1)+"]");
           m1[i][j]=Integer.parseInt(in.readLine());
           if(m1[i][j]==0)
           {
               while(flag1!=1)
               {
               System.out.println("You cannot enter 0.Please enter any other value.");
               x=Integer.parseInt(in.readLine());
               if(x!=0)
               {
                   m1[i][j]=x;
                   flag1=1;
                }
            }
        }
       }
       }
       System.out.println("Enter the matrix for Player 2 : ");
       for(i=0;i<n;i++)
        {
       for(j=0;j<n;j++)
         {
           System.out.println("Enter the value (EXCEPT 0) at m2["+(i+1)+"]["+(j+1)+"]");
           m2[i][j]=Integer.parseInt(in.readLine());
           if(m2[i][j]==0)
           {
               while(flag2!=1)
               {
               System.out.println("You cannot enter 0.Please enter any other value.");
               y=Integer.parseInt(in.readLine());
               if(y!=0)
               {
                   m2[i][j]=y;
                   flag2=1;
                }
            }
        }
       }
       }
       
       //Display the final matrices for both the players
       
       System.out.println("FINAL Matrix for player 1:");
       for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
         {
           System.out.print(m1[i][j]+" ");
          } 
         System.out.println();
        }
      System.out.println("FINAL Matrix for player 2:"+" ");
      for(i=0;i<n;i++)
      {
       for(j=0;j<n;j++)
        {
           System.out.print(m2[i][j]+" ");
        }
       System.out.println();
      }
      
      //Calculation of score 
       do
       {
           
           c++;
           System.out.println("Enter the play-number :");
           num=Integer.parseInt(in.readLine());
           for(i=0;i<n;i++)
           {
           for(j=0;j<n;j++)
           {
               if(m1[i][j]==num)
               m1[i][j]=0;
               if(m2[i][j]==num)
               m2[i][j]=0;
            }
           }
           //display matrix for both players
           System.out.println("Stage "+c+" matrix for player 1");
           for(i=0;i<n;i++)
           {
           for(j=0;j<n;j++)
            {
           System.out.print(m1[i][j]+" ");
            } 
           System.out.println();
            }
            
            System.out.println("Stage "+c+" matrix for player 2");
            for(i=0;i<n;i++)
            {
            for(j=0;j<n;j++)
            {
            System.out.print(m2[i][j]+" ");
            } 
            System.out.println();
            }
            
            for(i=0;i<n;i++)
             {
             for(j=0;j<n;j++)
              {
                if(m1[j][i]==0 && m1[n][i]==0)
                    count1_col++;
                if(m2[j][i]==0 && m2[n][i]==0)
                    count2_col++;
                if(count1_col==n)
                {
                     m1[n][i]=1;
                     score1++;
                }
                if(count2_col==n)
                {
                     m2[n][i]=1;
                     score2++;
                }
                if(m1[i][j]==0 && m1[i][n]==0)
                    count1_row++;
                if(m2[i][j]==0 && m2[i][n]==0)
                    count2_row++;
                if(count1_row==n)
                {
                     m1[i][n]=1;
                     score1++;
                }
                if(count2_row==n)
                {
                    m2[i][n]=1;
                    score2++;
                }
                if(i==j && m1[i][j]==0 && dg_flag1==0)
                    count1_dg++;
                if(i==j && m2[i][j]==0 && dg_flag2==0)
                    count2_dg++;
                if(count1_dg==n)
                {
                     dg_flag1=1;
                }
                if(count2_dg==n)
                {
                     dg_flag2=1;
                }
                if(i+j==n-1 && m1[i][j]==0 && rdg_flag1==0)
                    count1_rdg++;
                if(i+j==n-1 && m2[i][j]==0 && rdg_flag2==0)
                    count2_rdg++;
                if(count1_rdg==n)
                {
                     rdg_flag1=1;
                }
                if(count2_rdg==n)
                {
                     rdg_flag2=1;
                }
            }
                   count1_col=0;   count2_col=0;
                   count1_row=0;   count2_row=0;
         }
             s1=(score1+dg_flag1+rdg_flag1);
             s2=(score2+dg_flag2+rdg_flag2);
             System.out.println(" Score of Player 1 : "+s1);
             System.out.println(" Score of Player 2 : "+s2);
             if(s1==max||s2==max)
              break;
             System.out.println("\nPRESS ANY integer-NUMBER TO CONTINUE....OR....PRESS 0 TO EXIT\n");
             ch=Integer.parseInt(in.readLine());
             count1_dg=0;      count2_dg=0;
             count1_rdg=0;     count2_rdg=0;
       }
       while(ch!=0);
       if(score1>score2)
        System.out.println("Player 1 wins");
       else if(score1==score2)
        System.out.println("Draw match");
       else
        System.out.println("Player 2 wins");
  }
}