package com.iu.n1.ex.client;

import java.io.*;
import java.net.*;

import com.iu.n1.ex.*;

public class ClientNetwork {
	
	private Socket socket;
	private OutputStream os;
	private OutputStreamWriter ow;
	private BufferedWriter bw;

	
	
	
	public void netWort(DinnerDTO ddto,LunchDTO ldto){
		String menu=null;
		int price=0;
		String result;
		try {
			socket=new Socket("192.168.20.58", 8282);
			os=socket.getOutputStream();
			if(ddto!=null){
				menu=ddto.getMenu();
				price=ddto.getPrice();
				result="menu:"+menu+"\n"+"price:"+price;
			}
			else{
				menu=ldto.getMenu();
				price=ldto.getPrice();
				result="menu:"+menu+"price:"+price;
			}
			
			ow=new OutputStreamWriter(os);
			bw=new BufferedWriter(ow);
			bw.write(result);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				ow.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
