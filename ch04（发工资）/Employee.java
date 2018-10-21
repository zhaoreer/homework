package ch02;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:定义基类---Employee
 * @version创建时间：2018年10月21日上午9:49:58
 * 
 */


/***
 *     定义基类Employee的相关属性及方法
 * 			属性:	    1.职工号
 * 					2.姓名
 * 					3.出生月份
 * 					4.工资记录
 * 
 * 			方法:  	1.获得工资记录getSalaryBill()
 * 					2.设置职工号setID()
 * 					3.获得职工号getID()
 * 					4.设置出生月份setbirMonth()	
 * 					5.获得出生月份getbirMonth()	
 * 					6.添加工资到工资记录中setSalary()
 *					7.从工资记录中获得工资getSalary()		
 *					8.获得职工的姓名toString()
 *
 */
public class Employee {
	private int id;                                      // 职工号
	private String name;                                 // 职工姓名
	private int birthMonth;                              // 出生月份
	private Map<String,Double>salarybill=new HashMap();  // 工资记录
	
	public Employee(String name) {                       // 构造Employee对象
		this.name=name; 
	}
	
	public Map<String,Double>getSalaryBill(){       // 获取工资记录      
		return salarybill;
	}
	
	public void setID(int id) {                     // 设置职工号
		 this.id=id;
	}
	
	public int getID() {                           // 获取职工号
		return id;	
	}
	
	public void setbirthMonth(int birthMonth) {   // 设置出生月份
		this.birthMonth=birthMonth;
	}
	
	public int getbirthMonth() {                 // 获取出生月份
		return birthMonth;
	}
	 
	public void setSalary(int year,int month,double salary) {                    // 设置工资记录
		salarybill.put((year+"年"+month+"月"),new Double(salary));               // 年份和月份作为key,工资金额作为value,放入工资记录中
	}
	
	public void getSalary(int year,int month) {                                // 获取工资记录
		boolean find=false;                                                    // 查找结果状态标志，false 表示找不到
		for(Map.Entry<String, Double>entry:salarybill.entrySet()) {            //直接遍历整个工资记录
			String date=year+"年"+month+"月";
			if (date.equals(entry.getKey())) {                                 //如果工资记录中有当月的工资
				System.out.println(entry.getValue());                          //输出工资金额，并标志为ture
				find=true;
			}else {                                                            // 若找不到，跳出此循环，开始下一轮循环
				continue;
			}
			
		}
		if(!find) {
			System.out.println("无此调记录！");
		}
	}
	public String toString() {             //获取职工姓名
		return name;
	}
}
