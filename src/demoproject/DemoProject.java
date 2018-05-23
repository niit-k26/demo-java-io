/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Lrandom
 */
public class DemoProject {

    /**
     * @param args the command line arguments
     */
            
    //read file use fileinputstream
    static void demo1(){
        int c;
        FileInputStream in=null;
        try {
            in = new FileInputStream(new File("content.txt"));
            while((c = in.read())!=-1){
               System.out.println((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //read file use filereader
    static void demo2(){
        String line;
        FileReader reader=null;
        BufferedReader bufferReader =null;
        //read file use filereader
        try {
            reader = new FileReader(new File("content.txt"));
            bufferReader = new BufferedReader(reader);
            while((line=bufferReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try {
                    bufferReader.close();
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static void demo3(){
       String line;
       FileReader fileReader = null;
       BufferedReader bufferReader =null;
       FileWriter fileWriter = null;
       BufferedWriter bufferWriter=null;
       try{
          fileReader = new FileReader(new File("content.txt"));
          bufferReader = new BufferedReader(fileReader);
          fileWriter = new FileWriter(new File("content_1.txt"));
          bufferWriter = new BufferedWriter(fileWriter);
          while((line=bufferReader.readLine())!=null){
              bufferWriter.write("\n");
              bufferWriter.write(line);
          }
          bufferWriter.flush();
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           try {
               if(bufferReader!=null){
                   bufferReader.close();
                }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           try {
               if(bufferWriter!=null){
                  bufferWriter.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           try {
               if(fileReader!=null){
                  fileReader.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           try {
               if(fileWriter!=null){
                 fileWriter.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        demo1();
        System.out.println("demo 2");
        demo2();
        System.out.println("demo 3");
        demo3();
    }  
}
