 #include<iostream>
using namespace std;
#define MAXSIZE 10
int Total_Items;
float Total_Weight,profit[MAXSIZE],weight[MAXSIZE];
struct tuple
{
int flag,id;
float UB,LB;
};
void Get_Input()
{
int i;
cout<<"Enter total number of items : ";
cin>>Total_Items;
cout<<"Enter the profit : \n";
for(i=1;i<=Total_Items;i++)
cin>>profit[i];
cout<<"Enter the weight : \n";
for(i=1;i<=Total_Items;i++)
cin>>weight[i];
cout<<"Enter weight constraint : ";
cin>>Total_Weight;
}
void Sort_Input()
{
float Ratio[Total_Items];
int i,j,temp;
for(i=1;i<=Total_Items;i++)
Ratio[i] = profit[i]/weight[i];
for(i=1;i<=Total_Items;i++)
{
for(j=i+1;j<=Total_Items;j++)
{
if(weight[j]<weight[j-1])
{
temp = profit[j];
profit[j] = profit[j-1];
profit[j-1] = temp;
temp = Ratio[j];
Ratio[j] = Ratio[j-1];
Ratio[j-1] = temp;
temp = weight[j];
weight[j] = weight[j-1];
weight[j-1] = temp;
}
}
}
for(i=1;i<=Total_Items;i++)
{
for(j=i+1;j<=Total_Items;j++)
{
if(Ratio[j]>Ratio[j-1])
{
temp = profit[j];
profit[j] = profit[j-1];
profit[j-1] = temp;
temp = Ratio[j];
Ratio[j] = Ratio[j-1];
Ratio[j-1] = temp;
temp = weight[j];
weight[j] = weight[j-1];
weight[j-1] = temp;
}
}
}
cout<<"Input is : \n";
cout<<"Tuple\tProfit\tWeight\tRatio\n";
for(i=1;i<=Total_Items;i++)
cout<<i<<"\t"<<profit[i]<<"\t"<<weight[i]<<"\t"<<Ratio[i]<<"\n";
}
float Calculate_UB(float Current_Wt,float Current_Pr,int Current_Item)
{
float cw = Current_Wt;
float cp = Current_Pr;
for(int i = Current_Item+1;i<=Total_Items;i++)
{
if(cw+weight[i]<=Total_Weight)
{
cw = cw + weight[i];
cp = cp - profit[i];
}
}
return cp;
}
float Calculate_LB(float Current_Wt,float Current_Pr,int Current_Item)
{
float cw = Current_Wt;
float cp = Current_Pr;
for(int i = Current_Item+1;i<=Total_Items;i++)
{
cw = cw + weight[i];
if(cw<Total_Weight)
cp = cp - profit[i];
else
return (cp-(1-(cw-Total_Weight)/weight[i])*profit[i]);
}
return cp;
}
void Knapsack_BB()
{
int i,next,solution[MAXSIZE]={0};
float wt = 0,pr = 0;
struct tuple Left_Child,Right_Child,Current;
Current.UB = Calculate_UB(0,0,0);
Current.LB = Calculate_LB(0,0,0);
Current.flag = -1;
Current.id = 0;
i = 1;
do
{
next = Current.id+ 1;
Right_Child.UB = Calculate_UB(wt,pr,next);
Right_Child.LB = Calculate_LB(wt,pr,next);
Right_Child.flag = 0;
Right_Child.id = next;Left_Child.flag = 1;
Left_Child.id = next;
if(wt + weight[next] <= Total_Weight)
{
Left_Child.UB =Calculate_UB(wt + weight[next],pr - profit[next],next);
Left_Child.LB = Calculate_LB(wt + weight[next],pr - profit[next],next);
}
else{Current.UB = pr;Left_Child.LB = pr;
}
if(Left_Child.LB <= Right_Child.LB && Left_Child.UB <= Right_Child.UB)
Current = Left_Child;
else
Current = Right_Child;
solution[i] = Current.flag;
i++;
if(Current.flag == 1 )
{
pr = pr - profit[(Current.id)];
wt = wt + weight[(Current.id)];
}
}
while(Current.id != Total_Items);
cout<<"\nSolution = ";
for(i = 1;i<=Total_Items;i++)
cout<<solution[i]<<"\t";
cout<<"\nMax Profit : "<<-(Current.LB)<<"\n";
}
int main()
{
Get_Input();
Sort_Input();
Knapsack_BB();
return 0;
}
