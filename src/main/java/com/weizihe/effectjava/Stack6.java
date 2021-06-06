package com.weizihe.effectjava;

import java.util.Arrays;
import java.util.Date;

/**
 * description:6、消除过期的对象引用
 *
 * @author weizihe
 * @date 2018/8/12
 */
public class Stack6 {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack6(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){}

    private void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements,size*2+1);
        }
    }
}
