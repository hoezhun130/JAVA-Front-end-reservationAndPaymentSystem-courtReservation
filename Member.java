package assignment;


/**
 *
 * @author Tan Chin Yung
 */
public class Member extends  User{
    private String MemberName;
    private String Nric;
    private String Gender;
    private String Email;
    private String Address;
     
    public Member(String MemberName, String Nric, String Gender, String Email, String Address, String username, String password) {
        super(username, password);
        this.MemberName = MemberName;
        this.Nric = Nric;
        this.Gender = Gender;
        this.Email = Email;
        this.Address = Address;
    }

    public String getMemberName() {
        return MemberName;
    }

    public String getNric() {
        return Nric;
    }

    public String getGender() {
        return Gender;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public void setNric(String Nric) {
        this.Nric = Nric;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public  int stringCompare(String password, String comfimpass)
    {
        
        int l1 = password.length();
        int l2 = comfimpass.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)password.charAt(i);
            int str2_ch = (int)comfimpass.charAt(i);
  
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
  
        
        if (l1 != l2) {
            return 1;
        }
  
     
        else {
            return 0;
        }
    }
    
    public  boolean validatemembernric(String Nric){
          boolean validenric = true;
          String regexic=("^(\\d{6}[- .]?)\\d{2}[- .]?(\\d{4}?)$");
            return Nric.matches(regexic);
     }
    
    public  boolean validatememberemail(String Email){
          boolean validemail = true;
          String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            return Email.matches(regex);
     }

   
            
}
