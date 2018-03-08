package com.hong.n1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		InputStream is=null;
		InputStreamReader ir=null;
		BufferedReader br=null;
		try {
			System.out.println("클라이언트와 연결중...");
			serverSocket=new ServerSocket(8282);
			socket=serverSocket.accept();
			
			is=socket.getInputStream();
			ir=new InputStreamReader(is);
			br=new BufferedReader(ir);
			
			String str=br.readLine();
			System.out.print("클라이언트가 보낸메시지:");
			System.out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
