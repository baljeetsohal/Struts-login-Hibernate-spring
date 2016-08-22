package com.igt.user.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.igt.Dao.DelRecordsDao;
import com.igt.Dao.FetchRecordsDao;
import com.igt.Dao.RegisterDao;
import com.igt.DaoImpl.DelRecordsDaoImpl;
import com.igt.DaoImpl.FetchRecordsDaoImpl;
import com.igt.DaoImpl.RegisterDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

import Model.user;


public class WelcomeUserAction extends ActionSupport
{
private static final long serialVersionUID = 1L;
private List<user> listUser;
private user us;
public boolean flag=false;
private int id;

private RegisterDao regDaoObj;
private FetchRecordsDao fetchDaoObj;
private DelRecordsDao delDaoObj;
public RegisterDao getRegDaoObj() {
	return regDaoObj;
}

public void setRegDaoObj(RegisterDao regDaoObj) {
	this.regDaoObj = regDaoObj;
}

public FetchRecordsDao getFetchDaoObj() {
	return fetchDaoObj;
}

public void setFetchDaoObj(FetchRecordsDao fetchDaoObj) {
	this.fetchDaoObj = fetchDaoObj;
}

public DelRecordsDao getDelDaoObj() {
	return delDaoObj;
}

public void setDelDaoObj(DelRecordsDao delDaoObj) {
	this.delDaoObj = delDaoObj;
}


public List<user> getListUser() {
	return listUser;
}

public void setListUser(List<user> listUser) {
	this.listUser = listUser;
}

public user getUs() {
	return us;
}

public void setUs(user us) {
	this.us = us;
}

public boolean isFlag() {
	return flag;
}

public void setFlag(boolean flag) {
	this.flag = flag;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
public String userlist()
{ 
	listUser = fetchDaoObj.execute();
	return "success";
}


   public String register()
   {  	

	regDaoObj.init(this);
	regDaoObj.saveintodb();
	  return "success";
	 
   }

   public String delete()
   {
	
	  
      delDaoObj.delete(getId());
	  listUser = fetchDaoObj.execute();
		return "success";
   }
   
   public String update()
   {	
	   flag=true;
	
		setUs(fetchDaoObj.update(getId()));
		return "success";
   }
 

 
   
}