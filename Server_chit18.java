/* change name of file*/
/*import java.net.*;
import java.io.*;

public class Server1
 {
    public static void main(String args[])throws Exception
    {
        ServerSocket srv = new ServerSocket(4004);
        Socket s=srv.accept();
        DataInputStream in1 = new DataInputStream(s.getInputStream());      //take ip from client socket
        DataOutputStream out1 = new DataOutputStream(s.getOutputStream());       
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));   //reading from keyboard
        
        String str1="",str2="";
        
        while(!str1.equals("stop"))
        {
            str1 =in1.readUTF();
            System.out.println("Client Says :" + str1);
            str2=br.readLine();
            out1.writeUTF(str2);
            out1.flush();            
            
        }
        out1.close();
        srv.close();           //close connection
        s.close();
    }
}*/

import java.net.*;
import java.io.*;

public class Server_chit18.java
{
	public static void main(String args[])
	{
		ServerSocket srv = new ServerSocket(4004);
		Socket s =srv.accept();
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStream(System.in));
		
		String str1="", String str2="";
		while(!str1.equals("stop"))
		{
			str1 = in.readUTF();
			System.out.println("Client says: "+str1);
			str2 = br.readLine();
			out.writeUTF(str2);
			out.flush();
		}
		out.close();
		srv.close();
		s.close();
	}
}











