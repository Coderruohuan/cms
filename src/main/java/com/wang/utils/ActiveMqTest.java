package com.wang.utils;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

public class ActiveMqTest {

	private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

	private Connection connection;

	public Connection getConnetion() throws JMSException {
		if (connection == null) {
			connection = connectionFactory.createConnection("admin", "admin");
			connection.start();
		}
		return connection;
	}

	public void closeConnection() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}

}
