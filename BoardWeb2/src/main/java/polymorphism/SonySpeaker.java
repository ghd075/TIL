package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
//@Component("speaker")
public class SonySpeaker implements Speaker {
	public SonySpeaker(){
		System.out.println("SonySpeaker 생성");
	}
	public void volumeUp(){
		System.out.println("SonySpeaker 소리 올림");
	}
	public void volumeDown(){
		System.out.println("SonySpeaker 소리 내림");
	}	
}