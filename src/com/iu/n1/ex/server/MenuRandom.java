package com.iu.n1.ex.server;

import java.util.*;

import com.iu.n1.ex.*;

public class MenuRandom {


	public DinnerDTO randomd(ArrayList<DinnerDTO> dda){
		Random random=new Random();
		int index=random.nextInt(dda.size()+1);
		DinnerDTO dinnerDTO=new DinnerDTO();
		dinnerDTO=dda.get(index);
		return dinnerDTO;
	}
	

	public LunchDTO randoml(ArrayList<LunchDTO> dda){
		Random random=new Random();
		int index=random.nextInt(dda.size()+1);
		LunchDTO lunchDTO=new LunchDTO();
		lunchDTO=dda.get(2);
		return lunchDTO;
	}
	
	
}
