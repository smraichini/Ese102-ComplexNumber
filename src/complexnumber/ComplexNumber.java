/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumber;


public class ComplexNumber {
    static private double initRe;
    static private double initIm;
    private double re;
    private double im;
 
    public ComplexNumber(){
        this.re=initRe;
        this.im=initIm;
    }
    
    static public void setInitRectangular(double re, double im){
        initIm=im;
        initRe=re;
    }
    
    static public void setInitPolar(double arg, double mod){
       if(mod < 0)
        	throw new IllegalArgumentException("Modulus must be greater or equal to 0");
        initRe = Math.cos(arg*Math.PI/180)*mod;
        initIm = Math.sin(arg*Math.PI/180)*mod;
    }
  
    /**
 * Richiede modulo e argomento,considerare che la classe gestisce tutti gli angoli in modo sessagesimale
 * e che il modulo non può essere minore di 0
 * @param mod
 * @param arg 
 */
    public void setPolar(double mod, double arg){
     if(mod>=0)
     {
        this.re = Math.cos(arg*Math.PI/180)*mod;
        if(arg == 180){
          this.im = Math.floor(Math.sin(arg*Math.PI/180)*mod);
        }
        if(arg%90 == 0 && arg%180 != 0){
            this.re = Math.floor(Math.cos(arg*Math.PI/180)*mod);
        }
        else{
         this.im = Math.sin(arg*Math.PI/180)*mod;
        }
         }
        
     
     else
     {
        throw new IllegalArgumentException("Il valore del modulo deve essere maggiore o uguale a 0");
     }
    }
    
    /**
     * Richiede le coordinate rettangolari di x e y
     * @param re
     * @param im 
     */
    public void setRectangular(double re, double im ){
        this.im=im;
        this.re=re;
        }
    
    /**
     * Restiutisce il valore del modulo
     * @return 
     */
    public double getModulus(){
        
        return(Math.sqrt(Math.pow(this.re,2)+Math.pow(this.im,2)));
    }
    
    /**
     * Restituisce il valore dell'argomento in (angoli sessagesimali)
     * @return 
     */
    public double getArgument(){
     int bugFix = 0;
     if(this.re  < 0){
     bugFix = 180;
    }
    return((Math.atan(this.im/this.re)*180)/Math.PI+bugFix);
    }
    
    /**
     * Restituisce il valore della parte Reale
     * @return 
     */  
    public double getRe() {
        return re;
    }
    
    /**
     * Restituisce il valore della parte Immaginaria
     * @return 
     */
    public double getIm() {
        return im;
    }
    
    public static ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber somma = new ComplexNumber();
        somma.re=operand1.getRe()+operand2.getRe();
        somma.im=operand1.getIm()+operand2.getIm();
        return somma;
    }
    
    public static ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber sottr = new ComplexNumber();
        sottr.re=operand1.getRe()-operand2.getRe();
        sottr.im=operand1.getIm()-operand2.getRe();
        return sottr;
    }
    
    public static ComplexNumber multiply(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber moltiplic = new ComplexNumber();
        moltiplic.setPolar(operand1.getArgument()+operand2.getArgument(), operand1.getModulus()*operand2.getModulus());
        return moltiplic;
    }
    
    public static ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber divisio = new ComplexNumber();
        divisio.setPolar(operand1.getArgument()/operand2.getModulus(), operand1.getArgument()-operand2.getArgument());
        return divisio;
    }
    
    public static ComplexNumber getConjugate(ComplexNumber operand){
        ComplexNumber con = new ComplexNumber();
        con=operand;
        con.im=-con.im;
        setInitRectangular(con.re,con.im);
        return con;
        
    }
    
    @Override
    
    public String toString()
    {
       String r = this.getRe() + "+(" + this.getIm() + ")i";
       return r;
    }
    

    @Override
	public boolean equals(Object re) {
        boolean ver = false;
	if(re instanceof ComplexNumber) {
        	ComplexNumber p = (ComplexNumber)re;
		if(this.re == p.getRe() && this.im == p.getIm()) {
		ver = true;
	 }
	}
		return ver;
	}

}

/*
        Nella classe non sono presenti metodi costruttori perchè essendo questa classe 
        una classe che gestisce numeri complessi sia attraverso le coordinate Cartesiane che
        quelle Polari, entrambi i metodi costruttori richiederebbero come parametri due valori 
        double e ,di conseguenza, non potendo esistere due metodi costruttori che richiedono lo stesso 
        numero di parametri con lo stesso tipo nello stesso ordine,ho deciso di non preferire nessuno
        dei duei metodi all'altro, l'utente così dovrà utilizzare semplicemente o il metodo setRectangular
        o il metodo setPolar per inizializzare lo stato dei campi.
    */