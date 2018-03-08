package com.iu.n1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	//server를 두번돌리면 이미실행되고 있다는 오류를 보낸다.
	public static void main(String[] args) {
		ServerSocket ss=null;		//serverSocket 만듬
		Socket socket;
		try {
			ss=new ServerSocket(8282);	//보안상의 이유로 port는 닫혀있다.	//서버소켓을 만들어준다.
			System.out.println("클라이언트의 요청을 기다리는 중");
			socket=ss.accept();	//서버소켓이 받아들이면 	리턴은 soket임 중요 	소켓이 받아 들이면 	//연결 
			InputStream is=socket.getInputStream(); 
			InputStreamReader ir=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(ir);
			System.out.println(br.readLine());
					
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter ow=new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(ow);
			Scanner sc=new Scanner(System.in);
			System.out.println("클라이언트로 보낼 메세지를 입력하세요");
			bw.write(sc.next()+"\r\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ss.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
