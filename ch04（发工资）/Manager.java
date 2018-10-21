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
 * ����Employee������---������Manager��������Ժͷ���
 *       ���ԣ�     1.ְ����
 *            2.����
 *            3.�����·�
 *            4.���ʼ�¼
 *            5.����bonus
 *       ������   1.���ý���setBonus()
 *            2.��ý���getBonus()
 *            3.��ӹ��ʵ���¼��setSalary()
 *            4.�ӹ��ʼ�¼�л�ù���getSalary()
 *            5.���Ӿ���addManager()
 *            6.���ְ��������toString()
 *  
 */
public class Manager extends Employee {
	private double bonus;          //����
	
	public Manager(String name) {  //����Manager����
		super(name);
	}
	
	public void setBonus(double bonus) {  //���ý���
		this.bonus=bonus;
	}
	public double getBonus() {           //��ȡ����
		return bonus;
	}
    public void setSalary(int year,int month,double salary,double bonus) {
    	if(super.getbirthMonth()==month) {
    		System.out.println("���տ��֣�");
    	}
    	super.getSalaryBill().put((year+"��"+month+"��"+"����"+bonus),new Double(salary));
    	}
    public void getSalary(int year,int month) {    //��ȡ���ʼ�¼�еĹ���
    	super.getSalary(year, month);
    }
    
    public String toString() {                    //��ȡ��������
    	return super.toString(); 	
    }
    
    public void addManager(Map<String,Employee>list) {  //���û������ȡ������
    	Scanner input=new Scanner(System.in);
    	System.out.println("���뾭������");
    	int num=input.nextInt();
    	if(num!=0) {                                    //����������Ϊ0
    		System.out.println("���뾭����Ϣ(id,�����������·�):");//¼�뾭����Ϣ
    		for(int i=0;i<num;i++) {
    			int id=input.nextInt();
    			String name=input.next();
    			int month=input.nextInt();
    			
    			Manager manager=new Manager(name);  //��Ϣʵ����Manager����
    			manager.setID(id);
    			manager.setbirthMonth(month);
    			list.put("����"+(i+1), manager);
    		}
    		
    	}
    }
}
