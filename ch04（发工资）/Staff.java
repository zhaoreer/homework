package ch02;

import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author ���Ƕ�
 * @Title Staff.java
 * @Description:����Ա����
 * @version����ʱ�䣺2018��10��21������9:49:58
 * 
 */


  /***
   * ����Employee������---Ա����Staff��������Ժͷ���
   *      ���ԣ� 1.ְ����
   *          2.����
   *          3.�����·�
   *          4.���ʼ�¼
   *      ������ 1.���ù���setSalary()
   *          2.��ù���getSalary()
   *          3.�������toString()
   *          4.����Ա������Ϣ����addStaff()
   * 
   */
public class Staff extends Employee {    //����Staff����
	
	public Staff(String name) {          //���û��๹�캯��
		super (name);	
	}
	
	public void setSalary(int year,int month,double salary) {   //���ù��ʵ����ʼ�¼��
		if(super.getbirthMonth()==month){                       //���жϷ����ʵ��·ݴ�Ա���Ƿ������
			System.out.println("���տ��֣�");                      //�����¹����գ���������ף������
		}
		//super.getSalary(year, month,salary);                          //���û���setSalary����                 
	}
	public void getSalary(int year,int month) {                      //���û���setSalary����
		super.getSalary(year, month);
	}
	 
	public String toString() {                                    //��ȡԱ������
		return super.toString();
	}
	
	public void addStaff(Map<String,Employee>list) {             //����Ա��
		Scanner input=new Scanner(System.in);                //���û������ȡԱ������
		System.out.println("�����չ�����");
		int num=input.nextInt();
		if(num!=0) {   //�ж�Ա�������Ƿ�Ϊ0
			System.out.println("�����չ��Ļ�����Ϣ(id,�����������·�):");
			for(int i=0;i<num;i++) {
				int id=input.nextInt();
			    String name=input.next();
				int month=input.nextInt();
				
				Staff employee=new Staff(name);  //�û�ȡ����Ϣʵ����һ��Staff����
				employee.setID(id);
				employee.setbirthMonth(month);
				list.put("Ա��"+(i+1), employee);
			}
			
		}
	}

}
