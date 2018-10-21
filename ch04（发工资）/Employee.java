package ch02;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author ���Ƕ�
 * @Title Staff.java
 * @Description:�������---Employee
 * @version����ʱ�䣺2018��10��21������9:49:58
 * 
 */


/***
 *     �������Employee��������Լ�����
 * 			����:	    1.ְ����
 * 					2.����
 * 					3.�����·�
 * 					4.���ʼ�¼
 * 
 * 			����:  	1.��ù��ʼ�¼getSalaryBill()
 * 					2.����ְ����setID()
 * 					3.���ְ����getID()
 * 					4.���ó����·�setbirMonth()	
 * 					5.��ó����·�getbirMonth()	
 * 					6.��ӹ��ʵ����ʼ�¼��setSalary()
 *					7.�ӹ��ʼ�¼�л�ù���getSalary()		
 *					8.���ְ��������toString()
 *
 */
public class Employee {
	private int id;                                      // ְ����
	private String name;                                 // ְ������
	private int birthMonth;                              // �����·�
	private Map<String,Double>salarybill=new HashMap();  // ���ʼ�¼
	
	public Employee(String name) {                       // ����Employee����
		this.name=name; 
	}
	
	public Map<String,Double>getSalaryBill(){       // ��ȡ���ʼ�¼      
		return salarybill;
	}
	
	public void setID(int id) {                     // ����ְ����
		 this.id=id;
	}
	
	public int getID() {                           // ��ȡְ����
		return id;	
	}
	
	public void setbirthMonth(int birthMonth) {   // ���ó����·�
		this.birthMonth=birthMonth;
	}
	
	public int getbirthMonth() {                 // ��ȡ�����·�
		return birthMonth;
	}
	 
	public void setSalary(int year,int month,double salary) {                    // ���ù��ʼ�¼
		salarybill.put((year+"��"+month+"��"),new Double(salary));               // ��ݺ��·���Ϊkey,���ʽ����Ϊvalue,���빤�ʼ�¼��
	}
	
	public void getSalary(int year,int month) {                                // ��ȡ���ʼ�¼
		boolean find=false;                                                    // ���ҽ��״̬��־��false ��ʾ�Ҳ���
		for(Map.Entry<String, Double>entry:salarybill.entrySet()) {            //ֱ�ӱ����������ʼ�¼
			String date=year+"��"+month+"��";
			if (date.equals(entry.getKey())) {                                 //������ʼ�¼���е��µĹ���
				System.out.println(entry.getValue());                          //������ʽ�����־Ϊture
				find=true;
			}else {                                                            // ���Ҳ�����������ѭ������ʼ��һ��ѭ��
				continue;
			}
			
		}
		if(!find) {
			System.out.println("�޴˵���¼��");
		}
	}
	public String toString() {             //��ȡְ������
		return name;
	}
}
