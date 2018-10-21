package ch02;


import java.io.BufferedReader;
import java.io .File;
import java.io .FileInputStream;
import java.io .InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadTxt {
	
	String path;  // 文件路径
	
	Map map = new HashMap();  //要读取的集合类

	
	public ReadTxt(String path) {   //构造ReadTxt对象  
		
		this.path = path; 
		
	}

	
	public void getMap() throws Exception{   //将读取的内容放入Map中
		
		BufferedReader br = new BufferedReader(new InputStreamReader(	//新建BufferedReader对象	
		new FileInputStream(new File(path)
				)));
		String str = null;    // 新建String 对象，存放读取的每行内容	
		int i = 0;   //i构成Key的一部分
		while ((str = br.readLine()) != null) {   //只要读取的每行内容不为空，则继续读取
			
			System.out.println(str);  //这里直接输出读取的每行内容
			
			map.put("ROW"+i,str );   //并把读取的每行内容作为Value放到Map中
			
			i++;
		}
		System.out.println(" 共读取数据－－－> "+map.size());
		
	}

}


