package Exam;

public class practice 
{	
	public static void main(String[] args) 
	{
		String str ="hello";
	 //	h-0 e-1 l-2
	 // substring�� 3�������� ��Ʈ�� �� 4��° ��Ʈ������ ������ �����.	
	 //	System.out.println(str.substring(3));
		
		
		String fileStr = "helo1.jpg";
//		String  = fileName.substring(4);
		
		System.out.println("fileStr ���ϸ� : "+fileStr);
		String temp = fileStr.substring(4,fileStr.lastIndexOf("."));
		System.out.println(temp);
	
		
	}
}
