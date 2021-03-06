package com.juno;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.juno.battery.ChargeBattery;
import com.juno.battery.NormalBattery;
import com.juno.toys.ElectronicCar;
import com.juno.toys.ElectronicRadio;
import com.juno.toys.ElectronicRobot;

public class MainClass {
	public static void main(String[] args) {
		/*
		ElectronicCar carToy = new ElectronicCar();
		
		ElectronicRadio radioToy = new ElectronicRadio(new NormalBattery());
		
		ChargeBattery cBat1 = new ChargeBattery();
		radioToy.setBattery(cBat1);
		
		ChargeBattery cBat2 = new ChargeBattery();
		ElectronicRobot robotToy = new ElectronicRobot();
		robotToy.setBattery(cBat2);
		
		// 위처럼 본 클래스의 생성자메서드에 다른 클래스의 실객체가 전달되어야 본클래스 객체가 만들어지는 형태를
		// 의존, 의존 주입이라고 합니다.
		
		// 자바 문법으로 의존 주입을 한다면 위에 처럼 객체 생성시 의존 주입이 이루어지지만
		// 스프링컨테이너에서의 의존주입은 컨테이너에 bean 만들어지는 시점에 모두 구현해 놓고, 시작합니다.
		// 이를 객체 조립이라고 칭합니다.
		*/
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// ElectronicCar carToy = new ElectronicCar();
		ElectronicCar carToy = ctx.getBean("car", ElectronicCar.class);
		
		// NormalBattery nBat = new NormalBattery();
		// ElectronicRadio radioToy = new ElectronicRadio(nBat);
		ElectronicRadio radioToy = ctx.getBean("radioToy", ElectronicRadio.class);
		
		ElectronicRobot robotToy = ctx.getBean("robot", ElectronicRobot.class);
		
		ChargeBattery cBat = ctx.getBean("cBattery", ChargeBattery.class);
		NormalBattery nBat = ctx.getBean("nBattery", NormalBattery.class);
		radioToy.setBattery(nBat);
		robotToy.setBattery(cBat);
		
	}
		
}
