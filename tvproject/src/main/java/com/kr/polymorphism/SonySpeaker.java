package com.kr.polymorphism;

public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("===> sonyspeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("SonySpeaker---소리 울린다.");
		
	}
	public void volumDown() {
		System.out.println("SonySpeaker---소리 내린다.");
	}

}
