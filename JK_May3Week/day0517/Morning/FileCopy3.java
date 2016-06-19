package Morning;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy3
{	
	// bad code
	public static void main(String[] args) throws Exception 
	{

		InputStream  in  = new FileInputStream ( "c:\\zzz\\test.txt");		// test.txt -> abcdefghijklm
		OutputStream out = new FileOutputStream( "c:\\zzz\\copy_tex.txt");  
		
		long start = System.currentTimeMillis();
		
		byte[] buffer = new byte[5];	// 8Kbyte씩 읽어서 8Kbyte씩 쓰기위하여.		
		
		while(true)
		{
			int count = in.read(buffer);
			
			System.out.println(count);
			
			if(count == -1)
			{
				break;
			}
			
		 //	out.write(buffer);			
		  out.write(buffer,0,count);	// 0은 시작범위, count는 끝범위.
			
		}// end while
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}


