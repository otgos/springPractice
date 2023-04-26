package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DBRepository;
import com.tpe.repository.Repo;

public class WhatAppService implements MessageService {

    public void sendMessage(Message message){
        System.out.println("I am a Whatsapp service. I am sending you this message: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //need to implement save method from repo
        Repo repo = new DBRepository();
        repo.save(message);
    }

}
