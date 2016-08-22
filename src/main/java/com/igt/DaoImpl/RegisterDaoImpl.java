package com.igt.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.igt.Dao.RegisterDao;
import com.igt.user.action.WelcomeUserAction;

import Model.user;

public class RegisterDaoImpl implements RegisterDao 
{	private WelcomeUserAction w;
	private SessionFactory sessionFactory;

	public RegisterDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
public void init(WelcomeUserAction w)
{
	this.w=w;
}


public int saveintodb()
{   
	
	    Session session=sessionFactory.openSession();  
       user u=w.getUs();
	 int status=0;
		if(u.getId()!=0)
		{ 
			String hql = "UPDATE user SET first=:first,last=:last,dept=:dept,pass=:pass WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("first",u.getFirst());
			query.setParameter("last",u.getLast());
			query.setParameter("dept",u.getDept());
			query.setParameter("pass",u.getPass());
			query.setParameter("id",u.getId());
			status= query.executeUpdate();
	
		}
		else
		{    
			
			long result=0;
			String SQL_QUERY = "SELECT COUNT(*) FROM user where email=:email";
			Query query = session.createQuery(SQL_QUERY);
			 query.setString("email",u.getEmail());
		
			 result = (Long)query.uniqueResult();
	
			if(result==0)
			{  session=sessionFactory.openSession(); 
		    
		  session.save(u);
	
		
			}	
	
		     
		}  

		 return status;
}}