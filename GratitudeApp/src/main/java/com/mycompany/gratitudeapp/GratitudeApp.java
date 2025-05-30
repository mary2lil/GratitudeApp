/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gratitudeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HP
 */


public class GratitudeApp {
     static void menu(){
        System.out.println("Enter number for what you want to do ");
        System.out.println("1.Write your gratitude today");
        System.out.println("2.Read all your gratitude");
        System.out.println("3.Search about gratitude depend on date");
        System.out.println("4.Exit");
    }
    public static void main(String[] args) throws IOException {
   
        Scanner in = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        
        while(true){
            try{
            menu();
            int choce = in.nextInt();
            if(choce==4){
                System.out.println("Thanks , Goodbye see you later");
                break;
            }
            in.nextLine();
              switch(choce){
                
                case 1:{
                    PrintWriter writegratitude = new PrintWriter(new FileWriter("gratitude.txt",true),true);
                    System.out.println("Write your gratitude today");
                    String gratitude = in.nextLine();
                    writegratitude.println("Date "+today+"  Gratitude : "+gratitude);
                    writegratitude.close();
                    break;
                }
                case 2 :{
                    Scanner readFile = new Scanner(new File("gratitude.txt"));
                    if(!readFile.hasNextLine()){
                        System.out.println("You didn't write any gratitude");
                        break;
                    }
                System.out.println("=======================");
                System.out.println(" Your Gratitude Entries ");
                   while(readFile.hasNextLine()){
                       System.out.println(readFile.nextLine());
                   }
                   System.out.println("=======================");
                   readFile.close();
                    break;
                } 
                case 3 : {
                    Scanner readFile = new Scanner(new File("gratitude.txt"));
                    if(!readFile.hasNextLine()){
                        System.out.println("Oh sorry you can't search !  You haven't written any gratitude yet");
                        break;
                    }
                    System.out.println("Enter the date you want to search for (format: YYYY-MM-DD):");
                    String date = in.nextLine();
                    boolean found = false;
                   
                    while(readFile.hasNextLine()){
                         String line = readFile.nextLine();
                        if(line.contains(date)){
                            System.out.println("You gratitude in the day "+date);
                            System.out.println(line);
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("You don't have any gratitude in the day "+ date);
                    }
                    break;
                    
                }
                default:{
                    System.out.println("Wrong options");
                }
                
            }
            
            }catch(FileNotFoundException e ){
                System.out.println("The file is not found !");
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid number (1, 2, or 3).");
                in.nextLine();
            }catch(Exception e ){
                System.out.println(e.getMessage());
            }
        }
    }
}

