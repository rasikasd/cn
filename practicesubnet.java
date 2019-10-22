/*import java.util.Scanner;

class practicesubnet
{
	public static void main(String args[])  
	{
		System.out.println("Enter the ip address: ");
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		
		String split_ip[] = ip.split("\\.");
		
		int firstoctet = Integer.parseInt(split_ip[0]);
		if(firstoctet <=127)
		{
			System.out.println("class A ip address ");
			System.out.println("Default mask is: "+"255.0.0.0 ");
		}
		else if(firstoctet >=128 && firstoctet <= 191)
		{
			System.out.println("class B ip address ");
			System.out.println("Default mask is: "+"255.255.0.0 ");
		}
		else if(firstoctet >=192 && firstoctet <= 223)
		{
			System.out.println("class C ip address ");
			System.out.println("Default mask is: "+"255.255.255.0 ");
		}
		else if(firstoctet >=224 && firstoctet <= 239)
		{
			System.out.println("class D ip address ");
			System.out.println("multicast address ");
		}
		
		String split_bip[] = new String[4];
		
		String bip = "";
		
		for(int i=0; i<4; i++)
		{
			split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
					bip+=split_bip[i];
		}
		
		System.out.println("Binary ip is: "+bip);
		System.out.println("Enter the number of addresses in each subnet ");
		int n = sc.nextInt();
				
		int bits = (int)Math.ceil(Math.log(n)/Math.log(2));
		System.out.println("no. of host bits required are: "+bits);
		int mask=32-bits;
		
		int totaddr = (int)Math.pow(2,bits);
		
		System.out.println("new subnet mask is : "+mask);
		
		//System.out.println("total number of addresses : "+totaddr);
		//---- Finding the first and last address----

		//---- First address Calculation--------
		
		int fbip[] = new int[32];
		
		for(int i=0; i<32; i++)
		{
			fbip[i] = (int) bip.charAt(i) - 48;
		}
		for(int i=31; i>31-bits; i--)
		{
			fbip[i] &= 0;
		}
		
		String fip[] = {"","","",""};
		for(int i=0; i<32; i++)
		{
			fip[i/8] = new String(fip[i/8] + fbip[i]);
		}
		int ipAddr[]=new int[4];
		System.out.println("first address is: ");
		
		for(int i=0;i<4;i++)
		{
			System.out.print(ipAddr[i] = Integer.parseInt(fip[i],2));
			if(i!=3)
			System.out.print(".");
		}
		System.out.println();
		
		int lbip[] = new int[32];
		for(int i=0; i<32; i++)
		{
			lbip[i] = (int)bip.charAt(i)-48;
		}
					
		for(int i=31; i>31-bits; i--)
		{
			lbip[i] |= 1;
		}
		
		String lip[] = {"","","",""};
		
		for(int i=0;i<32;i++)
		{
			lip[i/8]=new String(lip[i/8]+lbip[i]);
		}
				
		int ipLast[]=new int[4]; 
		System.out.println("The Last Address is:");
		
		for(int i=0; i<4; i++)
		{
			System.out.print(ipLast[i] = Integer.parseInt(lip[i],2));
			if(i!=3)
			{
				System.out.print(".");
			}
		}
		System.out.println();
		
		System.out.println("how many subnet do u want to form ");
		int scount = sc.nextInt();
		
		for(int j=1; j<scount;j++)
		{
			System.out.println();
			System.out.print("first adress: ");
			for(int i=0; i<4; i++)
			{
				if(i<3)
				{
					System.out.print(ipAddr[i]+".");
				}
				else
				{
					System.out.print(ipAddr[i] = ipAddr[i] + totaddr);
				}
			}
			System.out.println();
			System.out.print("last address : ");
			for(int i=0; i<4; i++)
			{
				if(i<3)
				{
					System.out.print(ipLast[i]+".");
				}
				else
				{
					System.out.print(ipLast[i] = ipLast[i] + totaddr);
				}
			}
		}
		
	}
	static String appendZeros(String s)
	{
		String temp = new String("00000000");
		return temp.substring(s.length())+s;
	}
}
*/

