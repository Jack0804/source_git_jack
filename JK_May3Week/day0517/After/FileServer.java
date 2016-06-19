package After;
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
		
		ServerSocket serverSocket = new ServerSocket(5555); // 5555��Ʈ�� ���Թ��� ����.
		
		System.out.println("Ready>>>>>>>>>>>>>>>>>");
		
		int loopCount = 0;

		while(true)
		{
			Socket socket = serverSocket.accept();
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
			
			in.close();	// In�� ���������� ����ǹǷ� ���� �������ش�.
			out.close();
			socket.close();
			
			loopCount ++;
		}//endWhile
	}
}
