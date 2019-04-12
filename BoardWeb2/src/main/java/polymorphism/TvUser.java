package polymorphism;

public class TvUser {

	public static void main(String[] args) {
		//TV tv = new SamsungTV();
		//LgTV tv = new LgTV();
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		//TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
