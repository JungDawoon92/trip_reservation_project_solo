package com.kr.polymorphism;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체생성");
	}
	
	public void volumeUp() {
		System.out.println("AppleSpeaker---소리 울린다.");
		
	}
	public void volumDown() {
		System.out.println("AppleSpeaker---소리내린다.");
	}

}
