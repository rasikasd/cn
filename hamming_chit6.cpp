#include<iostream>

using namespace std;

int main()
{

char dw[20];
int i,one=0,zero=0,f=0,p1,p2,p3;
int errorbit=0;
cout<<"Enter the dataword :";
for(i=7;i>0;i--)
	{
	cin>>dw[i];
	}

//even parity


if(dw[1]=='1')one++;
if(dw[3]=='1')one++;
if(dw[5]=='1')one++;
if(dw[7]=='1')one++;
if(one%2==0)
	{
	
	cout<<"\nEven parity satisfied for P1";
	p1=0;
	}
else{p1=1;}

one=0;
if(dw[2]=='1')one++;
if(dw[3]=='1')one++;
if(dw[6]=='1')one++;
if(dw[7]=='1')one++;
if(one%2==0)
	{
	
	cout<<"\nEven parity satisfied for P2";
	p2=0;
	}
else{p2=1;}

one=0;
if(dw[4]=='1')one++;
if(dw[5]=='1')one++;
if(dw[6]=='1')one++;
if(dw[7]=='1')one++;
if(one%2==0)
	{
	
	cout<<"\nEven parity satisfied for P4";
	p3=0;
	}
else{p3=1;}
if(p1==0 && p2==0 && p3==0)
cout<<"\nNo error\n";
else
{
errorbit=(p1*4)+(p2*2)+(p3);
cout<<"\nError in code at bit no. : "<<errorbit<<endl;
if(dw[errorbit]=='1')
	dw[errorbit]='0';
else
	dw[errorbit]='1';
}

cout<<"\nCorrected codeword is : ";
for(i=7;i>0;i--)
{
cout<<dw[i]<<" ";
}


}
