package controllers;
public class Produkt{
    public String id;
    public String namn;
    public int betyg;
    public String land;
    public String beskr;
    public String alkhalt;
    public String typ;
    
    public Produkt(){
        
    }
    
    public int getBetyg(){
        
        return betyg;
        
    }
    
    
    public void setBetyg(String betyginput){
        
    Integer betygnr;
       
    if (betyginput!=null){
       
    if (!betyginput.isEmpty()){
            try{
                betygnr=Integer.parseInt(betyginput);
                if (betygnr>=1&&betygnr<=5){
                    this.betyg=betygnr.intValue();
                }
                
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    } 
    }
    
}

