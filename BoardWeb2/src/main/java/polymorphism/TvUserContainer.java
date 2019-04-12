package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		// 컨테이너 구동 및 설정파일 지정 -> 설정파일에 등록된 빈을 생성해서 컨테이너에 담기 (즉시로딩)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		//객체를 한 번만 생성됨(디폴트로 싱글톤 방식이다.)
		//컨터이너에 해당 객체 요청(TV객체가 생성될 때 SonySpeaker객체도 같이 생성하면 해당 메소드도 같이 호출된다.)
		TV tv = (TV) factory.getBean("tv"); //TV 주입받고 연관(의존)성이 있는 객체도 주입(Injection)
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		//컨테이너 종료
		factory.close();
		/*
		 * TV tv2 = (TV) factory.getBean("tv"); tv2.powerOn(); TV tv3 = (TV)
		 * factory.getBean("tv"); tv3.powerOn();
		 */

		/*
		 * tv.volumeUp(); tv.volumeDown(); tv.powerOff();
		 */

	}
}
