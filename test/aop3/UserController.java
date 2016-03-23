package test.aop3;

public class UserController {
	public void login(String name){
		System.out.println("I'm "+name+" ,I'm logining");
	}

	//模拟非法注销
	public void logout() {
		throw new RuntimeException("illegal logout");
	}
}
