package chatting2;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender 
{
	public static void main(String[] args)	throws Exception 
	{
	 // String str = "���� ���� ȭ�����Դϴ�.\n";
		System.out.println("������ ���� �޼�����?");
		Scanner keyScanner = new Scanner(System.in); // Ű����� ���ڿ� �Է�.
	
		String str = keyScanner.nextLine()+"\n"; // Ű���忡�� \n�� ���� �ԷµǹǷ� \n�� �����߰�.
		byte[] arr = str.getBytes(); 			 // STR->BYTE;
		
	 // Socket socket = new Socket("192.168.0.145", 5555);
		Socket socket = new Socket("192.168.0.83",  5555);	// Socket 
		
		OutputStream out  = socket.getOutputStream(); 		// �޼����� �� ������.
		
		Scanner inScanner = new Scanner(socket.getInputStream());	// getInputStream
		out.write(arr);		// out �� ����Ѵ�.
		
		System.out.println(inScanner.nextLine());
		
		out.close();
		socket.close();
	}
}
