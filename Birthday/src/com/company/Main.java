package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] lName = new String[3];
        String[] fName = new String[3];
        String[] bDay = new String[3];
        String[] email = new String[3];
        String template = "";
        int seged = 0;

        try {
            File myFile = new File("template.txt");
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                template += myScanner.nextLine();
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
            e.printStackTrace();
        }
        try {
            File myFile2 = new File("friendList.txt");
            Scanner myScanner2 = new Scanner(myFile2);
            while (myScanner2.hasNextLine()) {
                String data = myScanner2.nextLine();
                String[] datas = data.split(", ");
                if(seged >= 1) {
                    lName[seged - 1] = datas[0];
                    fName[seged - 1] = datas[1];
                    bDay[seged - 1] = datas[2];
                    email[seged - 1] = datas[3];
                }
                seged++;
            }
            myScanner2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
            e.printStackTrace();
        }

        //System.out.println(template);

        /*for(int i = 0; i < 3; i++)
        {
            System.out.println(fName[i]);
        }*/

        String[] msg = template.split("<.{1,10}>");

        for (int i = 0; i < fName.length; i++)
        {
            System.out.println(msg[0] + email[i] + msg[1] + fName[i] + msg[2]);
            System.out.println("-------------------------------------------------------------------------------------");
        }


    }
}
