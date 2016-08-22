package com.igt.Dao;

import java.util.List;

import Model.user;

public interface FetchRecordsDao 
{	
	public List<user> execute();
	 public user update(int id);
}
