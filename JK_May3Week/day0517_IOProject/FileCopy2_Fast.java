import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;



public class FileCopy2_Fast
{	
	// bad code
	public static void main(String[] args) throws Exception 
	{
		InputStream  in  = new FileInputStream ( "c:\\zzz\\copy2.jpg");
		OutputStream out = new FileOutputStream( "c:\\zzz\\copy_civilwar.jpg");
		
		long start = System.currentTimeMillis();
		
		byte[] buffer = new byte[1024*8];	// 8Kbyte씩 읽어서 8Kbyte씩 쓰기위하여.		
		
		while(true)
		{
			int count = in.read(buffer);
			
			if(count == -1)
			{
				break;
			}
			
			out.write(buffer, 0, count);
		}// end while
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}
