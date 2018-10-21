package ch02;

import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author ���Ƕ�
 * @Title Staff.java
 * @Description:����ɶ���
 * @version����ʱ�䣺2018��10��21������6:24:25
 */
/***
 * ���� Shareowner���������Լ�����
 * 			����:	1.ְ����(�̳�)
 * 					2.����(�̳�)
 * 					3.�����·�(�̳�)
 * 					4.���ʼ�¼(�̳�)
 * 					5.�ɷ� share
 * 					6.��׷ֺ�annualBonus
 * 
 * 			����:	1.���ý���setBonus()
 * 					2.��ùɷ�getShare()
 * 					3.���ĳ��ĳ�µĹ��ʵ����ʼ�¼��setSalary()
 *					4.�ӹ��ʼ�¼�л��ĳ��ĳ�µĹ���getSalary()	
 * 					5.���ӹɶ�addShareholder()	
 *					6.��ùɶ�����toString()
 */
public class Shareowner extends Employee{
	private double share;  //�ɷ�
	private double annualBonus;   //��׷ֺ�
	
	public Shareowner(String name,double share) {   //����Shareowner����
		super(name);
		this.share=share;
	}
	public double getShare() {
		return share;
	}
    public void setSalary(int year,int month,double money,double share) {
    	if(month!=12) {   //�ж��Ƿ�Ϊ12 �·ݣ�������12�·�û�зֺ�
    		super.setSalary(year,month,0);
    	}else {
    		super.setSalary(year,month,money*share);
    	}
    }
    
    public String toString() {
    	return super.toString();
    }
    
    public void addShareowner(Map<String,Employee>list) {    //���ӹɶ�
    	Scanner input=new Scanner(System.in);   //���û������ȡ�ɶ���
    	System.out.println("����ɶ���:");
    	int num=input.nextInt();
    	
    	double totalShare=0;    //�ܹɷ�
    	if(num!=0) {
    		System.out.println("����ɶ���Ϣ(id,����,�����·�,�ɷ�):");    //¼��ɶ���Ϣ(id�������������·ݡ��ɷ�)
    		for (int i=0;i<num;i++) {
    		int id=input.nextInt();
    		String name=input.next();
    		int month=input.nextInt();
    		
    		double share=0;     //������Ч�ɶ�
    		double temShare=input.nextDouble();  //�û�����Ĺɷ�
    		totalShare+=temShare;      //�ɷݺͣ������жϹɷ��Ƿ�Ϸ�
    		if(totalShare>1) {         //�ܹɷ�>1,����¼��
    			System.out.println("�ɷݲ��������������ùɶ��ɷݣ�");
    			double newShare=input.nextDouble();
    			share=newShare;
    		}else {
    		share=temShare;	           //�ɷݺ������û�����Ĺɷ�Ϊ������Ч�ɷ�
    		}
    		
    		Shareowner employee=new Shareowner(name,share);  //����õ���Ϣʵ������Shareholder����
    		employee.setID(id);
    		employee.setbirthMonth(month);
    		list.put("�ɶ�"+(i+1), employee);
    		}
    	}
    }
}
