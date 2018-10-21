package ch02;

import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:定义员工类
 * @version创建时间：2018年10月21日上午9:49:58
 * 
 */
/***
 * 定义Employee的子类---经理类Manager的相关属性和方法
 *       属性：     1.职工号
 *            2.姓名
 *            3.出生月份
 *            4.工资记录
 *            5.奖金bonus
 *       方法：   1.设置奖金setBonus()
 *            2.获得奖金getBonus()
 *            3.添加工资到记录在setSalary()
 *            4.从工资记录中获得工资getSalary()
 *            5.增加经理addManager()
 *            6.获得职工的姓名toString()
 *  
 */
public class Manager extends Employee {
	private double bonus;          //奖金
	
	public Manager(String name) {  //构造Manager对象
		super(name);
	}
	
	public void setBonus(double bonus) {  //设置奖金
		this.bonus=bonus;
	}
	public double getBonus() {           //获取奖金
		return bonus;
	}
    public void setSalary(int year,int month,double salary,double bonus) {
    	if(super.getbirthMonth()==month) {
    		System.out.println("生日快乐！");
    	}
    	super.getSalaryBill().put((year+"年"+month+"月"+"奖金"+bonus),new Double(salary));
    	}
    public void getSalary(int year,int month) {    //获取工资记录中的工资
    	super.getSalary(year, month);
    }
    
    public String toString() {                    //获取经理姓名
    	return super.toString(); 	
    }
    
    public void addManager(Map<String,Employee>list) {  //从用户那里获取经理数
    	Scanner input=new Scanner(System.in);
    	System.out.println("输入经理数：");
    	int num=input.nextInt();
    	if(num!=0) {                                    //若经理数不为0
    		System.out.println("输入经理信息(id,姓名，生日月份):");//录入经理信息
    		for(int i=0;i<num;i++) {
    			int id=input.nextInt();
    			String name=input.next();
    			int month=input.nextInt();
    			
    			Manager manager=new Manager(name);  //信息实例化Manager对象
    			manager.setID(id);
    			manager.setbirthMonth(month);
    			list.put("经理"+(i+1), manager);
    		}
    		
    	}
    }
}
