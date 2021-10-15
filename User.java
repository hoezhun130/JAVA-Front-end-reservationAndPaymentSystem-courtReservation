/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Tan Chin Yung
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
         return String.format("%-15s  %-10s",username,password);
    }
    
    public  boolean validateID(String username){
          boolean validID = true;
            if ( username.length() !=10)
            {
                    validID = false;
            }
            else
            {
                int countDigit=0;
                int countLetter=0;
                
                for(int i=0;i<password.length();i++){
                    if(Character.isLetter(password.charAt(i))){
                        countLetter++;
                    }
                    else if(Character.isDigit(password.charAt(i))){
                        countDigit++;                       
                    }
                    else{
                        validID=false;
                    }              
                    }
                // A ID must contains characters and digits
                if(countLetter==0||countDigit==0){
                    validID=false;
                      }
            }
        return validID;
    
     }
      
    public  boolean validatepass(String password){
          boolean validPS = true;
            if ( password.length() <7)
            {
                    validPS = false;
            }
            else
            {
                int countDigit=0;
                int countLetter=0;
            
                for(int i=0;i<password.length();i++){
                    if(Character.isLetter(password.charAt(i))){
                        countLetter++;
                    }
                    else if(Character.isDigit(password.charAt(i))){
                        countDigit++;                       
                    }
                    else{
                        validPS=false;
                    }              
                    }
               
                if(countLetter==0||countDigit==0){
                    validPS=false;
                      }
            }
        return validPS;
    
     }
}
