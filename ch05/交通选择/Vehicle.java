package ch05;
/**
 * 
 * @author ���Ƕ�
 * @data 2018��10��27������9:07:30
 * @version: Oxygen.3a Release (4.7.3a)
 * @Descripetion ����ӿںͽ�ͨ����
 * 
 */ 

interface Transport{                   //����ӿ�Transport,����һ�����󷽷�spend
	public void spend(double distance);
}

public abstract class Vehicle implements Transport{ //���������Vehicle,�̳нӿ�Transport
	private String style;        //���з�ʽ
	private double arriveTime;   //���ﳵվ����������ʱ��    ��λ��h
	private double backTime;    //�ӳ�վ�����������ص�ʱ��    ��λ��h
	private double ticketTime;  //ȡƱʱ��   ��λ��h
	private double waitTime;   //�ȴ�ʱ��   ��λ��h
	private double checkTime;  //����ʱ��    ��λ��h
	private double speed;         //�ٶ�    ��λ������/Сʱ
	private double price;         //�۸�     ��λ��Ԫ/����
	

	/**   
	 * @Title:Vehicl
	 * @Description:  ���콻ͨ���������   
	 * @param: style ���з�ʽ
	 * @param: speed ����
	 * @param: price �۸�
	 * @throws   
	 */ 
	 
	public Vehicle(String style,double speed,double price){
		
		this.style=style;
		this.speed=speed;
		this.price=price;
	}
	/**   
	 * @Title:spend
	 * @Description:���󷽷� �����ʱ�ͷ���
	 * @param: distance ����
	 * @return: void
	 * @throws   
	 */  
	
	public abstract void spend(double distance);
	
	
	/**   
	 * @Title:show
	 * @Description:���ó��󷽷���չ�ֺ�ʱ�ͷ���
	 * @param: distance ����
	 * @return: void
	 * @throws   
	 */  
	
	public void show(double distance) {
		
		spend(distance);
		
	}
	
	/**  
	 * @Title:setStyle 
	 * @Description: ���ó��з�ʽ
	 * @param: style ���з�ʽ
	 * @return: void 
	 */ 
	
	public void setStyle(String style) {
		this.style=style;
	}
	
	
	/**  
	 * @Title:getStyle
	 * @Description: ��ȡ���з�ʽ
	 * @return:String
	 */  
	
	public String getStyle(){
		return style;
	}
	
	
	/**  
	 * @Title:setArriveTime
	 * @Description: ���õ��ﳵվ��������ʱ��
	 * @param: arriveTime ��������ʱ��
	 * @return: void 
	 */ 
	public void setArriveTime(double arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	

	/**  
	 * @Title:getArriveTime
	 * @Description: ��ȡ���ﳵվ��������ʱ��
	 * @return: double
	 */  
	
	public double getArriveTime() {
		return arriveTime;
	}
	
	/**  
	 * @Title:setBackTime
	 * @Description: ���ôӳ�վ������������ʱ��
	 * @param: backTime ����ʱ��
	 * @return: void 
	 */ 
	
	public void setBackTime(double backTime) {
		this.backTime=backTime;
	}
	

	/**  
	 * @Title:getBackTime
	 * @Description: ��ȡ�ӳ�վ������������ʱ��
	 * @return: double
	 */  
	
	public double getBackTime() {
		return backTime;
	}
	
	
	/**  
	 * @Title:setTicketTime
	 * @Description: ����ȡƱʱ��
	 * @param: ticketTime ȡƱʱ��
	 * @return: void 
	 */ 

	public void setTicketTime(double ticketTime) {
		this.ticketTime = ticketTime;
	}
	
	/**  
	 * @Title:getTicketTime
	 * @Description: ��ȡȡƱʱ��
	 * @return: double
	 */  
	
	public double getTicketTime() {
		return ticketTime;
	}
	
	
	/**  
	 * @Title:setCheckTime
	 * @Description: ���ð���ʱ��
	 * @param: checkTime ����ʱ��
	 * @return: void 
	 */ 
	
	public void setCheckTime(double checkTime) {
		this.checkTime=checkTime;
	}
	
	/**  
	 * @Title:getCheckTime
	 * @Description: ��ȡ����ʱ��
	 * @return: double
	 */  
	
	public double getCheckTime() {
		return checkTime;
	}
	

	/**  
	 * @Title:setWaitTime
	 * @Description: ���õȴ�ʱ��
	 * @param: waitTime �ȴ�ʱ��
	 * @return: void 
	 */ 
	
	public void setWaitTime(double waitTime) {
		this.waitTime=waitTime;
	}
	
	/**  
	 * @Title:getWaitTime
	 * @Description: ��ȡ�ȴ�ʱ��
	 * @return: double
	 */  
	public double getWaitTime() {
		return waitTime;
	}
	
	/**  
	 * @Title:setSpeed
	 * @Description: �����ٶ�
	 * @param: speed ����
	 * @return: void 
	 */ 
	public void setSpeed(double speed) {
		this.speed=speed;
	}
	

	/**  
	 * @Title:getSpeed
	 * @Description: ��ȡ����
	 * @return: double
	 */  
	public double getSpeed() {
		return speed;
	}
	
	/**  
	 * @Title:setPrice
	 * @Description: ���ü۸�
	 * @param: price �۸�
	 * @return: void 
	 */ 
	public void setPrice(double price) {
		this.price=price;
	}
	
	/**  
	 * @Title:getPrice
	 * @Description: ��ȡ�۸�
	 * @return: double
	 */  
	public double getPrice() {
		return price;
	}

		
	
}



