package ch02;


import java.io.BufferedReader;
import java.io .File;
import java.io .FileInputStream;
import java.io .InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadTxt {
	
	String path;  // �ļ�·��
	
	Map map = new HashMap();  //Ҫ��ȡ�ļ�����

	
	public ReadTxt(String path) {   //����ReadTxt����  
		
		this.path = path; 
		
	}

	
	public void getMap() throws Exception{   //����ȡ�����ݷ���Map��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(	//�½�BufferedReader����	
		new FileInputStream(new File(path)
				)));
		String str = null;    // �½�String ���󣬴�Ŷ�ȡ��ÿ������	
		int i = 0;   //i����Key��һ����
		while ((str = br.readLine()) != null) {   //ֻҪ��ȡ��ÿ�����ݲ�Ϊ�գ��������ȡ
			
			System.out.println(str);  //����ֱ�������ȡ��ÿ������
			
			map.put("ROW"+i,str );   //���Ѷ�ȡ��ÿ��������ΪValue�ŵ�Map��
			
			i++;
		}
		System.out.println(" ����ȡ���ݣ�����> "+map.size());
		
	}

}


