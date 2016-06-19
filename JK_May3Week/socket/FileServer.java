import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer
{
  // bad code
	public static void main(String[] args)	throws Exception 
	{
		
		int answer = (int)(Math.random()*6);
		
		ServerSocket serverSocket = new ServerSocket(5555); // 5555포트로 가게문을 연다.
		
		System.out.println("Ready>>>>>>>>>>>>>>>>>");
		
		int loopCount = 0;
	 // blocking (손님이 들어올때까지 멈춤)

		while(true)
		{
			Socket socket = serverSocket.accept();
			// in빨대 -> 사진 out빨대 -> 보내는쪽
			// IP->192.168.0.30
			System.out.println(socket);
	
			String filename="c:\\zzz\\copy_civilwar.jpg";
			
			if(loopCount == answer)
			{
				filename = "c:\\zzz\\coffee.jpg";
			}
			
			InputStream  in  = new FileInputStream(filename);
			OutputStream out = socket.getOutputStream();
		
			byte[] buffer = new byte[1024*8];

			
			while(true)
			{
				int count = in.read(buffer);
				
				if(count == -1)
				{
					break;
				}
				out.write(buffer,0,count);
				
			}//endWhile
			
			in.close();	// In이 마지막으로 실행되므로 먼저 종료해준다.
			out.close();
			socket.close();
			
			loopCount ++;
		}//endWhile
	}
}
