package com.igt.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.user;
 


import org.springframework.beans.factory.annotation.Autowired;


import com.igt.Dao.DelRecordsDao;  
  
public class DelRecordsDaoImpl implements DelRecordsDao 
{
	private SessionFactory sessionFactory;
	  public DelRecordsDaoImpl(SessionFactory sessionFactory)
	  {
	
		this.sessionFactory = sessionFactory;
	}



	

	public void delete(int id){  
	  
	    Session session=sessionFactory.openSession();  
	 
       String sql="delete from user where id=:id";
       Query q=session.createQuery(sql);
       q.setParameter("id",id);
       q.executeUpdate();
  
	
	}  

}