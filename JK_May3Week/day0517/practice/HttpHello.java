package practice;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpHello 
{
	public static void main(String[] args) throws Exception 
	{
		ServerSocket server = new ServerSocket(8080);
		
		while(true)
		{
			Socket socket = server.accept();
			
			OutputStream out = socket.getOutputStream();
			
			String msg = "<h1>Hello</h1>";
			
			out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); 
			out.write(new String("Cache-Control: private\r\n").getBytes()); 
			out.write(new String("Content-Length: "+msg.getBytes().length+"\r\n").getBytes()); 
			out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
			
			out.write(msg.getBytes());
			out.flush();
			out.close();
			socket.close();
		}
	}
}
