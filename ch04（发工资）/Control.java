package ch02;

import java.util.Random;
import java.util.Scanner;

/***
 * 
 * @author ���Ƕ�
 * @Title Staff.java
 * @Description:ʵ�ַ����ʵľ�������
 * @version����ʱ�䣺2018��10��21������9:49:58
 * 
 */
/***
 * �������顿
 * ����һ�ҹ�˾���ԣ������ʺ͸��ָ����Ǳ���Ҫ���Ĺ���������ʵ��������ܡ�
 * ��Ҫ��
 * 1.��˾��Ա���������ɶ����ֽ�ɫ
 * 2.ÿ����ɫ�������������ʡ����յ�����
 * 3.ÿ��15�ŷ����ʣ���ͨԱ���������ʣ�������˹����⻹�е��½���
 * 4.��˾����Ϊ��Ӫҵ�������㣩��ȥȫ�깤��֧��
 * 5.�ɶ��йɷݣ�û�е��½��𣬵������շֺ죨12�·ݣ������շֺ�Ϊȫ�������10%��ȫ���ɶ����չɷݷֺ졣
 * 6.ȫ���ɶ��Ĺɷݼ�����ҪС�ڻ����100%
 * 7.ÿ�·�����ʱ����Ҫ�����¹����յ�Ա���;�������ɶ�û�����
 * ��ʵ�֡�
 * 1.Ա����Ϣ�ڳ�������ʱ����
 * 2.��Ҫ�������������µĹ������û�ָ��
 * 3.������Ϣ���ʱ��������Ա�����پ������ɶ���˳�����
 * ���Ľ������������ѯ����
 * 1.�����û������û���������ѯһ���û����еĹ��ʡ�����ͷֺ췢�ż�¼
 * 2.Ҳ���Բ鿴����Ա���Ĺ��ʡ�����ͷֺ췢�ż�¼
 */

public class Control {
	public static void main(String []args) {
		Random random=new Random();             //���������Ӫҵ���Χ5��-14��
		double income=random.nextInt(10)*10000+600000;
		System.out.println("��Ӫҵ��:"+income);   //�����Ӫҵ��
		Scanner input=new Scanner(System.in);
		PaySalary pay=new PaySalary();         //����ְ���б�
		Staff staff=new Staff(null);               //��������Ŀչ��캯����ǰ���ǻ�����пչ��캯��
		staff.addStaff(PaySalary.list);        //����Ա����ͨ���������þ�̬����
		System.out.println("-------");
		Manager manager=new Manager(null);         //���Ӿ���
		manager.addManager(PaySalary.list);
		System.out.println("--------");
		Shareowner shareowner=new Shareowner(null, income); //���ӹɶ�
		shareowner.addShareowner(PaySalary.list);
		System.out.println("--------");
		
		
		
		//������ְ������Ϣд��EmployeeMsg.txt�ļ���\\��ת���ַ�
		WriteTxt txt=new WriteTxt("D:\\Test\\EmployeeMsg.txt",PaySalary.list);  
		txt.WriteMsg();
		
		//������ְ����Ϣ��EmployeeMsg.txt�ļ��ж���
		ReadTxt readtxt=new ReadTxt("D:\\Test\\EmployeeMsg.txt");  
		try {
			readtxt.getMap();
		}catch(Exception e) {
			
		}
		
		System.out.println("--------");
		
		for (int i=0;i<3;i++) {
			pay.pay(income);
		}
		System.out.println("--------");
		
		
		//������ְ�����ʼ�¼д��SalaryRecord.txt�ļ�
		WriteTxt txt1=new WriteTxt("D:\\Test\\SalaryRecord.txt",PaySalary.list);
		txt1.WriteSalary();
		
		//������ְ�����ʼ�¼��SalaryRecord.txt�ļ��ж���
		ReadTxt readtxt1=new ReadTxt("D:\\Text\\SalaryRecord.txt");
		try {
			readtxt1.getMap();
		}catch(Exception e) {
			
		}
		
		//����ְ������������ѯְ���Ĺ��ʼ�¼
		pay.findRecord();
		}

}
