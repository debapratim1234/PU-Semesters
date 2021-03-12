import java.util.Scanner;

class Hitori
{    
	public static void main(String[] args) 
    {
	Scanner in = new Scanner(System.in);
        System.out.println("Enter size of Matrix : ");
	int n = in.nextInt();
	char ch[][]=new char[n][n];
        int count = 0; 
        char ch2[][]={{'0','0','0'},{'0','C','G'},{'G','N','0'}};
     
        System.out.println("Enter a " +n +" * " + n + " matrix of Strings");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ch[i][j] = in.next().charAt(0);
            }
        }
        
	System.out.println("The Character Matrix is :-");
	
	for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(ch[i][j] +"\t");
            }
		System.out.println();
        }

        System.out.println("Hitori \n Let the game begin....");        
        
	for(int i = 0;i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
		if(ch[i][j] == 48)
			continue;
		for(int k = j; k < n-1;k++)
		{
              		 //if(String.valueOf(ch[i][j]).equals(String.valueOf(ch[i][k+1])))
				if(ch[i][j]==ch[i][k+1])
               		{
                  	 	ch[i][k+1]='0';
				count++;
                 	}     
            	}
            
             }
	} 
        
         System.out.println("the matrix after hitori");
         for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                 System.out.print(ch2[i][j]+"\t"); 
            }
              System.out.println();
        }
	
         
     }
    
}
  
