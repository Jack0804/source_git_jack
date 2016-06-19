package Exam;

import java.io.File;

public class FileListService_2 {

 // 반환형으로 문자열의 배열을 return.
	public String[] listInFolder(String folder) throws Exception // 파일이 잘못되었을경우를 위한 예외처리
	{
		// folder 에는 파일리스트
		File dir = new File(folder);

		return dir.list(); // 파일리스트를 전달한다.
	}
}
