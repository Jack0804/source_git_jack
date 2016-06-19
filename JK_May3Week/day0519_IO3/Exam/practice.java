package Exam;

public class practice 
{	
	public static void main(String[] args) 
	{
		String str ="hello";
	 //	h-0 e-1 l-2
	 // substring은 3번쨰이후 스트링 즉 4번째 스트링부터 끝까지 남긴다.	
	 //	System.out.println(str.substring(3));
		
		
		String fileStr = "helo1.jpg";
//		String  = fileName.substring(4);
		
		System.out.println("fileStr 파일명 : "+fileStr);
		String temp = fileStr.substring(4,fileStr.lastIndexOf("."));
		System.out.println(temp);
	
		
	}
}
