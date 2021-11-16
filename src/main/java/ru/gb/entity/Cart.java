package ru.gb.entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("session")
public class Cart {
    public Date date;
}