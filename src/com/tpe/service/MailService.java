package com.tpe.service;

import com.tpe.domain.Message;

public class MailService implements MessageService{
    public void sendMessage(Message message){
        System.out.println("I am a mail service. I am sending you this message: "+message.getMessage());
    }

    //ask? if i send MailService class, will it affect Message class???
    //if i change Message class, will it affect MailService class? //comment getMessage() and see?
}
