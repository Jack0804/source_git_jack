package Socket_Practice;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Human_Client
{
	public static void main(String[] args)	throws Exception 
	{
		OutputStream out;		
		Socket  	 socket;
		Scanner		 inScanner, keyScanner;
	
	// Ű����� ���ڿ� �Է�
	//	keyScanner = new Scanner(System.in);
		
		System.out.println("Client�Դϴ�.");
		
		int sckBoolean =0;
		while(true)
		{
			socket = new Socket("127.0.0.1",  5555);	 // Socket
			out  = socket.getOutputStream(); 			 // �޼����� �� ������.
			
			if( socket.isConnected() && sckBoolean == 0)
			{
				System.out.println("���ӵǾ����ϴ�. �����Ͻô� ���ڸ� �Է��ϼ���.");
				sckBoolean = 1;
			}
			
			keyScanner = new Scanner(System.in); 		 // Ű����� ���ڿ� �Է�.
			
			String str = keyScanner.nextLine()+"\n"; 	 // Ű���忡�� \n�� ���� �ԷµǹǷ� \n�� �����߰�.	
			byte[] arr = str.getBytes(); 			 	 // STR->BYTE;
		
			out.write(arr);		// �ٱ����� out�� ������.
	
			inScanner = new Scanner(socket.getInputStream());	// getInputStream
			
			String	revStr = inScanner.nextLine();
		//	revStr = revStr.substring(3);
		//	System.out.println(revStr);
			
		//	System.out.println(inScanner.nextLine());
			System.out.println(revStr);
		
			out.close();
			socket.close();
		}
  }
}
