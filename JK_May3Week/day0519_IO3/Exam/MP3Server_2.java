package Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;

public class MP3Server_2 
{
	static int  i;
	
	public static void main(String[] args)	throws  Exception
	{
		ServerSocket server = new ServerSocket(8080);
		
		 i = 0;
		
		while (true) 
		{

			FileListService_2 service = new FileListService_2();
			Socket socket = server.accept();

			new Thread()
			{
				public void run()
				{
					try
					{				
						Scanner inScanner = new Scanner(socket.getInputStream());
						OutputStream out = socket.getOutputStream();	
					 
					 //-->	  	
						String str = inScanner.nextLine();
						String[] arr = str.split(" ");	// ��������
					 //<--

						String fileName = arr[1].substring(1); // ���ϸ��� �迭�� 1���� �ش��Ѵ�.
						
						if(fileName.length() == 1)
						{
							System.out.println("���Ⱑ ����Ǹ� fileName.length() == 1)");
						}
						
						System.out.println("fileName�� �� : "+ fileName);
					
						String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
						System.out.println("Ȯ���� : "+suffix);

						String str_bookNumber = fileName.substring(4,fileName.lastIndexOf("."));
						System.out.println("str_bookNumber :"+str_bookNumber);
											
					 //--> ������ ������ ���ϸ���Ʈ ���
					 //	temp();
						
						if( true)
						{
							i = 1;
							
							String[] fileNames = service.listInFolder("C:\\zzz\\aaa\\" + str_bookNumber);

							StringBuilder builder = new StringBuilder("<u1>");

							// fileNames�����°��� ��� ����Ѵ� (��ũ�� �ɾ)
							for (String fn : fileNames) 
							{
								// --> ��ȭ�鿡 ���ϸ���� ��ü ���.
								builder.append("<li><a href='" + fn + "' target = 'zero'>" + fn + "</a></li>");
								// System.out.println("fn ���� ��:" + fn);
								// <--
							}
							builder.append("</u1>");
							builder.append("<iframe name='zero' style='width:100%; height:100%;'></iframe>");

							// --> �������� �����ºκ�
							String strArr = builder.toString();
						 //	System.out.println("strArr ����: " + strArr);
							byte[] data = strArr.getBytes();

							out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
							out.write(new String("Cache-Control: private\r\n").getBytes());
							out.write(new String("Content-Length: " + data.length + "\r\n").getBytes());
							// ������ �������� ��µǴ� ���.
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());

							out.write(data);
							// <--

							System.out.println("return �����Դϴ�.");
							return;
						}
						/*
						System.out.println("TEST Ȯ���սô�");
						System.out.println("fileName �� : "+fileName);
						*/
						
				  //-->Start	
					 // ������ ���̸� �˱����Ͽ�
					 //	File file = new File("C:\\zzz\\aaa\\1\\"+fileName);
						File file = new File("C:\\zzz\\aaa\\book"+str_bookNumber+"\\"+fileName);
					
					 // ������ Input	
						InputStream fin = new FileInputStream(file);	
						
						long fileSize = file.length();
				  //<--End	
						
						
						System.out.println("����Ǵ��� Ȯ���մϴ�2");
						
					 // �ٿ��ֱ� (��������)
						out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
						out.write(new String("Cache-Control: private\r\n").getBytes());
						out.write(new String("Content-Length: "+fileSize+"\r\n").getBytes());
						
					 // 192.168.0.30/"���ϸ�".MP3 �̸� �Ʒ�����
						if( suffix.equals("mp3"))
						{
							System.out.println("Ȯ���ڰ� MP3");
							out.write(new String("Content-Type: audio/mpeg\r\n\r\n").getBytes());
						}
					 // 192.168.0.30/"���ϸ�".html �̸� �Ʒ�����
						else if( suffix.equals("html"))
						{
							System.out.println("Ȯ���ڰ� html");
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
						}
						else if( suffix.equals("jpg"))
						{
							System.out.println("Ȯ���ڰ� jpg");
							out.write(new String("Content-Type: image/jpeg\r\n\r\n").getBytes());
						}

						// ContentŸ�� -> mineŸ�� -> ���� ó���Ҽ������� ó�� / ó�����ϸ� �ٿ�ε� ó��.
						// \r\n�� ��ū���� �����ҽ��� \n�� ���� signal�̴�.
						byte[] buffer = new byte[1024 * 8];
						
						while(true)
						{
							try
							{
								int count = fin.read(buffer);
								if (count == -1) 
								{
									break;
								}
								out.write(buffer, 0, count);
							}
							catch(Exception e)
							{
							
							}
						}//<-endWhile
						
						out.flush();
						out.close();
						socket.close();
					}
				//}//endElse
					catch(Exception e)
					{
						
					}
				}
					
			}.start();
			//<--EndThread
		}//<-endWhile
	}//<--endMain
	
	static void temp()
	{
		
	}
}
