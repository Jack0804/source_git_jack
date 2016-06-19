package Morning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;

public class MP3Server_2 
{
	public static void main(String[] args)	throws  Exception
	{
		ServerSocket server = new ServerSocket(8080);

		while (true) 
		{
		 //filelist Ŭ������ ����
			FileListService_2 service = new FileListService_2();
			
		 // �������� �Է� �����.	
			Socket socket = server.accept();

		 //--> StartThread	
			new Thread()
			{
				public void run()
				{
					try
					{
					 // ���������� ������ ������ \n���ֱ⋚���� Scanner�� �߶� �д¹������ ��������.
						Scanner inScanner = new Scanner(socket.getInputStream());
						OutputStream out = socket.getOutputStream();	
					 //-->	
					 // GET /bbb.mp3 HTTP1.1  	
						String str = inScanner.nextLine();
						String[] arr = str.split(" ");	// ��������
					 //<--
						
					 // ũ�ҿ��� ���� �ּ��Է�â �ڿ�
					 // 127.0.0.1/aaa.mp3 �κп� '/'���� �ڸ���.
					 // Substring�� ���Ͽ� /�� �ڸ���.
						String fileNmae = arr[1].substring(1); // ���ϸ��� �迭�� 1���� �ش��Ѵ�.
						System.out.println(fileNmae);
					
					 // ���� ���̰� �߸����������� ����ó��.
						if(fileNmae.length() == 1)
						{
							fileNmae = "aaa.mp3";
						}
						
					 // ���ϸ��� "."�ڷκ��� ã�´�.
					 // ����Ȯ���ڸ� Ȯ���ϱ����Ͽ�	���
						String suffix = fileNmae.substring(fileNmae.lastIndexOf(".")+1);
						System.out.println(suffix);
						
						if( fileNmae.equals("list.html"))
						{
							//���ϸ���Ʈ�� ��������
							String[] fileNames = service.listInFolder("C:\\zzz");
							//���ϸ���Ʈ�� String���� ��ȯ.
					    	//String      strArr = Arrays.toString(fileNames);
							
						 // Stringbuilder�� StringBuffer�� ���̻�� String�� �����ս��� �������Ƿ�.
							StringBuilder builder = new StringBuilder("<ul>");
							
							for(String fn : fileNames)
							{
								builder.append("<li><a href='"+fn+"' target = 'zero'>" + fn +"</a></li>");
							}
	
							builder.append("</ul>");
							builder.append("<iframe name='zero' style='width:100%; height:100%;'></iframe>");
							
							String strArr = builder.toString();
							
							byte[] data = strArr.getBytes();

						//--> �������� �����ºκ�	
							out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
							out.write(new String("Cache-Control: private\r\n").getBytes());
							out.write(new String("Content-Length: "+data.length+"\r\n").getBytes());
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
							
							out.write(data);
						//<--	
							return;
						}
	
				  //-->Start	
					 // ������ ���̸� �˱����Ͽ�
						File file = new File("C:\\zzz\\"+fileNmae);
					
					 // ������ Input	
						InputStream fin = new FileInputStream(file);	
						
						long fileSize = file.length();
				  //<--End	

					 // �ٿ��ֱ� (��������)
						out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
						out.write(new String("Cache-Control: private\r\n").getBytes());
						out.write(new String("Content-Length: "+fileSize+"\r\n").getBytes());
						
					 // 192.168.0.30/"���ϸ�".MP3 �̸� �Ʒ�����
						if( suffix.equals("mp3"))
						{
							out.write(new String("Content-Type: audio/mpeg\r\n\r\n").getBytes());
						}
					 // 192.168.0.30/"���ϸ�".html �̸� �Ʒ�����
						else if( suffix.equals("html"))
						{
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
						}
						else if( suffix.equals("jpg"))
						{
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
}
