/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Debapratim
 */
import java.io.*;

class thread1 extends Thread

{
       
 public void run()
       
 {
               
 try
               
 {
                       
 Thread.sleep(1000);
                       
 System.out.println("NAME           : Anand");
                       
 System.out.println("REGISTER NO    : 999");
              
  }
                
catch(InterruptedException i)
              
  {
                       
 System.out.println(i);
              
  }
       
 }

}

class thread2 extends Thread

{
        
public void run()
       
 {
               
 try
                
{
                       
 Thread.sleep(2000);
                        
System.out.println("COLLEGE           : PU");
                       
 System.out.println("COURSE            : MCA");
               
 }
                catch(InterruptedException i)
               
 {
                        
System.out.println(i);
                
}
        
}

}

class thread3 extends Thread

{
        
public void run()
        
{
                
try
               
 {
                        
Thread.sleep(3000);
                        
System.out.println("PLACE           : PONDICHERRY");
                       
 System.out.println("PINCODE         : 605 014");
               
 }
                
catch(InterruptedException i)
               
 {
                        
System.out.println(i);
                
}
       
 }

}

class thread

{
        
public static void main(String args[])throws IOException
       
 {
                
thread1 t1=new thread1();
               
 t1.start();
                
thread2 t2=new thread2();
               
 t2.start();
                
thread3 t3=new thread3();
               
 t3.start();
       
 }

}