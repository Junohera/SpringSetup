package com.juno.toys;

import com.juno.battery.Battery;
import com.juno.battery.NormalBattery;

public class ElectronicCar {
	private Battery bat; // 인터페이스의 레퍼런스 변수를 멤버변수로
	
	public ElectronicCar() {
		// 인터페이스 멤버 변수에 battery를 임플리먼트한 클래스를 대입
		bat = new NormalBattery(); 
	}
}
// 예) 장난감은 출시당시 탑재(내장) 되서 교체가 불가능한 상태로 판매됩니다.