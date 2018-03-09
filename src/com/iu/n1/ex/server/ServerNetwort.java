package com.iu.n1.ex.server;

import java.io.*;
import java.net.*;

public class ServerNetwort {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private InputStreamReader ir;
	private BufferedReader br;
	
	public ServerNetwort() {
		// TODO 자동 생성된 생성자 스텁
	}
	
	public void netWort(){
		try {
			serverSocket=new ServerSocket(8282);
			socket=serverSocket.accept();
			is=socket.getInputStream();
			ir=new InputStreamReader(is);
			br=new BufferedReader(ir);
			
			String str=br.readLine();
			System.out.println(str);
			
			
			
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
