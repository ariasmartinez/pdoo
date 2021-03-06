/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
    * @author Lucía Salamanca López
    *         Celia Arias Martínez
 */
class ShieldBooster implements CombatElement{
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String nom, float b, int us){
        name = nom;
        boost = b;
        uses = us;
    }
    
    ShieldBooster(ShieldBooster otro){
        name = otro.name;
        boost = otro.boost;
        uses = otro.uses;
    }
    
    public float getBoost(){
        return boost;
    }
    
    @Override
    public int getUses(){
        return uses;
    }
    
    @Override
    public float useIt(){
        if (uses > 0){
            uses--;
            return boost;
        }
        return 1.0f;            
    }
    
    public String toString(){
        String mensaje = "El ShieldBooster se llama "+name+", tiene de potenciador "+boost+" y tiene "+uses+" usos.";
        return mensaje;
    }
    
    ShieldToUI getUIversion(){
       return new ShieldToUI(this); 
    }
}
