package com.tpe.repository;

import com.tpe.domain.Message;

public class FileRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Your message is being stored into FILE: "+message.getMessage());
    }
}
