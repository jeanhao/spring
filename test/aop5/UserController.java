package test.aop5;



public class UserController {
	public void login(Object name){
		System.out.println("I'm "+name+" ,I'm logining");
		
		try {
			Thread.sleep(100);//模拟登陆过程中进行了数据库查询。各种业务逻辑处理的复杂工作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
