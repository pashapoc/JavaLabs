package ua.lviv.iot;
import java.io.FileWriter;
import java.util.LinkedList;

public class FileSawWriter {
    public void CSVCreator (LinkedList<Saw> saws) {
        try{
            FileWriter writer = new FileWriter("testout.csv");
            for (Saw saw : saws) {
                writer.write(saw.getHeaders() + "\r\n");
                writer.write(saw.toCSV() + "\r\n");
            }

            writer.close();
        } catch(Exception e) {System.out.println(e);}
        System.out.println("Success...");
    }
}

