package Bai6;

import Bai5.InvalidAgeException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        try{
            user.setAge(-5);
        }catch(InvalidAgeException e){
            Logger.logError(e.getMessage());
        }

        try{
            processUserData();
        }catch(IOException e){
            Logger.logError("Loi file: " + e.getMessage());
        }

        if(user != null){
            System.out.println("Chuong trinh tiep tuc chay ");
        }
    }

    public static void processUserData() throws IOException{
        saveToFile();
    }

    public static void saveToFile() throws IOException{
        throw new IOException("Khong the gui file");
    }
}