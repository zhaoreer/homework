package ch02;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author 赵惹儿
 *
 * @version创建时间：2018年10月21日下午7:14:18
 */
public class WriteTxt {
		
		String path;    //存放路径
		 Map<String,Employee>list=new HashMap();    //职工列表，用于存放员工、经理、股东对象 
		public WriteTxt(String path , Map list) {   //构造WriteTxt对象  
			
			this.path = path;
			this.list = list;
			
		}
		
	
		public  void newTxt()throws Exception{  //新建.txt文件
			
			File file = new File(path);  //实例化一个File对象
			if(file.exists()) {         //如果该文件存在	
				file.mkdirs();   //file.mkdir()创建指定路径的目录。如果父路径不存在，会创建失败报错
				                 //file.mkdirs()自动创建不存在的父路径
			}
			
		}
		
		public boolean WriteSalary() {   //按先员工、再经理、后股东的顺序将工资记录写入.txt文件
			try {
				newTxt();                                     //重新建立一个.txt文件
				FileWriter fw=new FileWriter(path);           //建立FileWriter对象，并实例化fw
				for(Map.Entry<String, Employee> entry:list.entrySet()) {    //直接遍历整个职工列表,先写所有员工的工资记录
					
					if(entry.getValue() instanceof Staff) {   //判断value是否是Staff类型
						Staff person=(Staff)entry.getValue();   //强制类型转换成Staff,才可调用子类特有的函数
					
						fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");//向文件写入职位和姓名
						
						 Map<String,Double>bill=person.getSalaryBill();  //获取工资记录
						
						 for(Map.Entry<String,Double>object:bill.entrySet()) {  //遍历工资记录，写入文件中
						
							 fw.write(" "+object.getKey()+" 工资:"+object.getValue()+"  ");  //写入年月和工资金额
								
						 }
						 
						 fw.write("\n");
					}else {      //若当前不是Staff类型，则跳出此次循环，进行下次循环，直到找遍所有Staff
						
						continue;
					}
				}
				
				for(Map.Entry<String, Employee> entry:list.entrySet()) {  //直接遍历整个职工列表,写所有经理的工资记录
					
					if(entry.getValue() instanceof Manager) {    //判断value是否是Manager类型
						
		
						Manager person=(Manager)entry.getValue();   //强制类型转换成Manager,才可调用子类特有的函数
						fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");  //写入职位和姓名
						 Map<String,Double>bill=person.getSalaryBill();   //获取工资记录
						 
						 for(Map.Entry<String,Double>object:bill.entrySet()) {   //遍历工资记录，写入文件中
							 fw.write(" "+object.getKey()+" 工资:"+object.getValue()+"  ");//写入年月、奖金和工资金额
								
						 }
						 
						 fw.write("\n");
					}else {    //若当前不是Manager类型，则跳出此次循环，进行下次循环，直到找遍所有Manager
						
						continue;
					
					}
				}
				
				for(Map.Entry<String, Employee> entry:list.entrySet()) {   //直接遍历整个职工列表,写所有股东的分红记录
					if(entry.getValue() instanceof Shareowner) {          //判断value是否是Shareholder类型
						
						Shareowner person=(Shareowner)entry.getValue();   //强制类型转换成Shareholder,才可调用子类特有的函数
						
						
						fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");  //写入职位和姓名
						
						 Map<String,Double>bill=person.getSalaryBill();    //获取工资记录
						 
						 for(Map.Entry<String,Double>object:bill.entrySet()) {   //遍历工资记录，写入文件中
							 
							 fw.write(" "+object.getKey()+" 分红:"+object.getValue()+"  ");   //写入年月和分红
								
						 }
						 
						 fw.write("\n");
					}
				}

				fw.close();
				
			} catch (Exception e) {
				
				/*打印异常*/
				e.printStackTrace();
				return false;

			}
			return true;
		}

		
		
		
		public boolean WriteMsg() {   //把职工信息写入.txt文件
			try {
				newTxt();           //重新建立一个txt文件
				FileWriter fw=new FileWriter(path);  //建立FileWriter对象，并实例化fw
				for(Map.Entry<String, Employee> entry:list.entrySet()) {   //直接遍历整个职工列表,写入所有职工的信息
					
					String name=entry.getValue().toString();  //获取职工的姓名
				
					int id=entry.getValue().getID();   //获取职工号
					
					int month=entry.getValue().getbirthMonth();  //获取出生月份
					
					if(entry.getValue() instanceof Shareowner) {  //判断当前对象是否是股东类型
						
						Shareowner person=(Shareowner)entry.getValue();  //强制类型装换，调用Shareholder特有的方法
						
						double share=person.getShare();  //获取股东的股份
						
						fw.write("【"+entry.getKey()+"】 "+name+" 职工号:"+id+" 生日月份:"+month+"股份:"+share+"\n");  //若是股东类型，则写入姓名、职工号、生日月份和股份
					}else {    //若不是股东类型，则写入姓名、职工号、生日月份
						
						fw.write("【"+entry.getKey()+"】 "+name+" 职工号:"+id+" 生日月份:"+month+"\n");//写入文件内容;
					}
				}

				fw.close();
				
			} catch (Exception e) {
				
				
				e.printStackTrace();
				return false;

			}
			
			return true;
			
		}
		
	}

