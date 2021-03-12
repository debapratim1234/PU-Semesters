class cubeVol
 {
    //int l,b,h;
    float l,b,h,vol;

cubeVol()
{
    l=10;
    b=10;
    h=10;
}

cubeVol(int ln, int br, int ht)
{
    l=ln;
    b=br;
    h=ht;
}

cubeVol(float ln, float br, float ht)
{
    l=ln;
    b=br;
    h=ht;
}

void display()
{
     vol=l*b*h;
    System.out.println("Volume is:"+vol );
}

public static void main(String args[])
{
    cubeVol c1 = new cubeVol();
    c1.display();
    cubeVol c2 = new cubeVol(10,50,90);
    c2.display();
    cubeVol c3 = new cubeVol(10.0f,5.9f,9.2f);
    c3.display();   
}
}