package com.ecomm_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Item;
import com.onlinetutorialspoint.model.Order;
@Repository
@Transactional
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@PersistenceContext
	private EntityManager entityManager;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Item> getAllOrders() {
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Item> list= session.createCriteria(Order.class).list();
		return list;
}
	
	public String saveOrder(Order ordr,Item tm) {
		Long isSuccess = (Long)getSession().save(ordr);
		String sql="update item set Quantity=Available- "+ordr.getQuantity()+" where item_id= "+tm.getId();
		entityManager.createQuery(sql);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Order";
		}
		
	}
	
/*	public List<Item> getAllItems() {
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Item> list= session.createCriteria(Item.class).list();
		return list;
	//return getSession().createQuery("from item").list();
	
	//	String hql = "FROM Customer as atcl ORDER BY atcl.Customer_Id";
		//return (List<Item>) entityManager.createQuery(hql).getResultList();
	}*/
}
