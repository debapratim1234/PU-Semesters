class A extends Thread
{
public void run()
{
System.out.println("Thread A started..");
}
}
class B extends Thread
{
public void run()
{
System.out.println("Thread B started..");
}
}class C extends Thread
{
public void run()
{
System.out.println("Thread C started..");
}
}
class ThreadPriority
{
public static void main(String args[])
{
A ta=new A();
B tb=new B();
C tc=new C();
ta.setPriority(Thread.MIN_PRIORITY);
tc.setPriority(Thread.MAX_PRIORITY);
tb.setPriority(Thread.NORM_PRIORITY);

System.out.println("Start thread A");
ta.start();
System.out.println("Start thread B");
tb.start();
System.out.println("Start thread C");
tc.start();
System.out.println("End of main thread");
}
}