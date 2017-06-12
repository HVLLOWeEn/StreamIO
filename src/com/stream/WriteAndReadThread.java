package com.stream;
import java.io.*;
/**
 * Created by romansynovets on 6/12/17.
 */
public class WriteAndReadThread implements Runnable {
    Thread thrd;
    ReaderWriterFile rwFile;
    private String status;

    public WriteAndReadThread(String name, ReaderWriterFile rwFile) {
        thrd = new Thread(this, name);
        this.rwFile = rwFile;
        thrd.start();
    }
    public void run() {
        if(thrd.getName().compareTo("Read") == 0) {
            for(int i = 0; i < 10; i++)rwFile.readWithFile(true);
            rwFile.readWithFile(false);
        }
        else {
            for(int i = 0; i < 10; i++) rwFile.writeInFile(true);
            rwFile.writeInFile(false);
        }
    }
}
