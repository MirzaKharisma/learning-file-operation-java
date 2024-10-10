package com.enigmacamp;

import java.io.*;

public class LearnIOFile {
    final static File fileOs = new File("src/com/enigmacamp/db/FOS.txt");
    final static File fileWr = new File("src/com/enigmacamp/db/FWR.txt");
    final static File buffWR = new File("src/com/enigmacamp/db/BWR.txt");
    public static void main(String[] args) {
        System.out.println("Learn IO File");
        try{
            writeBufferedWriter();
            readBufferedReader();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static void writeFileOutputStream() throws IOException {
        System.out.println("FILE OUTPUT STREAM");
        FileOutputStream fos = new FileOutputStream(fileOs);
        try{
            fos.write("Iklil".getBytes());
            fos.write('\n');
            fos.write("Mirza".getBytes());
            System.out.println("Berhasil: " + fileOs.length());
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            fos.close();
        }

    }

    static void readFileInputStream() throws IOException {
        System.out.println("FILE INPUT STREAM");
        FileInputStream fis = new FileInputStream(fileOs);

        // Cara 1
        StringBuilder result = new StringBuilder();
        for(int c: fis.readAllBytes()){
            result.append((char) c);
        }
        System.out.println(result);

        //Cara 2
        StringBuilder resultBuilder = new StringBuilder();
        for(int i=0; i<fileOs.length(); i++){
            resultBuilder.append((char) fis.read());
        }
        System.out.println(resultBuilder);

        //cara 3
        String resultMagic = new String(fis.readAllBytes());
        System.out.println("Magic: " + resultMagic);

        //cara 4
        while(fis.available()>0){
            resultBuilder.append((char) fis.read());
        }
        System.out.println(resultBuilder);
        fis.close();
    }

    static void fileWriter() throws IOException {
        System.out.println("FILE WRITER STREAM");
        FileWriter fw = new FileWriter(fileWr);
        fw.write("Mirza");
        fw.write('\n');
        fw.write("Andika Kangen band");
        fw.append('\n');
        fw.append("Aditira");
        //fw.flush(); menghapus
        fw.close();
        System.out.println("Berhasil: " + fileWr.length());
    }

    static void fileReader() throws IOException {
        System.out.println("FILE READER STREAM");
        FileReader fr = new FileReader(fileWr);
        StringBuilder result = new StringBuilder();
        while(fr.ready()){
            result.append((char) fr.read());
        }
        System.out.println(result);
        fr.close();
    }

    static void writeBufferedWriter() throws IOException {
        System.out.println("BUFFER WRITER STREAM");
        BufferedWriter bw = new BufferedWriter(new FileWriter(buffWR, false));
        bw.write("Kharisma");
        bw.write('\n');
        bw.write("Andika Kangen band");
        bw.append('\n');
        bw.append("Aditira");
        bw.close();
        System.out.println("BufferedWriter: " + buffWR.length());
    }

    static void readBufferedReader() throws IOException {
        System.out.println("BUFFER READER STREAM");
        BufferedReader br = new BufferedReader(new FileReader(buffWR));
        StringBuilder result = new StringBuilder();
        while(br.ready()){
            result.append((char) br.read());
        }
        System.out.println(result);
        System.out.println(br.readLine());//hasilnya null karena sudah ada result sebelumnya
        System.out.println(br.readLine());
        br.close();
    }
}
