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
						String[] arr = str.split(" ");	// 공백제거
					 //<--

						String fileName = arr[1].substring(1); // 파일명은 배열에 1번에 해당한다.
						
						if(fileName.length() == 1)
						{
							System.out.println("여기가 실행되면 fileName.length() == 1)");
						}
						
						System.out.println("fileName의 값 : "+ fileName);
					
						String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
						System.out.println("확장자 : "+suffix);

						String str_bookNumber = fileName.substring(4,fileName.lastIndexOf("."));
						System.out.println("str_bookNumber :"+str_bookNumber);
											
					 //--> 선택한 폴더명 파일리스트 출력
					 //	temp();
						
						if( true)
						{
							i = 1;
							
							String[] fileNames = service.listInFolder("C:\\zzz\\aaa\\" + str_bookNumber);

							StringBuilder builder = new StringBuilder("<u1>");

							// fileNames가져온것을 모두 출력한다 (링크를 걸어서)
							for (String fn : fileNames) 
							{
								// --> 웹화면에 파일목록을 전체 출력.
								builder.append("<li><a href='" + fn + "' target = 'zero'>" + fn + "</a></li>");
								// System.out.println("fn 변수 값:" + fn);
								// <--
							}
							builder.append("</u1>");
							builder.append("<iframe name='zero' style='width:100%; height:100%;'></iframe>");

							// --> 브라우저로 보내는부분
							String strArr = builder.toString();
						 //	System.out.println("strArr 변수: " + strArr);
							byte[] data = strArr.getBytes();

							out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
							out.write(new String("Cache-Control: private\r\n").getBytes());
							out.write(new String("Content-Length: " + data.length + "\r\n").getBytes());
							// 웹에서 컨텐츠가 출력되는 방식.
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());

							out.write(data);
							// <--

							System.out.println("return 직전입니다.");
							return;
						}
						/*
						System.out.println("TEST 확인합시다");
						System.out.println("fileName 은 : "+fileName);
						*/
						
				  //-->Start	
					 // 파일의 길이를 알기위하여
					 //	File file = new File("C:\\zzz\\aaa\\1\\"+fileName);
						File file = new File("C:\\zzz\\aaa\\book"+str_bookNumber+"\\"+fileName);
					
					 // 파일을 Input	
						InputStream fin = new FileInputStream(file);	
						
						long fileSize = file.length();
				  //<--End	
						
						
						System.out.println("실행되는지 확인합니다2");
						
					 // 붙여넣기 (편지봉투)
						out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
						out.write(new String("Cache-Control: private\r\n").getBytes());
						out.write(new String("Content-Length: "+fileSize+"\r\n").getBytes());
						
					 // 192.168.0.30/"파일명".MP3 이면 아래실행
						if( suffix.equals("mp3"))
						{
							System.out.println("확장자가 MP3");
							out.write(new String("Content-Type: audio/mpeg\r\n\r\n").getBytes());
						}
					 // 192.168.0.30/"파일명".html 이면 아래실행
						else if( suffix.equals("html"))
						{
							System.out.println("확장자가 html");
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
						}
						else if( suffix.equals("jpg"))
						{
							System.out.println("확장자가 jpg");
							out.write(new String("Content-Type: image/jpeg\r\n\r\n").getBytes());
						}

						// Content타입 -> mine타입 -> 내가 처리할수있으면 처리 / 처리못하면 다운로드 처리.
						// \r\n은 토큰문자 예제소스의 \n과 같은 signal이다.
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
