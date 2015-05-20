package controllers;
public class Produkt{
    public Long id;
    public String namn;
    public int betyg;
    public String land;
    public String beskr;
    public Double alkhalt;
    public String typ;
    
    public Produkt(){
        
    }
    
    public int getBetyg(){
        
        return betyg;
        
    }
    public void setBetyg(String betygstr){
        
    Integer betygnr;
       
    if (betygstr!=null){
       
    if (!betygstr.isEmpty()){
            try{
                betygnr=Integer.parseInt(betygstr);
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
  
    
    
    
}

