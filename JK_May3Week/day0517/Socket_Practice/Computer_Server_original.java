package Socket_Practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Computer_Server_original
{
	//bad code
	public static void main(String[] args) throws Exception 
	{
		ServerSocket serverSocket = new ServerSocket(5555);
		
		while(true)
		{
			System.out.println("READY>>>>>>>>>>>>>");
	    
		 // ���������� ���ö����� ����Ѵ�.
			Socket socket = serverSocket.accept();			// ���������� ���ö����� ����Ѵ�.

			InputStream in   = socket.getInputStream();		// Socket�� ���� InputStream �Է°��� �޾ƿ´�.
			OutputStream out = socket.getOutputStream();  	// Socket�� ���Ͽ� ���� ������.
		
			Scanner inScanner = new Scanner(in); 			// Client���� �Էµ� ���� inScannner�� �޴´�
			
			// client���� �����޼����� �о�鿩���Ѵ�.
			String msg = inScanner.nextLine();
			System.out.println(msg);
			
			// nextLine���� \n�� �����������Ƿ� �������� �߰����ش�.
			byte[] returnMsg = ("RE:"+msg+"\n").getBytes();
			out.write(returnMsg);
				
			out.close();
			inScanner.close();
			in.close();
			socket.close();
			
		}//endWhile
	}
}
