package com.router.models;

import com.router.repository.ReadWriteHandler;
import java.nio.channels.*;
import java.nio.*;
import java.net.*;

public class Attachment
{
    public AsynchronousServerSocketChannel server;
    public AsynchronousSocketChannel client;
    public int clientId;
    public ByteBuffer buffer;
    public SocketAddress clientAddr;
    public String msg[];
    public ReadWriteHandler rwHandler;
    public boolean isRead;
}
  