/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Celia Arias Martínez, Lucía Salamanca López
 */
public class SpaceCity extends SpaceStation{
    
    private ArrayList<SpaceStation> collaborators=new ArrayList<>();
    private SpaceStation base;
    
    
    public SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        for (SpaceStation s : rest) {
         collaborators.add(new SpaceStation(s));
        }
        base = base;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    @Override
    public float fire(){
        float factor = super.fire();
        for (int i=0; i<collaborators.size();i++)
            factor+=collaborators.get(i).fire();
        
        return factor;
    }
    
    @Override
    public float protection(){
        float factor = super.protection();
        for (int i=0; i<collaborators.size();i++)
            factor+=collaborators.get(i).protection();
        
        return factor;
        
        
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        Transformation trans = Transformation.NOTRANSFORM;
        return trans;
    }
    
    @Override
    public SpaceCityToUI getUIversion(){
         return new SpaceCityToUI(this);
    }
    
}
