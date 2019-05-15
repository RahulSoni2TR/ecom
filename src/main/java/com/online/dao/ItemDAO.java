package com.ecomm_crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Transactional
public class ItemDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	@PersistenceContext
	private EntityManager entityManager;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String savePerson(Item itm) {
		Long isSuccess = (Long)getSession().save(itm);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}

	public boolean delete(Item item) {
		getSession().delete(item);
		return true;
	}

	//@SuppressWarnings("unchecked")
	public List<Item> getAllItems() {
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Item> list= session.createCriteria(Item.class).list();
		return list;
	//return getSession().createQuery("from item").list();
	
	//	String hql = "FROM Customer as atcl ORDER BY atcl.Customer_Id";
		//return (List<Item>) entityManager.createQuery(hql).getResultList();
	}
}
