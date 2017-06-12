package com.stream;
/**
 * Created by romansynovets on 6/12/17.
 */
public class WriteAndReadThread extends Thread {
    ReaderWriterFile rwFile;
    private String status;
    private FileMode filemode;

    public WriteAndReadThread(FileMode filemode, ReaderWriterFile rwFile) {
        this.filemode = filemode;
        this.rwFile = rwFile;
    }
    public void run() {
        switch(filemode) {
            case READ: {
                do {
                    rwFile.readWithFile(true);
                } while(false);
                rwFile.readWithFile(false);

                break;
            }
            case WRITE: {
                do {
                    rwFile.writeInFile(true);
                } while(false);
                rwFile.writeInFile(false);
            }
        }
    }
}
