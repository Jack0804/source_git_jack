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
	
	// 키보드로 문자열 입력
	//	keyScanner = new Scanner(System.in);
		
		System.out.println("Client입니다.");
		
		int sckBoolean =0;
		while(true)
		{
			socket = new Socket("127.0.0.1",  5555);	 // Socket
			out  = socket.getOutputStream(); 			 // 메세지를 얻어서 보낸다.
			
			if( socket.isConnected() && sckBoolean == 0)
			{
				System.out.println("접속되었습니다. 생각하시는 숫자를 입력하세요.");
				sckBoolean = 1;
			}
			
			keyScanner = new Scanner(System.in); 		 // 키보드로 문자열 입력.
			
			String str = keyScanner.nextLine()+"\n"; 	 // 키보드에선 \n이 없이 입력되므로 \n을 수동추가.	
			byte[] arr = str.getBytes(); 			 	 // STR->BYTE;
		
			out.write(arr);		// 바깥으로 out을 보낸다.
	
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
