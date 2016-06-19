package Socket_Practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.jws.soap.InitParam;
import javax.print.attribute.standard.Severity;

public class Computer_Server
{
	//bad code
	public static void main(String[] args) throws Exception 
	{
		ServerSocket serverSocket = new ServerSocket(5555);
		byte[] returnMsg = null;
		
		System.out.println("서버입니다");
		
		while(true)
		{
		 // 서버소켓이 들어올때까지 대기한다.
			Socket socket =  serverSocket.accept();
	     // socket입력값을 받는 변수 in생성
			InputStream  in  = socket.getInputStream();
		 // Socket을 통하여 값을 보낸다.
			OutputStream out = socket.getOutputStream();
				
		 // 랜덤숫자를 생성한다
			int answer = (int)(Math.random()*6)+1;
			Scanner inScanner = new Scanner(in);
				
			String str = inScanner.nextLine();
			int iMessage = Integer.parseInt(str);
					
		 // 만약 숫자가 아닌 값을 입력하여 들어왔을 시,
			if((48 < iMessage || 57 > iMessage  ))
			{
				str = "숫자를 입력하세요.";
				returnMsg = ("RE:"+str+"\n").getBytes();
			}
			
			if( answer == iMessage)
			{
				str = "정답입니다.";
				returnMsg = ("RE:"+str+"\n").getBytes();
			}
			else // 오답일때,
			{
				str = "오답입니다.";
				returnMsg = ("RE:"+str+"\n").getBytes();
			}
			
			out.write(returnMsg);
								
			out.close();
			inScanner.close();
			in.close();
			socket.close();	
		}	
	}
}
