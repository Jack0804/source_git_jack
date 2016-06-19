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
			System.out.println("보내고 싶은 메세지는?");
			
			keyScanner = new Scanner(System.in); 		 // 키보드로 문자열 입력.
			String str = keyScanner.nextLine()+"\n"; 	 // 키보드에선 \n이 없이 입력되므로 \n을 수동추가.

			byte[] arr = str.getBytes(); 			 	 // STR->BYTE;
		
			socket = new Socket("127.0.0.1",  5555);	 // Socket
		
			out  = socket.getOutputStream(); 			 // 메세지를 얻어서 보낸다.
		
			out.write(arr);		// 바깥으로 out을 보낸다.
			
			// socket을 통해 입력된값을 inScanner에다 넣는다.
			// 서버로부터 에코값을 다시 받아와서 출력한다.
			inScanner = new Scanner(socket.getInputStream());	// getInputStream
			System.out.println(inScanner.nextLine());
		
			out.close();
			socket.close();
		}
  }
}
