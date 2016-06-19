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
		 //filelist 클래스와 결합
			FileListService_2 service = new FileListService_2();
			
		 // 서버소켓 입력 대기중.	
			Socket socket = server.accept();

		 //--> StartThread	
			new Thread()
			{
				public void run()
				{
					try
					{
					 // 브라우저에서 보내는 정보도 \n이있기떄문에 Scanner로 잘라서 읽는방식으로 구현하자.
						Scanner inScanner = new Scanner(socket.getInputStream());
						OutputStream out = socket.getOutputStream();	
					 //-->	
					 // GET /bbb.mp3 HTTP1.1  	
						String str = inScanner.nextLine();
						String[] arr = str.split(" ");	// 공백제거
					 //<--
						
					 // 크롬에서 받은 주소입력창 뒤에
					 // 127.0.0.1/aaa.mp3 부분에 '/'부터 자른다.
					 // Substring을 통하여 /를 자른다.
						String fileNmae = arr[1].substring(1); // 파일명은 배열에 1번에 해당한다.
						System.out.println(fileNmae);
					
					 // 만약 길이가 잘못들어왔을떄의 예외처리.
						if(fileNmae.length() == 1)
						{
							fileNmae = "aaa.mp3";
						}
						
					 // 파일명의 "."뒤로부터 찾는다.
					 // 파일확장자를 확인하기위하여	사용
						String suffix = fileNmae.substring(fileNmae.lastIndexOf(".")+1);
						System.out.println(suffix);
						
						if( fileNmae.equals("list.html"))
						{
							//파일리스트를 가져오기
							String[] fileNames = service.listInFolder("C:\\zzz");
							//파일리스트를 String으로 변환.
					    	//String      strArr = Arrays.toString(fileNames);
							
						 // Stringbuilder와 StringBuffer를 많이사용 String이 퍼포먼스가 안좋으므로.
							StringBuilder builder = new StringBuilder("<ul>");
							
							for(String fn : fileNames)
							{
								builder.append("<li><a href='"+fn+"' target = 'zero'>" + fn +"</a></li>");
							}
	
							builder.append("</ul>");
							builder.append("<iframe name='zero' style='width:100%; height:100%;'></iframe>");
							
							String strArr = builder.toString();
							
							byte[] data = strArr.getBytes();

						//--> 브라우저로 보내는부분	
							out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
							out.write(new String("Cache-Control: private\r\n").getBytes());
							out.write(new String("Content-Length: "+data.length+"\r\n").getBytes());
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
							
							out.write(data);
						//<--	
							return;
						}
	
				  //-->Start	
					 // 파일의 길이를 알기위하여
						File file = new File("C:\\zzz\\"+fileNmae);
					
					 // 파일을 Input	
						InputStream fin = new FileInputStream(file);	
						
						long fileSize = file.length();
				  //<--End	

					 // 붙여넣기 (편지봉투)
						out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
						out.write(new String("Cache-Control: private\r\n").getBytes());
						out.write(new String("Content-Length: "+fileSize+"\r\n").getBytes());
						
					 // 192.168.0.30/"파일명".MP3 이면 아래실행
						if( suffix.equals("mp3"))
						{
							out.write(new String("Content-Type: audio/mpeg\r\n\r\n").getBytes());
						}
					 // 192.168.0.30/"파일명".html 이면 아래실행
						else if( suffix.equals("html"))
						{
							out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
						}
						else if( suffix.equals("jpg"))
						{
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
}
