package Ceaser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Ceaser 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Memo memo = new Memo();
		memo.play(); // ��ȣȭ
		
		Decoding_Play decoding = new Decoding_Play();
		decoding.play(); // ��ȣȭ
	}	
}
