package com.wang.utils;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;


import org.apache.activemq.spring.ActiveMQConnectionFactory;

public class ActiveMqTest {

	private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	private Connection connection;

	public Session getSession() throws JMSException {
		if (connection == null) {
			connection = connectionFactory.createConnection("admin", "admin");
			connection.start();
		}
		Session session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		return session;
	}

	public void closeConnection() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}
	
	/**
	 * 发送消息
	 * @throws JMSException
	 */
	public void sendMessage() throws JMSException
	{
		Session session= new ActiveMqTest().getSession();
		Destination destination= session.createQueue("测试");
		MessageProducer messgaeProducer=session.createProducer(destination);
		Message message=session.createMessage();
		message.setStringProperty("test1", "wwn");
		messgaeProducer.send(message);
        session.commit();
	}
	
	
	public void getMessage() throws JMSException
	{
		
		Session session= new ActiveMqTest().getSession();
		Destination destination= session.createQueue("测试");
		MessageConsumer  consumer=session.createConsumer(destination);
		 Message message=consumer.receive();
		 System.out.println(message.getStringProperty("test1"));
	}
	
	public static void main(String[] args) throws JMSException
	{
		
		//new ActiveMqTest().sendMessage();
		new ActiveMqTest().getMessage();
	}

	
}
