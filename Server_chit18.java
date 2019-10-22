/* change name of file*/
import java.net.*;
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
}










