package com.wwh.demo.java.serializable;

import com.wwh.demo.java.serializable.pojo.User;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class SerializableDemo {

    public static void main(String[] args) {
        User user = new User("张三", 18);
        System.out.println(user);

//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("serializableDemo"));
//            oos.writeObject(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            try {
//                oos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("serializableDemo"));
            Object newUser = ois.readObject();
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class GT<T>{
    public static int var=0;
    public void nothing(T x){}

    public static void main(String[] args) {
        GT<Integer> gti = new GT<Integer>();
        gti.var=1;
        GT<String> gts = new GT<String>();
        gts.var=2;
        System.out.println(gti.var);
    }
}
