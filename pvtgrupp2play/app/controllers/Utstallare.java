package controllers;
public class Utstallare{
    public int id;
    public String namn;
    public String land;
    public String beskr;
    
    Utstallare(){
        
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(String idstr) throws Exception {
        
        Integer idnr;
        
        if (idstr!=null){
            if (!idstr.isEmpty()){
                try {
                    idnr = Integer.parseInt(idstr);
                    this.id=idnr.intValue();
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }else {
            throw new Exception("Inget id");
        }
    }
    
    public String getNamn(){
        return namn;
    }
    
      public void setNamn(String namn){
        if (namn!=null){
            if (!namn.isEmpty()&&namn.length()<=45&&namn.length()>1){
                this.namn=namn;
        }
    }else this.namn=new String("Inget namn");
    
    }
    
    
    public String getLand(){
        return land;
    }
  
    public void setLand(String land){
        if (land!=null){
            if (!land.isEmpty()&&land.length()<=45&&land.length()>1){
                this.namn=namn;
        }
    }else this.land=new String("Inget land");
  
    }
    
    
    
    
    
    
}