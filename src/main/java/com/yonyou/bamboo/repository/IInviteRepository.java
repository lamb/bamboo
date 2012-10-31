package com.yonyou.bamboo.repository;

import com.yonyou.bamboo.model.Invite;

public interface IInviteRepository {

    void save(String email, String no);

    int save(Invite invite);
}
