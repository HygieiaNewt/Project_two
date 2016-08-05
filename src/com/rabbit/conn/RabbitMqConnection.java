package com.rabbit.conn;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqConnection {
	
	protected Channel channel;
	protected Connection connection;
	protected String queueName;
	
	public RabbitMqConnection(String queueName) throws Exception
	{
		this.queueName = queueName;
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("guest");
		connection = factory.newConnection();
		
		channel = connection.createChannel();
		Map<String, Object> exchange = new HashMap<String, Object>();
		exchange.put("Ip Address","localhost");
		exchange.put("Port", "5672");
		channel.exchangeDeclare("Rabbit-Exchange", "direct", false, false, false, exchange);
		String q1 = channel.queueDeclare().getQueue();
	    channel.queueBind(q1, "Rabbit-Exchange", "rabbit-key");
		channel.queueDeclare(queueName, false, false, false, null);
	}
	
	public void close() throws Exception
	{
		this.channel.close();
		this.connection.close();
	}

}
