import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;



public class FileCopy_Civilwar 
{
	//bad code
	public static void main(String[] args)	throws Exception 
	{
		System.out.println("아무거나 입력해보세요...");
		
	 // 시빌워 주소.	
 	 	String path = "http://ent.cdn.videofarm.daum.net/vod/vea9fFsF7FFFFvgs3lyp79F/mp4_360P_1M_T1/movie.mp4?px-time=1463491733&px-hash=b4f5e319922658c91de6411a70282414&px-bps=1385488&px-bufahead=10";
	//	String path = "http://blogfiles.naver.net/20141023_265/highkrs_1414043110003HevC3_PNG/%C0%AF%C6%A9%BA%EA_%B9%E8%B3%CA.png";
		URL url = new URL(path);
		
		InputStream in = url.openStream();
	 //	OutputStream out = new FileOutputStream("C:\\zzz\\copy_original3.png");	// 결과 빨대
		
	 //	InputStream	 in  = new FileInputStream ("C:\\zzz\\aaa.jpg");	// 읽는 빨대
	 	OutputStream out = new FileOutputStream("C:\\zzz\\civil.mp4");	// 결과 빨대		
	 //	InputStream in   = System.in;
	
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

