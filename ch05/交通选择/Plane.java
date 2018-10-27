package ch05;

import java.text.DecimalFormat;


/***
 
 * 
 * @author ���Ƕ�
 * @date 2018��10��27������10:40:29
 * @version Oxygen.3a Release (4.7.3a)
 * @Description: ����ɻ��� 
 *
 */


/****
 * @ClassName:Plane
 * @Description:ʵ�ֳ��󷽷�	spend
 * @author �����
 * @date 2018-10-20
 */



public class Plane extends Vehicle{

	/**   
	 * @Title:Plane
	 * @Description:����Plane����   
	 * @param: speed ����
	 * @param: price �۸�
	 * @throws   
	 */  
	
	public Plane(double speed,double price) {
		
		/*���û��๹�췽�������ó��з�ʽΪ�ɻ�*/
		super("�ɻ�", speed, price);
		
		/*���ݷɻ����е��ص㣬����������Ե�ֵ����Щʱ���ܺ�Ϊ1.7h*/
		super.setArriveTime(0.5);
		super.setBackTime(0.5);
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
