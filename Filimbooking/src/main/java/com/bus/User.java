package com.bus;

import org.springframework.stereotype.Component;

@Component
public class User   
{    
String name;    
static String email;    
public String getName()   
{    
return name;    
}    
public void setName(String name)   
{    
this.name = name;    
}    
public static String getEmail()   
{    
return email;    
}    
public void setEmail(String email)   
{    
User.email = email;    
}    
}    