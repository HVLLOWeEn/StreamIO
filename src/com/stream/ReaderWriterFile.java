package com.stream;
import java.io.*;

/**
 * Created by romansynovets on 6/12/17.
 */
public class ReaderWriterFile {
    String status;
    private String dataWithFile;


    public synchronized void readWithFile(boolean running) {
        if(!running) {
            status = "readed";
            notify();
            return;
        }

        try(BufferedReader buffRead =
                    new BufferedReader(new FileReader("FileRead.txt"))) {
            // Открываем файл для чтения
            String currenLine;
            try {
                do {
                    currenLine = buffRead.readLine();
                    dataWithFile += currenLine;

                } while(currenLine != null);
            } catch (IOException exc) {
                System.out.println("Ошибка чтения из файла!");
            }

            status = "readed";          // статус чтения
            notify();                   // позволить выполнится методу writeInFile();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание потока!");
            }

            while (!status.equals("writed")) {
                try {
                    wait();
                } catch (InterruptedException exc) {
                    System.out.println("Прерывание потока!");
                }
            }
        } catch(IOException exc) {
            System.out.println("Ошибка при открытии файла!");
        }
    }

    public synchronized void writeInFile(boolean running) {
        if (!running) {
            status = "writed";
            notify();
            return;
        }

        try (BufferedWriter buffWrite =
                     new BufferedWriter(new FileWriter("FileWrite.txt"))) {     // Открываем файл для записи
            try {
                buffWrite.write(dataWithFile);
            } catch (IOException exc) {
                System.out.println("Ошибка при записи в файл!");
            }
            status = "writed";
            notify();

            try {
                Thread.sleep(200);
            } catch(InterruptedException exc) {
                System.out.println("Прерывание потока!");
            }

            while (!status.equals("readed")) {
                try {
                    wait();
                } catch (InterruptedException exc) {
                        System.out.println("Прерывание потока!");
                }
            }
        } catch(IOException exc) {
            System.out.println("Ошибка открытия файла для записи!");
        }
    }
}
