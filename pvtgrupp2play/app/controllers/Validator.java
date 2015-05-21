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
    
    
    
    
}