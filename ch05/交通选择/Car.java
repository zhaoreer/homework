package ch05;

import java.text.DecimalFormat;
/***
 
 * 
 * 
 *
 * @author 张秋娟
 * @date 2018年10月27日上午9:07:45
 * @version Oxygen.3a Release (4.7.3a)
 *  @Description: 定义汽车类
 *
 */

/****
 * @ClassName:Car
 * @Description:实现抽象方法	spend
 *
 */


public class Car extends Vehicle{

	/**   
	 * @Title:Car
	 * @Description:构造Car对象   
	 * @param: speed 车速
	 * @param: price 价格
	 * @throws   
	 */  
	
	public Car(double speed,double price) {
		
		/*调用基类构造方法，设置出行方式为汽车*/
		super("汽车", speed, price);
		
		/*根据汽车出行的特点，设置相关属性的值，这些时间总和为2.0h*/
		super.setArriveTime(0.5);	
		super.setBackTime(0.5);
		super.setTicketTime(0.3);
		super.setCheckTime(0.2);
		super.setWaitTime(0.5);
		
	}
	
	
	/**   
	 * @Title:spend
	 * @Description:计算消耗的时间和费用
	 * @param: distance 距离 单位公里
	 * @return: void
	 * @throws   
	 */  
	
	
	@Override
	public void spend(double distance) {
		
		/*求所有时间的总和*/
		double totalTime=distance/super.getSpeed()+super.getArriveTime()+super.getBackTime()
						  +super.getCheckTime()+super.getWaitTime()+super.getTicketTime();
		
		/*求总费用，总费用=单价*距离*/
		double payMoney=distance*super.getPrice();
		
		/*创建DecimalFormat对象，用于格式化输出double型的耗时和费用*/
		DecimalFormat df=new DecimalFormat(".00");
		
		System.out.println(super.getStyle()+"出行方式耗时"+df.format(totalTime)+" ,  预计花费"+df.format(payMoney)+"元!");
	}
	

}

