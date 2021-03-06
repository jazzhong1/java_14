package com.iu.n1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	// 서버로 접속하기위한 클라이언트
	public static void main(String[] args) {

		Socket socket = null;

		try {
			socket = new Socket("192.168.20.58", 8282);
			//클라이언트도 소켓을 하나만만든다.

			boolean check = true;
			while (check) {
				
				OutputStream os = socket.getOutputStream(); // byte를 처리하는애
				OutputStreamWriter ow = new OutputStreamWriter(os); // 문자를 쓰려고
				BufferedWriter bw = new BufferedWriter(ow); // 문자열을 쓰려고
				System.out.println("서버로보낼 메세지를 입력하세요");
				Scanner sc = new Scanner(System.in);
				String str = sc.next();
				bw.write(str + "\r\n");
				bw.flush();

				if (str.toUpperCase().equals("EXIT")) {
					break;
				}

				InputStream is = socket.getInputStream();
				InputStreamReader ir = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(ir);
				String str1 = br.readLine();
				System.out.println(str1);

				if (str1.toUpperCase().equals("EXIT")) {
					break;
				}

			}
			System.out.println("종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} // 서버ip주소,포트
		// 지금은 자기가 server가 되고 clinet가 된다.

	}
}
