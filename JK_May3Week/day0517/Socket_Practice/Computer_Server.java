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
		
		System.out.println("�����Դϴ�");
		
		while(true)
		{
		 // ���������� ���ö����� ����Ѵ�.
			Socket socket =  serverSocket.accept();
	     // socket�Է°��� �޴� ���� in����
			InputStream  in  = socket.getInputStream();
		 // Socket�� ���Ͽ� ���� ������.
			OutputStream out = socket.getOutputStream();
				
		 // �������ڸ� �����Ѵ�
			int answer = (int)(Math.random()*6)+1;
			Scanner inScanner = new Scanner(in);
				
			String str = inScanner.nextLine();
			int iMessage = Integer.parseInt(str);
					
		 // ���� ���ڰ� �ƴ� ���� �Է��Ͽ� ������ ��,
			if((48 < iMessage || 57 > iMessage  ))
			{
				str = "���ڸ� �Է��ϼ���.";
				returnMsg = ("RE:"+str+"\n").getBytes();
			}
			
			if( answer == iMessage)
			{
				str = "�����Դϴ�.";
				returnMsg = ("RE:"+str+"\n").getBytes();
			}
			else // �����϶�,
			{
				str = "�����Դϴ�.";
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
