package com.igt.DaoImpl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.igt.Dao.FetchRecordsDao;

import Model.user;


public class FetchRecordsDaoImpl implements FetchRecordsDao
{
	
	private SessionFactory sessionFactory;
	public FetchRecordsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

  

private List<user> list=new ArrayList<user>();
   private user use;
  
	
@Transactional
   public List<user> execute()
    {
 
	
		   Session session=sessionFactory.openSession();  
		   
		   String hql = " from user";
			 Query query = session.createQuery(hql);
			 list=query.list();
		    
			 return list;
		
	}  

	public user update(int id){  
		
		   Session session=sessionFactory.openSession(); 
	
			 String hql = " from user where id=:id";
			 Query query = session.createQuery(hql);
			 query.setParameter("id",id);
			 List result = query.list();
			 use=(user)result.get(0);
		     return use;
		 
		}  
	}  

