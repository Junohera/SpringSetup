package com.juno.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.juno.word.dto.WordSet;
import com.juno.word.service.WordRegisterService;
import com.juno.word.service.WordSearchService;

public class MainClass {
	
	public static void main(String[] args) {
		String[] keywords = {"C", "C++", "JAVA", "JSP", "SPRING"};
		String[] values = {"C는 ...", "C++은 ...", "JAVA는 ... ", "JSP는 ... ", "spring은 ..."};
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		WordRegisterService rg = ctx.getBean("registerService", WordRegisterService.class);
		System.out.println("\n\n-------------------------------");
		
		for (int i = 0; i < keywords.length; i++) {
			WordSet ws = new WordSet(keywords[i], values[i]);
//			rg.register(ws);
		}
		
		WordSearchService ss = ctx.getBean("searchService", WordSearchService.class);
		System.out.println("\n\n-------------------------------");
		for(int i = 0; i < keywords.length; i++) {
			WordSet ws = ss.search(keywords[i]);
			System.out.println(ws.getWordKey() + "\t: ");
			System.out.println(ws.getWorkValue());
			System.out.println("----------------------------------");
		}
		ctx.close();
	}
	
}
