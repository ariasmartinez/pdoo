/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Celia Arias Martínez, Lucía Salamanca López
 */
public class PowerEfficientSpaceStation extends SpaceStation{
    
    private static final float EFFICIENCYFACTOR=1.10f; 
    
    public PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        Transformation trans = super.setLoot(loot);
        if (trans==Transformation.SPACECITY)
            return Transformation.NOTRANSFORM;
        else 
            return trans;      
    }
    
    @Override
    public PowerEfficientSpaceStationToUI getUIversion(){
         return new PowerEfficientSpaceStationToUI(this);
    }
    
    
}
