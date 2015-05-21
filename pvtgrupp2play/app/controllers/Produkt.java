package controllers;
public class Produkt{
    public Long id;
    public String namn;
    public double betyg;
    public String land;
    public String beskr;
    public Double alkhalt;
    public int typ;
    public String kategori;
    
    public Produkt(){
        
    }
    
    public double getBetyg(){
        return betyg;
        
    }
    public void setBetyg(String betygstr){
        
    
       
    if (betygstr!=null){
       
    if (!betygstr.isEmpty()){
            try{
                Double betygnr= new Double(betygstr);
                if (betygnr>=1&&betygnr<=5){
                    this.betyg=betygnr.intValue();
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    } 
    }
        
    public Long getId(){
        return id;
    }
    
    public void setId(String idstr) throws Exception {
        
        if (idstr!=null){
            if (!idstr.isEmpty()){
                try {
                    Long id = new Long(idstr);
                    this.id=id;
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
    
    public int getTyp(){
        return typ;
    }
    public void setTyp(String typstr){
            
    Integer typnr;
       
    if (typstr!=null){
       
    if (!typstr.isEmpty()){
            try{
                typnr=Integer.parseInt(typstr);
                if (typnr>=1&&typnr<=12){
                    this.typ=typnr.intValue();
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    }
  
    }
    
    public Double getAlkhalt(){
        return alkhalt;
    }
    
    public void setAlkhalt(String alkstr){
        
         
         if (alkstr!=null){
            if (!alkstr.isEmpty()){
                try {
                    Double alknr = new Double(alkstr);
                    this.alkhalt=alknr;
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    
}

