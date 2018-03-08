package com.hong.n1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		Socket socket=null;
		OutputStream os=null;
		OutputStreamWriter ow=null;
		BufferedWriter bw=null;
		Scanner sc=new Scanner(System.in);
		try {
			socket=new Socket("192.168.0.12", 8282);
			os=socket.getOutputStream();
			ow=new OutputStreamWriter(os);
			bw=new BufferedWriter(ow);
			System.out.println("서버로보낼메시지");
			String str=sc.next();
			bw.write(str);
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
