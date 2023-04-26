package com.tpe.main;

import com.tpe.domain.Message;
import com.tpe.repository.DBRepository;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repo;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import com.tpe.service.WhatAppService;

public class MyApplication {
    public static void main(String[] args) {
        Message message =new Message();
        message.setMessage("Orders have been submitted to cargo...");

        //++++++++++++++++++++level 1 starts ++++++++++++++++++++

        //I want to send this message by using MailService class..
//        MailService mailService = new MailService();
//        mailService.sendMessage(message);


        // now everything is working fine .... but there is tight coupling no loose coupling...

        //new SmsService
//        SmsService smsService = new SmsService();
//        smsService.sendMessage(message);

        // everything seems fine but i just copied and pasted the same method to another class... boilerPlateCode
        //Now if we need whatsap service we need to create everything for whatsap
//        WhatAppService whatAppService = new WhatAppService();
//        whatAppService.sendMessage(message);
//        whatAppService.saveMessage(message);

        //how can we solve this problem??

        //we can create oneInterface in common
        //comment all and
        // let s use our new interface....


        // create obj from from InterFace
//        MessageService mailService1 = new MailService();
//        mailService1.sendMessage(message);
//++++++++++++++++++++level 1 ends ++++++++++++++++++++
        // this is better but each time we need create services from interface...

        //++++++++++++++++++++level 2 starts ++++++++++++++++++++
        String serviceName = "mailService";
        MessageService service;


//        if(args.length>0){
//          serviceName = args[0];
//        }
//        if(serviceName.equalsIgnoreCase("whatsAppService")){
//            service = new WhatAppService();
//        }else if(serviceName.equalsIgnoreCase("smsService")){
//            service = new SmsService();
//        }else {
//            service = new MailService();
//        }
//        service.sendMessage(message);


        //spring framework does the same job... injects the value
        //** create this after setting paramaterized constructor
        Repo repo = new DBRepository();
        MessageService mailSerive= new MailService(repo);
        mailSerive.sendMessage(message);
        mailSerive.saveMessage(message);

        MessageService smsService = new SmsService(repo);
        smsService.sendMessage(message);
        smsService.saveMessage(message);//if I need to save this message to File then I need
         //to service class and change constructor to FileRepository

        // we are still using new keyword.. we will see it in spring

        //in this example
            //to have loosely coupling:
                //1. used interface
                //2. used DI

    }
}
