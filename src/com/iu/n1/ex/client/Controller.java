package com.iu.n1.ex.client;

import java.util.*;

import org.omg.CORBA.*;

import com.iu.n1.ex.*;
import com.iu.n1.ex.client.*;

public class Controller {
	private Scanner sc;
	private LunchDTO idto;
	private LunchDAO idao;
	private DinnerDTO ddto;
	private DinnerDAO ddao;
	private ClientNetwork clientNetwork;

	public Controller() {
		sc = new Scanner(System.in);
		idao = new LunchDAO();
		ddao = new DinnerDAO();
		clientNetwork = new ClientNetwork();
	}

	public void start() {

		boolean check = true;
		System.out.println("1.lunch|2.dinner|3.종료");
		int num = sc.nextInt();
		clientNetwork.netWort(num);
		
		
		

	}
}
