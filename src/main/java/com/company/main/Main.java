package com.company.main;

import com.company.entity.User;
import com.company.inter.UserInter;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import javax.persistence.Basic;
import javax.persistence.Entity;

public class Main {

    public static void main(String[] args) {
        User user=new User(null,null,"Habibli","alizaman@gmail.com","+9947894563");
        UserInter inter=Context.instanceUser();
        inter.insertUser(user);
        System.out.println(user.getId());
    }
}
