package ch02;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author ���Ƕ�
 *
 * @version����ʱ�䣺2018��10��21������7:14:18
 */
public class WriteTxt {
		
		String path;    //���·��
		 Map<String,Employee>list=new HashMap();    //ְ���б����ڴ��Ա���������ɶ����� 
		public WriteTxt(String path , Map list) {   //����WriteTxt����  
			
			this.path = path;
			this.list = list;
			
		}
		
	
		public  void newTxt()throws Exception{  //�½�.txt�ļ�
			
			File file = new File(path);  //ʵ����һ��File����
			if(file.exists()) {         //������ļ�����	
				file.mkdirs();   //file.mkdir()����ָ��·����Ŀ¼�������·�������ڣ��ᴴ��ʧ�ܱ���
				                 //file.mkdirs()�Զ����������ڵĸ�·��
			}
			
		}
		
		public boolean WriteSalary() {   //����Ա�����پ�����ɶ���˳�򽫹��ʼ�¼д��.txt�ļ�
			try {
				newTxt();                                     //���½���һ��.txt�ļ�
				FileWriter fw=new FileWriter(path);           //����FileWriter���󣬲�ʵ����fw
				for(Map.Entry<String, Employee> entry:list.entrySet()) {    //ֱ�ӱ�������ְ���б�,��д����Ա���Ĺ��ʼ�¼
					
					if(entry.getValue() instanceof Staff) {   //�ж�value�Ƿ���Staff����
						Staff person=(Staff)entry.getValue();   //ǿ������ת����Staff,�ſɵ����������еĺ���
					
						fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");//���ļ�д��ְλ������
						
						 Map<String,Double>bill=person.getSalaryBill();  //��ȡ���ʼ�¼
						
						 for(Map.Entry<String,Double>object:bill.entrySet()) {  //�������ʼ�¼��д���ļ���
						
							 fw.write(" "+object.getKey()+" ����:"+object.getValue()+"  ");  //д�����º͹��ʽ��
								
						 }
						 
						 fw.write("\n");
					}else {      //����ǰ����Staff���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Staff
						
						continue;
					}
				}
				
				for(Map.Entry<String, Employee> entry:list.entrySet()) {  //ֱ�ӱ�������ְ���б�,д���о���Ĺ��ʼ�¼
					
					if(entry.getValue() instanceof Manager) {    //�ж�value�Ƿ���Manager����
						
		
						Manager person=(Manager)entry.getValue();   //ǿ������ת����Manager,�ſɵ����������еĺ���
						fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");  //д��ְλ������
						 Map<String,Double>bill=person.getSalaryBill();   //��ȡ���ʼ�¼
						 
						 for(Map.Entry<String,Double>object:bill.entrySet()) {   //�������ʼ�¼��д���ļ���
							 fw.write(" "+object.getKey()+" ����:"+object.getValue()+"  ");//д�����¡�����͹��ʽ��
								
						 }
						 
						 fw.write("\n");
					}else {    //����ǰ����Manager���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Manager
						
						continue;
					
					}
				}
				
				for(Map.Entry<String, Employee> entry:list.entrySet()) {   //ֱ�ӱ�������ְ���б�,д���йɶ��ķֺ��¼
					if(entry.getValue() instanceof Shareowner) {          //�ж�value�Ƿ���Shareholder����
						
						Shareowner person=(Shareowner)entry.getValue();   //ǿ������ת����Shareholder,�ſɵ����������еĺ���
						
						
						fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");  //д��ְλ������
						
						 Map<String,Double>bill=person.getSalaryBill();    //��ȡ���ʼ�¼
						 
						 for(Map.Entry<String,Double>object:bill.entrySet()) {   //�������ʼ�¼��д���ļ���
							 
							 fw.write(" "+object.getKey()+" �ֺ�:"+object.getValue()+"  ");   //д�����ºͷֺ�
								
						 }
						 
						 fw.write("\n");
					}
				}

				fw.close();
				
			} catch (Exception e) {
				
				/*��ӡ�쳣*/
				e.printStackTrace();
				return false;

			}
			return true;
		}

		
		
		
		public boolean WriteMsg() {   //��ְ����Ϣд��.txt�ļ�
			try {
				newTxt();           //���½���һ��txt�ļ�
				FileWriter fw=new FileWriter(path);  //����FileWriter���󣬲�ʵ����fw
				for(Map.Entry<String, Employee> entry:list.entrySet()) {   //ֱ�ӱ�������ְ���б�,д������ְ������Ϣ
					
					String name=entry.getValue().toString();  //��ȡְ��������
				
					int id=entry.getValue().getID();   //��ȡְ����
					
					int month=entry.getValue().getbirthMonth();  //��ȡ�����·�
					
					if(entry.getValue() instanceof Shareowner) {  //�жϵ�ǰ�����Ƿ��ǹɶ�����
						
						Shareowner person=(Shareowner)entry.getValue();  //ǿ������װ��������Shareholder���еķ���
						
						double share=person.getShare();  //��ȡ�ɶ��Ĺɷ�
						
						fw.write("��"+entry.getKey()+"�� "+name+" ְ����:"+id+" �����·�:"+month+"�ɷ�:"+share+"\n");  //���ǹɶ����ͣ���д��������ְ���š������·ݺ͹ɷ�
					}else {    //�����ǹɶ����ͣ���д��������ְ���š������·�
						
						fw.write("��"+entry.getKey()+"�� "+name+" ְ����:"+id+" �����·�:"+month+"\n");//д���ļ�����;
					}
				}

				fw.close();
				
			} catch (Exception e) {
				
				
				e.printStackTrace();
				return false;

			}
			
			return true;
			
		}
		
	}

