import java.net.*;
import java.io.*;
public class Client1
{
  public static void main(String args[]) throws Exception
  {
    Socket s=new Socket("localhost",4004);
    DataInputStream in1 = new DataInputStream(s.getInputStream());          //input from terminal
    DataOutputStream out1 = new DataOutputStream(s.getOutputStream());      //sends output to socket  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    String str1=" ", str2=" ";
    
    while(!str1.equals("stop"))
    {
     
      str1 = br.readLine();
      out1.writeUTF(str1);
      out1.flush();
      str2=in1.readUTF();
      System.out.println("Server Says :" + str2);
            
    }
      out1.close();
      s.close();
      
   }
} 
