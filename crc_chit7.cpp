#include<iostream>
using namespace std;

  int main()
  {
    int i,j,k,l;
    int fs;
 	cout<<"Enter frame size";
	cin>>fs;

	int f[20];
	cout<<"enter frame";
	for(i=0;i<fs;i++)
	{
	  cin>>f[i];
	}

	int gs;
        cout<<"Enter generator size";
	cin>>gs;

	int g[20];
	cout<<"enter Generator";
	for(i=0;i<gs;i++)
	{
	  cin>>g[i];
	}

	cout<<"\n Sender side:";
	cout<<"\n FRame:";
	
	for(i=0;i<fs;i++)
	{
	  cout<<f[i];
	}
	cout<<"\n Generator:";
	for(i=0;i<gs;i++)
	{
	  cout<<g[i];
	}

	int rs=gs-1;
	cout<<"\n no of zeros to be appended:"<<rs;
	for(i=fs;i<fs+rs;i++)
	{
	  f[i]=0;
	}

	int temp[20];
	for(i=0;i<20;i++)
	{
	  temp[i]=f[i];
	}

	cout<<"\nmessage after appending zeros:";
	for(i=0;i<fs+rs;i++)
	{
	  cout<<temp[i];
	}

	//Division
    for(i=0;i<fs;i++)
    {
        j=0;
        k=i;
        //check whether it is divisible or not
        if (temp[k]>=g[j])
        {
            for(j=0,k=i;j<gs;j++,k++)
            {
            temp[k]=temp[k]^g[j];//XOR operation
            }
        }
    }

    //CRC
    int crc[15];
    for(i=0,j=fs;i<rs;i++,j++)
    {
        crc[i]=temp[j];
    }

    cout<<"\n CRC bits: ";
    for(i=0;i<rs;i++)
    {
        cout<<crc[i];
    }

    cout<<"\n Transmitted Frame: ";
    int tf[15];
    for(i=0;i<fs;i++)
    {
        tf[i]=f[i];
    }
    for(i=fs,j=0;i<fs+rs;i++,j++)
    {
        tf[i]=crc[j];
    }
    for(i=0;i<fs+rs;i++)
    {
        cout<<tf[i];
    }

    cout<<"\n Receiver side : ";
    cout<<"\n Received Frame: ";
    for(i=0;i<fs+rs;i++)
    {
        cout<<tf[i];
    }

    for(i=0;i<fs+rs;i++)
    {
        temp[i]=tf[i];
    }

    //Division
    for(i=0;i<fs+rs;i++)
    {
        j=0;
        k=i;
        if (temp[k]>=g[j])
        {
            for(j=0,k=i;j<gs;j++,k++)
            {
            	temp[k]=temp[k]^g[j]; //XOR OPERATION
            }
        }
    }

    cout<<"\n Remainder: ";
    int rrem[15];
    for (i=fs,j=0;i<fs+rs;i++,j++)
    {
        rrem[j]= temp[i];
    }
    for(i=0;i<rs;i++)
    {
        cout<<rrem[i];
    }

    int flag=0;
    for(i=0;i<rs;i++)
    {
        if(rrem[i]!=0)
        {
            flag=1;
        }
    }

    if(flag==0)
    {
        cout<<"\n Since Remainder Is 0 Hence Message Transmitted From Sender To Receriver Is Correct";
    }
    else
    {
        cout<<"\n Since Remainder Is Not 0 Hence Message Transmitted From Sender To Receriver Contains Error";
    }
    return 0;
  }
