package com.stream;

/**
 * Created by romansynovets on 6/12/17.
 */
public class ShowStreamIO {
    public static void main(String[] args) {
        ReaderWriterFile rwFile = new ReaderWriterFile();
        WriteAndReadThread writeAndR_1 = new WriteAndReadThread("Read", rwFile);
        WriteAndReadThread writeAndR_2 = new WriteAndReadThread("Write", rwFile);

        try {
            writeAndR_1.thrd.join();
            writeAndR_2.thrd.join();
        } catch(InterruptedException exc){
            System.out.println("Основной поток прерван!");
        }
    }
}
