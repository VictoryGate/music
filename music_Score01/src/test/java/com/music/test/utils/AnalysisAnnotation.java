package com.music.test.utils;

import java.lang.reflect.Method;

import com.music.utils.authority.Authority;

public class AnalysisAnnotation {  
    
    public static void main(String[] args) {  
        try {  
              
            // 通过运行时反射API获得annotation信息  
            Class<?> rtClass = Class.forName("com.music.test.utils.Utility");  
            Method[] methods = rtClass.getMethods();  
                for (Method method : methods) {  
                    if (method.isAnnotationPresent(Authority.class)) {  
                        Authority author = method.getAnnotation(Authority.class);  
                        System.out.println("Utility's Author ---> " + author.url() + " from " + author.value());  
                    }  
                }  
              
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  