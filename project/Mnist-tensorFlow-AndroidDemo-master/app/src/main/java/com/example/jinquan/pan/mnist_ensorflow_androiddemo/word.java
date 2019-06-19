package com.example.jinquan.pan.mnist_ensorflow_androiddemo;

/**
 * Created by nanohana on 2018/7/16.
 */

public class word {
    static  private String name="Minst dataset";
    private String number;
    public word(String real_number){
        number=real_number;
    }
    public String getName(){return  name;}
    public String getNumber(){return number;}
}
