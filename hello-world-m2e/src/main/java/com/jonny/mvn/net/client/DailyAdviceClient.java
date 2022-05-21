package com.jonny.mvn.net.client;

import java.io.*;
import java.net.*;

public class DailyAdviceClient {
	
	public void go() {
		try {
			Socket s = new Socket("127.0.0.1", 4242);  // 建立socket
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader); // 连接数据串流
			
			String advice = reader.readLine();
			System.out.println("Toady you should: " + advice);
			
			reader.close();  // 关闭所有的串流
			s.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}

}
