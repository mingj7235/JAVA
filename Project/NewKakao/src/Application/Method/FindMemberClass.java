package Application.Method;

import java.util.Iterator;

import Application.model.ChattingRoom;
import Application.model.Customer;

public class FindMemberClass {

	Customer customer;
	public FindMemberClass() {
		// TODO Auto-generated constructor stub
		customer =Customer.getCustomer();
	}

	public Customer FindMemberById(String cusId){
		//		System.out.println(cusId);

		Iterator<Customer> iter = customer.getFriendList().iterator();

		while(iter.hasNext()){
			Customer c = iter.next();
			if(c.getId().equals(cusId) ){ // 아이디와 pw가 일치하는것이 있다면
				return c;
			}
		}
		System.out.println("찾는 아이디 없음 에러.");
		return new Customer("#","#","#");
	}
	public ChattingRoom FindChat(String chatId){ // 고객안에 저장되어 있는 채팅창을 찾아내는 메서드

		Iterator<ChattingRoom> iter = customer.getChattingRoom().iterator();

		while(iter.hasNext()){
			ChattingRoom chat = iter.next();
			if(chat.getChatId().equals(chatId)){
				return chat;
			}
		}

		return new ChattingRoom("#");
	}

	public Customer FindMemberByPh(String Ph){ // 고객안에 저장되어 있는 채팅창을 찾아내는 메서드
		Iterator<Customer> iter = customer.getFriendList().iterator();

		while(iter.hasNext()){
			Customer cus = iter.next();
			if(cus.getPhoneNumber().equals(Ph))
			{
				return cus;
			}
		}

		return new Customer("#","#"); // 해당하는 핸드폰 가진 이 없음.
	}
}
