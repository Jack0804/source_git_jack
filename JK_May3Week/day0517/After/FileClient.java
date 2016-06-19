package After;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient 
{
 // Bad Code
	public static void main(String[] args) throws Exception 
	{
		
		Socket socket = new Socket("192.168.0.2", 5555);
		System.out.println(socket);
		
		InputStream in = socket.getInputStream();
		OutputStream out = new FileOutputStream("c:\\zzz\\save3.jpg");
		
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
	}
}
