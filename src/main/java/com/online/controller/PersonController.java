package com.ecomm_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.onlinetutorialspoint.dao.ItemDAO;
import com.onlinetutorialspoint.dao.OrderDAO;
import com.onlinetutorialspoint.dao.PersonDAO;
import com.onlinetutorialspoint.model.Item;
import com.onlinetutorialspoint.model.Order;
import com.onlinetutorialspoint.model.Person;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
	
	PersonController(){}
	@Autowired
	private PersonDAO personDao;
	@Autowired
	private ItemDAO itemDao;

	@Autowired
	private OrderDAO orderDao;

	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Person person = new Person();
			person.setId(id);
			personDao.delete(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully deleted!";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String name, String address,String email) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setAddress(address);
			person.setEmailId(email);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}
	
	@RequestMapping(value = "/allPersons")
	@ResponseBody
	public List<Person> getAllPersons() {
		try {
			List<Person> tasks=personDao.getAllPersons();
			  return tasks;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(value = "/deleteitem")
	@ResponseBody
	public String deleteItem(long id) {
		try {
			Item itm = new Item();
			itm.setId(id);
			itemDao.delete(itm);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Item succesfully deleted!";
	}

	@RequestMapping(value = "/saveItem")
	@ResponseBody
	public String createItem(String iname, String desc,String avail,int cid) {
		try {
			Item itm = new Item();
			itm.setIname(iname);
			itm.setDesc(desc);
			itm.setAvail(avail);
			itm.setCid(cid);
			itemDao.savePerson(itm);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}
	
	@RequestMapping(value = "/allItems")
	@ResponseBody
	public List<Item> getAllItems() {
		try {
			List<Item> tasks=itemDao.getAllItems();
			  return tasks;
		//	return itemDao.getAllItems();
		} catch (Exception ex) {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/allOrders")
	@ResponseBody
	public List<Item> getAllOrders() {
		try {
			List<Item> tasks=orderDao.getAllOrders();
			  return tasks;
		//	return itemDao.getAllItems();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(value = "/saveOrder")
	@ResponseBody
	public String saveOrder(String email,int quantity,int itmid) {
		try {
			Order itm = new Order();
			Item it=new Item();
			itm.setEmail(email);
			itm.setQuantity(quantity);
			itm.setItemid(itmid);
			it.setId(itmid);
			
			orderDao.saveOrder(itm,it);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Order succesfully saved!";
	}

}
