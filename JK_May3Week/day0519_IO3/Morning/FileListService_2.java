package Morning;

import java.io.File;

public class FileListService_2 {

 // ��ȯ������ ���ڿ��� �迭�� return.
	public String[] listInFolder(String folder) throws Exception // ������ �߸��Ǿ�����츦 ���� ����ó��
	{
		// folder ���� ���ϸ���Ʈ
		File dir = new File(folder);

		return dir.list(); // ���ϸ���Ʈ�� �����Ѵ�.
	}
}
