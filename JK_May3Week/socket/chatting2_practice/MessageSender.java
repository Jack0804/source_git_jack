package chatting2_practice;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender 
{
	public static void main(String[] args)	throws Exception 
	{
		
		OutputStream out;		
		Socket  socket;
		Scanner	inScanner, keyScanner;
		
		while(true)
		{
			System.out.println("������ ���� �޼�����?");
			
			keyScanner = new Scanner(System.in); 		 // Ű����� ���ڿ� �Է�.
			String str = keyScanner.nextLine()+"\n"; 	 // Ű���忡�� \n�� ���� �ԷµǹǷ� \n�� �����߰�.

			byte[] arr = str.getBytes(); 			 	 // STR->BYTE;
		
			socket = new Socket("127.0.0.1",  5555);	 // Socket
		
			out  = socket.getOutputStream(); 			 // �޼����� �� ������.
		
			out.write(arr);		// �ٱ����� out�� ������.
			
			// socket�� ���� �ԷµȰ��� inScanner���� �ִ´�.
			// �����κ��� ���ڰ��� �ٽ� �޾ƿͼ� ����Ѵ�.
			inScanner = new Scanner(socket.getInputStream());	// getInputStream
			System.out.println(inScanner.nextLine());
		
			out.close();
			socket.close();
		}
  }
}
