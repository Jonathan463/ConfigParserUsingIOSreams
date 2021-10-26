package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser1 {
    static BufferedReader input = null;
    Map<String, String> map = new HashMap<>();
    private String fileName;
    static String keyName;
    public static String getKeyName() {
        return keyName;
    }

    public static void setKeyName(String keyName) {
        ConfigParser1.keyName = keyName;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public ConfigParser1(String fileName){
        if(!fileName.equalsIgnoreCase("dev.txt") && !fileName.equalsIgnoreCase("production.txt")
                && !fileName.equalsIgnoreCase("staging.txt"))throw new IllegalArgumentException();
        this.fileName = fileName;
    }
    public void readFromFIle(){
        System.out.println("Hello, Welcome!\n");
        System.out.println("This application reads config files\n");




        boolean readFile = true;
        int appSectOccurrence = 1;

        while (readFile) {
//            System.out.println("""
//                        Choose a file below:
//                        1 -> dev.txt
//                        2 -> production.txt
//                        3 -> staging.txt""");
//            System.out.print("Enter your INTEGER that represent your choice: ");
//            Scanner readIn = new Scanner(System.in);
            try {
//
//                int option = readIn.nextInt();
//                readIn.nextLine();
//                String file;
//                switch (option) {
//                    case 2:
//                        file = "staging.txt";
//                        break;
//                    case 3:
//                        file = "production.txt";
//                        break;
//                    default:
//                        file = "dev.txt";
//                }
                map = new HashMap<>();
                input = new BufferedReader(new FileReader("src/main/java/"+fileName));
                String answer;
                while ((answer = input.readLine())!= null) {

                    if (!answer.isBlank())
                        if (answer.contains("[application]") && appSectOccurrence == 1) {
                            appSectOccurrence++;
                            answer = input.readLine();
                            while (!answer.isBlank()) {
                                String[] array = answer.split("=");
                                map.put("application1." + array[0], array[1]);
                                answer = input.readLine();
                            }
                        }
                        else if(answer.contains("[application]") && appSectOccurrence == 2){
                            answer = input.readLine();
                            while (!answer.isBlank()) {
                                String[] array = answer.split("=");
                                map.put("application2." + array[0], array[1]);
                                answer = input.readLine();
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
            System.out.println("You are in "+fileName);
            //getName(keyName);
//            System.out.println("Enter A Key to get the Value");
//            //System.out.println(map.get("application1.name"));
//            Scanner sc = new Scanner(System.in);
//            String keyName = sc.nextLine();
//            System.out.println(keyName +" = "+ getName(keyName));
//            System.out.print("\nWould you like to run this application again (Y/N): ");
//            String response = readIn.nextLine();
////
//            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")){
//                readFromFIle();}
//            else {
//                readFile = false;
//            }
            readFile = false;
        }


    }
    public String getValueByKey (String keyName){


        return keyName + " Is " + map.get(keyName);
    }
}
