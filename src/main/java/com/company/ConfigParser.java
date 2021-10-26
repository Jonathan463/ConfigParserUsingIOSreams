package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigParser {
    static Map<String, String> map = new HashMap<>();
    // String fileName;
//    public ConfigParser(String fileName){
//        this.fileName = fileName;
//    }
    public static void readFromFIle(){
        System.out.println("Hello, Welcome!\n");
        System.out.println("This application reads config files\n");




        boolean readFile = true;
        int appSectOccurrence = 1;

        while (readFile) {
            System.out.println("""
                        Choose a file below:
                        1 -> dev.txt
                        2 -> production.txt
                        3 -> staging.txt""");
            System.out.print("Enter The INTEGER that represent your choice: ");
            Scanner readIn = new Scanner(System.in);
            try {

                int option = readIn.nextInt();
                readIn.nextLine();
                String file;
                switch (option) {
                    case 2:
                        file = "staging.txt";
                        break;
                    case 3:
                        file = "production.txt";
                        break;
                    default:
                        file = "dev.txt";
                }
                map = new HashMap<>();
                Scanner input = new Scanner(new File("src/"+file));
                while (input.hasNext()) {
                    String answer = input.nextLine();
                    if (!answer.isBlank())
                        if (answer.contains("[application]") && appSectOccurrence == 1) {
                            appSectOccurrence++;
                            answer = input.nextLine();
                            while (!answer.isBlank()) {
                                String[] array = answer.split("=");
                                map.put("application1." + array[0], array[1]);
                                answer = input.nextLine();
                            }
                        }
                        else if(answer.contains("[application]") && appSectOccurrence == 2){
                            answer = input.nextLine();
                            while (!answer.isBlank()) {
                                String[] array = answer.split("=");
                                map.put("application2." + array[0], array[1]);
                                answer = input.nextLine();
                            }
                        }else {
                            String[] array = answer.split("=");
                            map.put(array[0], array[1]);
                        }

                }

            } catch (Exception e) {
                //3System.out.println(e.getMessage());
            }

            System.out.println("\n"+map);

            System.out.println("Enter A Key to get the Value");
            //System.out.println(map.get("application1.name"));
            Scanner sc = new Scanner(System.in);
            String keyName = sc.nextLine();
            System.out.println(keyName +" = "+ getName(keyName));
            System.out.print("\nWould you like to run this application again (Y/N): ");
            String response = readIn.nextLine();
//
            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")){
                readFromFIle();}
            else {
                readFile = false;
            }
        }

    }
    public static String getName(String keyName){


        return map.get(keyName);
    }
}
