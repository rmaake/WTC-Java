package com.router.repository;

import com.router.models.Attachment;

public interface IResponsibility
{
    public static int CHECKSUM = 1;
    public static int DISPATCH = 2;
    public static int ECHOBACK = 3;
    public void performAction(Attachment attach, int resp);
}