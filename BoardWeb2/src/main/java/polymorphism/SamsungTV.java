package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //bean 등록 설정
public class SamsungTV implements TV {
	
	/*
	 * @Autowired // <property /> 이용한 객체 주입
	 * 
	 * @Qualifier("apple") //name 체크
	 */
	@Resource(name="apple")
	private Speaker speaker;
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setSpeaker 호출");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("SamsungTV 기본 생성자");
	}
	
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV 객체 생성. price 초기화");
	}

	public void initMethod() {
		System.out.println("객체 초기화 작업 처리");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제전에 처리할 로직");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
//		System.out.println("SamsungTV volumeUp");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("SamsungTV volumeDown");
		speaker.volumeDown();
	}	
}
