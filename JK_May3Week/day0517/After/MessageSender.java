package After;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender 
{
	public static void main(String[] args)	throws Exception 
	{
	 // String str = "형님 같이 화이팅입니다.\n";
		System.out.println("보내고 싶은 메세지는?");
		Scanner keyScanner = new Scanner(System.in); // 키보드로 문자열 입력.
	
		String str = keyScanner.nextLine()+"\n"; // 키보드에선 \n이 없이 입력되므로 \n을 수동추가.
		byte[] arr = str.getBytes(); 			 // STR->BYTE;
		
	 // Socket socket = new Socket("192.168.0.145", 5555);
		Socket socket = new Socket("192.168.0.83",  5555);	// Socket 
		
		OutputStream out  = socket.getOutputStream(); 		// 메세지를 얻어서 보낸다.
		
		Scanner inScanner = new Scanner(socket.getInputStream());	// getInputStream
		out.write(arr);		// out 을 출력한다.
		
		System.out.println(inScanner.nextLine());
		
		out.close();
		socket.close();
	}
}