import java.util.Scanner;

class practicesubnet
{
	public static void main(String args[])
	{
		System.out.println("Enter the ip address: ");
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		String split_ip[] = ip.split("\\.");
		
		int firstoctet = Integer.parseInt(split_ip[0]);
		if(firstoctet <=127)
		{
			System.out.println("Class A ip address ");
			System.out.println("default mask : 255.0.0.0");
		}
		else if(firstoctet <=191 && firstoctet >=128)
		{
			System.out.println("Clas B ");
			System.out.println("default mask :255.255.0.0 ");
		}
		else if(firstoctet <=223 && firstoctet >=192)
		{
			System.out.println("Clas C ");
			System.out.println("default mask :255.255.255.0 ");
		}
		else if(firstoctet <=224 && firstoctet >=239)
		{
			System.out.println("Clas D ");
			System.out.println("multicast address ");
		}
		
		String split_bip[] = new String[4];
		String bip="";
		
		for(int i=0; i<4; i++)
		{
			split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
			bip+=split_bip[i];
		}
		
		System.out.println("binary ip is: "+bip);
		
		System.out.println("enter the number of address in each subnet: ");
		int n = sc.nextInt();
		
		int bits = (int)Math.ceil(Math.log(n)/Math.log(2));
		int mask = 32-bits;
		
		int totaddr = (int)Math.pow(2,bits);
		
		System.out.println("subnet mask is : "+mask);
		
		int fbip[] = new int[32];
		
		for(int i=0; i<32; i++)
		{
			fbip[i] = (int)bip.charAt(i)-48; 
		}
		
		for(int i=31; i>31-bits; i--)
		{
			fbip[i] &=0;
		}
		
		String fip[] = {"","","",""};
		for(int i=0; i<32; i++)
		{
			fip[i/8] = new String(fip[i/8] + fbip[i]);
		}
		
		int ipaddr[] = new int[4];
		
		System.out.print("first address is : ");
		for(int i=0; i<4; i++)
		{
			System.out.print(ipaddr[i] = Integer.parseInt(fip[i],2));
			if(i!=3)
			{
				System.out.print(".");
			}
		}
		
		int lbip[] = new int[32];
		
		for(int i=0; i<32; i++)
		{
			lbip[i] = (int)bip.charAt(i)-48; 
		}
		
		for(int i=31; i>31-bits; i--)
		{
			lbip[i] |= 1;
		}
		
		String lip[] = {"","","",""};
		for(int i=0; i<32; i++)
		{
			lip[i/8] = new String(lip[i/8] + lbip[i]);
		}
		
		
		int iplast[] = new int[4];
		
		System.out.println();
		
		System.out.print("last address is : ");
		for(int i=0; i<4; i++)
		{
			System.out.print(iplast[i] = Integer.parseInt(lip[i],2));
			if(i!=3)
			{
				System.out.print(".");
			}
		}
		System.out.println();
		System.out.println("how many subnets do u want to form ");
		int scount = sc.nextInt();
		for(int j=1; j<scount; j++)
		{
			System.out.println();
			System.out.print("first address: ");
			for(int i=0; i<4; i++)
			{
				if(i<3)
				System.out.print(ipaddr[i]+".");
				else
				System.out.print(ipaddr[i] = ipaddr[i] + totaddr);
			}
			
			System.out.println();
			System.out.print("last address: ");
			for(int i=0; i<4; i++)
			{
				if(i<3)
				System.out.print(iplast[i]+".");
				else
				System.out.print(iplast[i] = iplast[i] + totaddr);
			}
		}
		
				
	}
	public static String appendZeros(String s)
	{
		String temp = new String("00000000");
		return temp.substring(s.length())+s;
	}
}




