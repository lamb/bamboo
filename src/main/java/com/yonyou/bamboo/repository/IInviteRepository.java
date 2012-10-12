package com.yonyou.bamboo.repository;

import com.yonyou.bamboo.model.Invite;

public interface IInviteRepository {
	
	public void save(String email, String no);
	
	public int save(Invite invite);
}
