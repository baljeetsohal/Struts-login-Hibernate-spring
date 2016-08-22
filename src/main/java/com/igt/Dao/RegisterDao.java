package com.igt.Dao;

import com.igt.user.action.WelcomeUserAction;

public interface RegisterDao 
{
	public int saveintodb();
	public void init(WelcomeUserAction w);
}
