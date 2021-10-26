package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ConfigParser1 configParser1 = new ConfigParser1("dev.txt");
        configParser1.readFromFIle();
        System.out.println(configParser1.getValueByKey("mode"));
    }
}
