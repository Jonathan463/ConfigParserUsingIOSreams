package com.company;

public class Main {

    public static void main(String[] args) {
	 //write your code here
        ConfigParser1 configParser1;


        if(args.length == 0){
            configParser1 = new ConfigParser1("config.txt");
            configParser1.readFromFIle();
            String holdInfo = configParser1.getValueByKey("host");
            System.out.println(holdInfo);
        }
        else {
            configParser1 = new ConfigParser1("config.txt."+args[0]);
            configParser1.readFromFIle();
            System.out.println(configParser1.getValueByKey("mode"));
        }
       // ConfigParser.readFromFIle();
    }
}
