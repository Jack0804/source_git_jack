/* 
 * ����IO���� �ҽ�
 * ���ͳ� URL�� �Է������Ͽ� �־��� ������(����,������)�� �ٿ�޾ƿ��� ���.
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
		System.out.println("�ƹ��ų� �Է��غ�����...");
		
	// �ú��� ������(�ּ�).	
 	//	String path = "http://ent.cdn.videofarm.daum.net/vod/vea9fFsF7FFFFvgs3lyp79F/mp4_360P_1M_T1/movie.mp4?px-time=1463491733&px-hash=b4f5e319922658c91de6411a70282414&px-bps=1385488&px-bufahead=10";
		
		String path = "http://blogfiles.naver.net/20141023_265/highkrs_1414043110003HevC3_PNG/%C0%AF%C6%A9%BA%EA_%B9%E8%B3%CA.png";
		URL url = new URL(path);
		
		InputStream in   = url.openStream();
	
	 //	OutputStream out = new FileOutputStream("C:\\zzz\\civil.mp4");			// �ú��� ������
		OutputStream out = new FileOutputStream("C:\\zzz\\copy_original3.png");	// �̹��� ����
	
		while(true)
		{
			int data = in.read(); // �ѹ���Ʈ�� �д´�.
			
			if( data == -1)		  // read���� ���̻� �����Ծ����� -1 �̴�.(�̹��� ������ ����ҋ�)
					break;
			
			out.write(data);	  // 		
		}
		//����� ���â�� ������Ҷ� Ŭ��� ���ؼ��׷���.
		in.close();
		out.close();
	}
}
