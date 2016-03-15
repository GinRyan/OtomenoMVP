package org.xellossryan.mvpgo;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void testJson(){
        WildOtome po = new WildOtome();
        po.createdAt = "2016-01-05";
        po.desc = "otome ";
        po.used = true;
        po.who = "张学友";
        po.otome = new WildOtome();
        po.otome.who = "郭富城";
        po.otome.desc = "我是郭富城 ";
        System.out.print( new Gson().toJson(po));
    }
}