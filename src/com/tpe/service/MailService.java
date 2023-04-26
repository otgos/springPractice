package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DBRepository;
import com.tpe.repository.Repo;

public class MailService implements MessageService {

    private Repo repo; //create field from Repo

    //instead of creating dependent object using new keyword,
    //we used interface in parameter, and later we will create
    public MailService(Repo repo) { //create constructor
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("I am a mail service. I am sending you this message: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //need to implement save method from repo
        //Repo repo = new DBRepository(); //w
        repo.save(message);
    }
    //ask? if i send MailService class, will it affect Message class???
    //if i change Message class, will it affect MailService class? //comment getMessage() and see?
}
