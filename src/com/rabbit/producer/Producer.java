package com.rabbit.producer;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

import com.rabbit.conn.RabbitMqConnection;

public class Producer extends RabbitMqConnection {

	public Producer(String queueName) throws Exception {
		super(queueName);
		
	}
	
	public void sendMessage(Serializable object) throws Exception
	{
		//System.out.println(object);
		channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
	}

}
