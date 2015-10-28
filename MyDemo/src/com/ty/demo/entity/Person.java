package com.ty.demo.entity;

import android.os.RemoteException;

import com.ty.demo.aidl.IPerson;

/**
 * Created by Administrator on 2015/10/19.
 */
public class Person extends IPerson.Stub{

    private String name;

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void setValue(String name) throws RemoteException {
            this.name=name;
    }

    @Override
    public String getValue() throws RemoteException {
        return name;
    }
}
