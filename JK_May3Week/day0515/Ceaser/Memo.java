package Ceaser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Encryption {
	
	Map<Character, Character> ceaserMap;
		
		public Encryption() 
		{
			ceaserMap = new HashMap<>();		
			
			for(int i = 97; i < 123; i++)
			{
				if( i == 120)
				{
					ceaserMap.put((char)i, (char)(97));
					continue;
				}
				
				if( i == 121)
				{
					ceaserMap.put((char)i, (char)(98));
					continue;
				}
				
				if( i == 122)
				{
					ceaserMap.put((char)i, (char)(99));
					continue;
				}
				
				ceaserMap.put((char)i, (char)(i+3));
			}
		}	
}


class Memo
{
	void play() throws FileNotFoundException
	{
		InputStream in = new FileInputStream("c:\\zzz\\article.txt");
		Scanner scanner = new Scanner(in);	//���� ���� �غ� �Ϸ�(1)
	
		String str = scanner.nextLine();
		str 	   = str.toLowerCase();	

		char[] charArray = str.toCharArray();
		
		Encryption cn = new Encryption();
		
		for( int i =0; i < charArray.length; i++)
		{
			if(cn.ceaserMap.get(charArray[i]) == null)
			{
				System.out.print(charArray[i]);
				continue;
			}
			
			System.out.print(cn.ceaserMap.get(charArray[i]));
		}	
	}
}