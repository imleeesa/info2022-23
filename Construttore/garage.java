public class Garage{
    private veicolo[] parcheggio[];

    public Garage(int maxVeicoli){
        this.maxVeicoli = maxVeicoli;
        this.parcheggio = New Veicolo(this.maxVeicoli);
    }
    public boolean isFull(){
        boolean result=true;
        for(nt i=0; i<this.maxVeicoli; i++){
            if (parcheggio[i]==null){
                result = false;
            }
        }
    }
}