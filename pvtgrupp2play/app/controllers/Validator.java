package controllers;

public class Validator{
    
    
    Validator(){
        
    }
    
    public static boolean validateUid(String uid){
      
      boolean b = false;  
      
        if (uid!=null){
            try {
                Long uidnr = new Long(uid);
                if(uidnr>1000){
                    b=true;
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }return b;
        
    }
    
    public static boolean validatePid(String pid){
        
        boolean b = false;
        
        if (pid!=null){
            try {
                Long pidnr = new Long(pid);
                if (pidnr>=10000&&pidnr<=40000){
                    b=true;
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }return b;
        
    }
    
    public static boolean validateScore(String score){
        
        boolean b = false;
        
        if (score!=null){
            try {
                Long scorenr = new Long(score);
                if (scorenr>=1&&scorenr<=5){
                    b=true;
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }return b;
        
        
        
        
    }
    
    
    
    
}