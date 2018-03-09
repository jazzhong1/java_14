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
			socket=ss.accept();	//서버소켓이 받아들이면 	리턴은 socket임 중요 	소켓이 받아 들이면 	//연결 
								//소켓은 하나만 만든다.
			//나중에는 컬렉션 계열에 집어넣어넣어서 반복문으로 차례로 보낸다 그럼 동시에 보내는 느낌이 나온다. 
			
			
			//실행코드는 따로 함수로 구현해 매개변수로 소켓을 받는다.
			boolean check=true;
			while(check){
			
			InputStream is=socket.getInputStream(); 
			InputStreamReader ir=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(ir);
			String str=br.readLine();
			System.out.println(str);
			
			if(str.toUpperCase().equals("EXIT")){
				break;
			}
			
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter ow=new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(ow);
			Scanner sc=new Scanner(System.in);
			System.out.println("클라이언트로 보낼 메세지를 입력하세요");
			String str1=sc.next();
			bw.write(str1+"\r\n");
			bw.flush();
			
			if(str1.toUpperCase().equals("EXIT")){
				break;
			}
			
			}
			System.out.println("종료");
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
