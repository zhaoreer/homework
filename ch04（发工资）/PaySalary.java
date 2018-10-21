package ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author ���Ƕ�
 * @Title Staff.java
 * @Description:����֧������
 * @version����ʱ�䣺2018��10��21������4:31:48
 */
/***
 *      ʵ��֧�����ʺͲ�ѯ���ʼ�¼�Ĺ���
 * 			����:	    1.���о����Ա���Ĺ��ʽ���֮�� account 
 * 					2.ְ���б� list���������Ա��������Ա���������ɶ�����
 * 					
 * 
 * 			����:	    1.������pay()
 * 					2.��ѯĳԱ���Ĺ��ʼ�¼findRecord()
 */
public class PaySalary{     // ���ɶ�������й���֧��
	static double account=0;
	static Map<String,Employee>list=new HashMap();// ְ���б� �������Ա��������Ա���������ɶ�����
	public void pay(double income) {   //ȫ��ӯ��
		Scanner input=new Scanner(System.in);
		System.out.println("��Ҫ���Ź��ʵ��·�");
		int year=input.nextInt();     //��ȡ����
		int month=input.nextInt();
		
		for(Map.Entry<String,Employee>entry:list.entrySet()){   //ֱ�ӱ�������ְ���б��ȸ�����Ա��������
			if(entry.getValue() instanceof Staff) {            //�ж�value�Ƿ���Staff����
				Staff person=(Staff)entry.getValue();          //ǿ������ת����Staff,�ſ��Ե����������к���
				String name=entry.getValue().toString();       //��ȡԱ������
				System.out.println("��"+entry.getKey()+"��"+name+"����:");  //���ְλ����������ʾ�û�������
				double salary=input.nextDouble();             //��ȡ���ŵĹ��ʽ��
				person.setSalary(year, month, salary);        //���ù�����Ϣ�����ʼ�¼��
				account+=salary;
			}else {                                           //����ǰ����Staff���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Staff
				continue;	
			}			
		}
		
		for(Map.Entry<String,Employee>entry:list.entrySet()) {    //ֱ�ӱ�������ְ���б�,�����о�������
			if(entry.getValue() instanceof Manager) {         // �ж�value�Ƿ���Manager����
				Manager person=(Manager)entry.getValue();      //ǿ������ת����Manager,�ſ��Ե����������еĺ���
			String name=entry.getValue().toString();        //��ȡ��������
			System.out.println("��"+entry.getKey()+"��"+name+"����+����:");
			
			double salary=input.nextDouble();              //��ȡ���ʽ��ͽ���
			double bonus=input.nextDouble();
			
			person.setSalary(year, month, salary,bonus);   //���ù��ʵ����ʼ�¼��
			//person.getSalary(year,month);����
			
			account+=bonus+salary;      //�����ʼ��뵽����֧��	
			}else {                     //����ǰ����Manager���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Manager
				continue;
			}
		}
		for(Map.Entry<String, Employee>entry:list.entrySet()) {   //ֱ�ӱ�������ְ���б�,�����йɶ�����׷ֺ�
			if(entry.getValue() instanceof Shareowner) {       //�ж�value�Ƿ���Shareowner����
				if(month!=12) {                                 //�������·ݲ���12�·ݣ���������û�зֺ�
					continue;
				}else {
					double money=(income-account)*0.1;
					Shareowner person=(Shareowner)entry.getValue();  //ǿ������ת����Shareowner,�ſɵ����������еĺ���
					String name=entry.getValue().toString();         //��ȡ�ɶ�����
					double share=person.getShare();                  //��ȡ�ɶ��ɷ�
					person.setSalary(year,month,money,share);        //����ĳ��12�µķֺ쵽���ʼ�¼��
					System.out.println("��"+entry.getKey()+"��"+name+"��׷ֺ�!");
				}
			}
		}
	}
	
	

	/***
	 * ��ѯĳְ���Ĺ��ʼ�¼
	 */
	public void findRecord() {      //��ʾ�û�����Ҫ��ѯ��ְ����
		Scanner input=new Scanner(System.in);
		System.out.println("\n����ְ����:");
		String str=input.next();    //��ȡְ����
		boolean status=false;       //���ҽ��״̬��־��false��ʾû�ҵ�
		
		for(Map.Entry<String, Employee>entry:list.entrySet()) {   //ֱ�ӱ�������ְ���б�
		if(str.equals(entry.getValue().toString())) {             //�ж������ְ�����Ƿ���ĳְ�������������ͬ
			status=true;                                          //����ͬ��������״̬��־Ϊtrue
			System.out.println(entry.getValue().toString()+"���ż�¼:");//���ְ������
			Map<String,Double>bill=entry.getValue().getSalaryBill();  //��ȡ��ְ���Ĺ��ʼ�¼
			for(Map.Entry<String, Double>object:bill.entrySet()) {    //�������ʼ�¼��������еĹ���
				System.out.println(" "+object.getKey()+" ����:"+object.getValue()+" ");
				
			}
			
		}else {                 //����ǰѭ���Ҳ�����ͬ������ְ�������������˴Σ�������һ��ѭ��
			continue;
		}
		}
		if(!status) {
			System.out.println("Ա���������ڣ�");
		}
	}

}
