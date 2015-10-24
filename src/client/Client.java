/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Fortesys
 */
public class Client {

   
    public static void main(String[] args) {
       String serverName = "localhost";  
      int port = 8080;
      try
      {
           System.out.println("Connecting to " + serverName + " on port " + port);
         Socket Client = new Socket(serverName, port);
         System.out.println("Just connected to " + Client.getRemoteSocketAddress());
         OutputStream outToServer = Client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         out.writeUTF("Hello from " + Client.getLocalSocketAddress());
         InputStream inFromServer = Client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         Client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
    }
    

