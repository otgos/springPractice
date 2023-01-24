package com.tpe.service;

import com.tpe.domain.Message;

public class WhatAppService implements MessageService {

    public void sendMessage(Message message){
        System.out.println("I am a Whatsapp service. I am sending you this message: "+message.getMessage());
    }

}
