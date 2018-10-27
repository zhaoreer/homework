package ch05;
/**
 * 
 * @author 赵惹儿
 * @data 2018年10月27日上午9:07:30
 * @version: Oxygen.3a Release (4.7.3a)
 * @Descripetion 定义接口和交通工具
 * 
 */ 

interface Transport{                   //定义接口Transport,含有一个抽象方法spend
	public void spend(double distance);
}

public abstract class Vehicle implements Transport{ //定义抽象类Vehicle,继承接口Transport
	private String style;        //出行方式
	private double arriveTime;   //到达车站（机场）的时间    单位：h
	private double backTime;    //从车站（机场）返回的时间    单位：h
	private double ticketTime;  //取票时间   单位：h
	private double waitTime;   //等待时间   单位：h
	private double checkTime;  //安检时间    单位：h
	private double speed;         //速度    单位：公里/小时
	private double price;         //价格     单位：元/公里
	

	/**   
	 * @Title:Vehicl
	 * @Description:  构造交通工具类对象   
	 * @param: style 出行方式
	 * @param: speed 车速
	 * @param: price 价格
	 * @throws   
	 */ 
	 
	public Vehicle(String style,double speed,double price){
		
		this.style=style;
		this.speed=speed;
		this.price=price;
	}
	/**   
	 * @Title:spend
	 * @Description:抽象方法 计算耗时和费用
	 * @param: distance 距离
	 * @return: void
	 * @throws   
	 */  
	
	public abstract void spend(double distance);
	
	
	/**   
	 * @Title:show
	 * @Description:调用抽象方法，展现耗时和费用
	 * @param: distance 距离
	 * @return: void
	 * @throws   
	 */  
	
	public void show(double distance) {
		
		spend(distance);
		
	}
	
	/**  
	 * @Title:setStyle 
	 * @Description: 设置出行方式
	 * @param: style 出行方式
	 * @return: void 
	 */ 
	
	public void setStyle(String style) {
		this.style=style;
	}
	
	
	/**  
	 * @Title:getStyle
	 * @Description: 获取出行方式
	 * @return:String
	 */  
	
	public String getStyle(){
		return style;
	}
	
	
	/**  
	 * @Title:setArriveTime
	 * @Description: 设置到达车站（机场）时间
	 * @param: arriveTime 到达所用时间
	 * @return: void 
	 */ 
	public void setArriveTime(double arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	

	/**  
	 * @Title:getArriveTime
	 * @Description: 获取到达车站（机场）时间
	 * @return: double
	 */  
	
	public double getArriveTime() {
		return arriveTime;
	}
	
	/**  
	 * @Title:setBackTime
	 * @Description: 设置从车站（机场）返回时间
	 * @param: backTime 返回时间
	 * @return: void 
	 */ 
	
	public void setBackTime(double backTime) {
		this.backTime=backTime;
	}
	

	/**  
	 * @Title:getBackTime
	 * @Description: 获取从车站（机场）返回时间
	 * @return: double
	 */  
	
	public double getBackTime() {
		return backTime;
	}
	
	
	/**  
	 * @Title:setTicketTime
	 * @Description: 设置取票时间
	 * @param: ticketTime 取票时间
	 * @return: void 
	 */ 

	public void setTicketTime(double ticketTime) {
		this.ticketTime = ticketTime;
	}
	
	/**  
	 * @Title:getTicketTime
	 * @Description: 获取取票时间
	 * @return: double
	 */  
	
	public double getTicketTime() {
		return ticketTime;
	}
	
	
	/**  
	 * @Title:setCheckTime
	 * @Description: 设置安检时间
	 * @param: checkTime 安检时间
	 * @return: void 
	 */ 
	
	public void setCheckTime(double checkTime) {
		this.checkTime=checkTime;
	}
	
	/**  
	 * @Title:getCheckTime
	 * @Description: 获取安检时间
	 * @return: double
	 */  
	
	public double getCheckTime() {
		return checkTime;
	}
	

	/**  
	 * @Title:setWaitTime
	 * @Description: 设置等待时间
	 * @param: waitTime 等待时间
	 * @return: void 
	 */ 
	
	public void setWaitTime(double waitTime) {
		this.waitTime=waitTime;
	}
	
	/**  
	 * @Title:getWaitTime
	 * @Description: 获取等待时间
	 * @return: double
	 */  
	public double getWaitTime() {
		return waitTime;
	}
	
	/**  
	 * @Title:setSpeed
	 * @Description: 设置速度
	 * @param: speed 车速
	 * @return: void 
	 */ 
	public void setSpeed(double speed) {
		this.speed=speed;
	}
	

	/**  
	 * @Title:getSpeed
	 * @Description: 获取车速
	 * @return: double
	 */  
	public double getSpeed() {
		return speed;
	}
	
	/**  
	 * @Title:setPrice
	 * @Description: 设置价格
	 * @param: price 价格
	 * @return: void 
	 */ 
	public void setPrice(double price) {
		this.price=price;
	}
	
	/**  
	 * @Title:getPrice
	 * @Description: 获取价格
	 * @return: double
	 */  
	public double getPrice() {
		return price;
	}

		
	
}



