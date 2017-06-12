package com.stream;

/**
 * Created by romansynovets on 6/12/17.
 */
public class ShowStreamIO {
    public static void main(String[] args) {
        ReaderWriterFile rwFile = new ReaderWriterFile();
        WriteAndReadThread writeAndR_1 = new WriteAndReadThread(FileMode.READ, rwFile);
        WriteAndReadThread writeAndR_2 = new WriteAndReadThread(FileMode.WRITE, rwFile);

        try {
            writeAndR_1.start();
            writeAndR_2.start();
            writeAndR_1.join();
            writeAndR_2.join();
        } catch(InterruptedException exc){
            System.out.println("Основной поток прерван!");
        }
    }
}
