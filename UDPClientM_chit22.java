import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class UDPClientM {

        public static void main(String args[])throws Exception{
                DatagramSocket datagramSocket = new DatagramSocket(3334);

                byte[] buffer;
                InetAddress receiverAddress =InetAddress.getByName("10.15.11.35");
                //InetAddress receiverAddress = InetAddress.getHostAddress("10.15.11.35");
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String str="",str2="";
                while(!str.equals("stop")){
                        str=br.readLine();
                        buffer = str.getBytes();
                        DatagramPacket packet = new DatagramPacket(
                                buffer, buffer.length, receiverAddress, 3333);
                        datagramSocket.send(packet);


                        byte[] buffer1 = new byte[10];
                        DatagramPacket packet1 = new DatagramPacket(buffer1, buffer1.length);

                        datagramSocket.receive(packet1);
                        buffer1 = packet1.getData();
                        String str1 = new String(buffer1, StandardCharsets.UTF_8);
                        System.out.println("Server says: "+str1);

                }

        }
}
