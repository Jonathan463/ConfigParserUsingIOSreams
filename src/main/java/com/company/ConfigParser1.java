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
    try{

        if (!fileName.equalsIgnoreCase("config.txt") && !fileName.equalsIgnoreCase("config.txt.production")
                && !fileName.equalsIgnoreCase("config.txt.staging")) {
            throw new IllegalArgumentException("You Entered A Wrong file Name");
        }else {
            this.fileName = fileName;
        }
    }
        catch(IllegalArgumentException e){
            e.printStackTrace();
    }
    }
    public void readFromFIle(){
        System.out.println("Hello, Welcome!\n");
        System.out.println("This application reads config files\n");




        boolean readFile = true;
        int appSectOccurrence = 1;

        while (readFile) {
//
            try {
//
//
                map = new HashMap<>();
                input = new BufferedReader(new FileReader("/Users/decagon/IdeaProjects/ConfigParserApp/src/main/java/"+fileName));
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

            //System.out.println("\n"+map);
            System.out.println("You are in "+fileName);

            readFile = false;
        }


    }
    public String getValueByKey (String keyName){


        return keyName + " Is " + map.get(keyName);
    }
}
