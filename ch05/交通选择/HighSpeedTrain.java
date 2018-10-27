package ch05;

import java.text.DecimalFormat;
/***
 * 
 * 
 * 
 * @author ���Ƕ�
 * @date 2018��10��27������9:50:23
 * @version Oxygen.3a Release (4.7.3a)
 * @Description: ��������� 
 *
 */


/****
 * @ClassName:HighSpeedTrain
 * @Description:ʵ�ֳ��󷽷�	spend
 *
 */
public class HighSpeedTrain extends Vehicle {

	/**   
	 * @Title:HighSpeedTrain
	 * @Description:����HighSpeedTrain����   
	 * @param: speed ����
	 * @param: price �۸�
	 * @throws   
	 */  

	public HighSpeedTrain(double speed,double price) {
		
		/*���û��๹�췽�������ó��з�ʽΪ����*/
		super("����", speed, price);
		
		/*���ݸ������е��ص㣬����������Ե�ֵ����Щʱ���ܺ�Ϊ1.3h*/
		super.setArriveTime(0.3);
		super.setBackTime(0.3);
		super.setCheckTime(0.1);
		super.setWaitTime(0.5);
		super.setTicketTime(0.1);
	}

	
	/**   
	 * @Title:spend
	 * @Description:�������ĵ�ʱ��ͷ���
	 * @param: distance ���� ��λ����
	 * @return: void
	 * @throws   
	 */  
	@Override
	public void spend(double distance) {
		
		/*������ʱ����ܺ�*/
		double totalTime=distance/super.getSpeed()+super.getArriveTime()+super.getBackTime()
						  +super.getCheckTime()+super.getWaitTime()+super.getTicketTime();
		
		/*���ܷ��ã��ܷ���=����*����*/
		double payMoney=distance*super.getPrice();
		
		/*����DecimalFormat�������ڸ�ʽ�����double�͵ĺ�ʱ�ͷ���*/
		DecimalFormat df=new DecimalFormat(".00");
		
		System.out.println(super.getStyle()+"���з�ʽ��ʱ"+df.format(totalTime)+" ,  Ԥ�ƻ���"+df.format(payMoney)+"Ԫ!");
	}
	
	
}

