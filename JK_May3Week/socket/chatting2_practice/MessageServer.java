package chatting2_practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessageServer 
{
	//bad code
	public static void main(String[] args) throws Exception 
	{
		
		ServerSocket serverSocket = new ServerSocket(5555);
		
		while(true)
		{
			System.out.println("READY>>>>>>>>>>>>>");
			Socket socket = serverSocket.accept();			// 서버소켓이 들어올때까지 대기한다.

			InputStream in   = socket.getInputStream();		// Socket에 들어온 InputStream 입력값을 받아온다.
			OutputStream out = socket.getOutputStream();  	// Socket을 통하여 값을 보낸다.
		
			Scanner inScanner = new Scanner(in); 			// Client에서 입력된 값을 inScannner로 받는다
			
			// client에서 보낸메세지를 읽어들여야한다.
			String msg = inScanner.nextLine();
			System.out.println(msg);
			
			// nextLine에서 \n이 떨어져나가므로 수동으로 추가해준다.
			byte[] returnMsg = ("RE:"+msg+"\n").getBytes();
			out.write(returnMsg);
				
			out.close();
			inScanner.close();
			in.close();
			socket.close();
		}//endWhile
	}
}
