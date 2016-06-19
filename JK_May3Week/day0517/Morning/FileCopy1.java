/* 
 * 파일IO수업 소스
 * 인터넷 URL을 입력으로하여 주어진 컨텐츠(사진,동영상)을 다운받아오는 방법.
 */


package Morning;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 
{
	//bad code
	public static void main(String[] args)	throws Exception 
	{
		System.out.println("아무거나 입력해보세요...");
		
	// 시빌워 동영상(주소).	
 	//	String path = "http://ent.cdn.videofarm.daum.net/vod/vea9fFsF7FFFFvgs3lyp79F/mp4_360P_1M_T1/movie.mp4?px-time=1463491733&px-hash=b4f5e319922658c91de6411a70282414&px-bps=1385488&px-bufahead=10";
		
		String path = "http://blogfiles.naver.net/20141023_265/highkrs_1414043110003HevC3_PNG/%C0%AF%C6%A9%BA%EA_%B9%E8%B3%CA.png";
		URL url = new URL(path);
		
		InputStream in   = url.openStream();
	
	 //	OutputStream out = new FileOutputStream("C:\\zzz\\civil.mp4");			// 시빌워 동영상
		OutputStream out = new FileOutputStream("C:\\zzz\\copy_original3.png");	// 이미지 파일
	
		while(true)
		{
			int data = in.read(); // 한바이트씩 읽는다.
			
			if( data == -1)		  // read에서 더이상 읽을게없으면 -1 이다.(이미지 파일을 사용할떄)
					break;
			
			out.write(data);	  // 		
		}
		//노란색 경고창은 입출력할때 클로즈를 안해서그렇다.
		in.close();
		out.close();
	}
}
