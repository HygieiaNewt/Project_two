package com.rabbit.main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.rabbit.producer.Producer;

public class RabbitMAin  {
	
	public RabbitMAin() throws Exception
	{
		Producer obj = new Producer("RabbitMainQueue");
		//Thread th = new Thread(name);
		
		for(int i=0;i<5;i++)
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("msg", "msg sent : "+i);
			obj.sendMessage((Serializable)map);
			System.out.println("Message Sent : "+i);
		}
	}

	public static void main(String[] args) throws Exception {
		
		new RabbitMAin();
		

	}

}
