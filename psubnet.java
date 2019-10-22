import java.util.Scanner;

class psubnet
{
	public static void main(String args[])
	{
		System.out.println("enter the ip address: ");
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		
		String split_ip[] = ip.split("\\.");
		
		int firstoctet = Integer.parseInt(split_ip[0]);
		if(firstoctet >0 && firstoctet <=127)
		{
			System.out.println("Class A ip address ");
			System.out.println("default mask is:255.0.0.0 ");
		}
		else if(firstoctet >=128 && firstoctet <=191)
		{
			System.out.println("Class B ip address ");
			System.out.println("default mask is:255.255.0.0 ");
		}
		else if(firstoctet >=192 && firstoctet <=223)
		{
			System.out.println("Class C ip address ");
			System.out.println("default mask is:255.255.255.0 ");
		}
		else if(firstoctet >=224 && firstoctet <=239)
		{
			System.out.println("Class D ip address ");
			System.out.println("multicast address ");
		}
		
		String bip="";
		String split_bip[] = new String[4];
		
		for(int i=0; i<4; i++)
		{
			split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
			bip +=split_bip[i];
		}
		System.out.println("Binary ip is: "+bip);
		
		System.out.println("how many address do u want in each subnet: ");
		int n = sc.nextInt();
		
		int bits = (int)Math.ceil(Math.log(n)/Math.log(2));
		int totaddr = (int)Math.pow(2,bits);
		int mask  = 32-bits;
		System.out.println("number of host bits remained: "+bits);
		System.out.println("new subnet mask will be: "+mask);
		
		int fbip[] = new int[32];
		
		for(int i=0; i<32; i++)
		{
			fbip[i] =(int)bip.charAt(i) - 48;
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
		
		int ipaddr[] = new int[4];
		System.out.print("first ip address is: ");
		for(int i=0; i<4; i++)
		{
			System.out.print(ipaddr[i] = Integer.parseInt(fip[i],2));
			if(i!=3)
			{
				System.out.print(".");
			}
		}
		
		System.out.println();
		
		int lbip[] = new int[32];
		
		for(int i=0; i<32; i++)
		{
			lbip[i] =(int)bip.charAt(i) - 48;
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
		System.out.print("last ip address is: ");
		for(int i=0; i<4; i++)
		{
			System.out.print(iplast[i] = Integer.parseInt(lip[i],2));
			if(i!=3)
			{
				System.out.print(".");
			}
		}
		
		if(firstoctet <127)
		{
			System.out.println();
			System.out.println("how many subnets do u want to form: ");
			int scount = sc.nextInt();
			
			for(int j=1; j<scount; j++)
			{
				System.out.println();
				System.out.print("first address: ");
				for(int i=0; i<4; i++)
				{
					if(i<3)
					{
						System.out.print(ipaddr[i]+".");
					}
					else
					{
						System.out.print(ipaddr[i] = ipaddr[i]+totaddr);
					}
				}
				
				System.out.println();
				System.out.print("last address: ");
				for(int i=0; i<4; i++)
				{
					if(i<3)
					{
						System.out.print(iplast[i]+".");
					}
					else
					{
						System.out.print(iplast[i] = iplast[i] + totaddr);
					}
				}
			}
		
		}
	}
	
	public static String appendZeros(String s)
	{
		String temp = new String("00000000");
		return temp.substring(s.length())+s;
	}
}













