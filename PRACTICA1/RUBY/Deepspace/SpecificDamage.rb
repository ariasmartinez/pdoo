#encoding:utf-8

module Deepspace

require_relative "SpecificDamageToUI"

    # @author Lucía Salamanca López, Celia Arias Martínez
    
class SpecificDamage < Damage

    def initialize(t,s)  #s numero de shield, t array de weaponType
        @weapons = Array.new(t)
        super(s)
    end 

    def copy 
        SpecificDamage.new(@weapons, @nShields)
    end

    def getUIversion
        SpecificDamageToUI.new(self)
    end

    def arrayContainsType(w,t)   #w es array de Weapons y t de tipo WeaponType
        pos = -1
        cond = false
        i = 0
        while(cond == false and  i<w.length)
            if (w[i].type == t)
                pos = i
                cond = true
            end
            i+=1
        end
        return pos
    end


    def adjust(w,s)  #w es array de Weapons y s array de SHieldbooster
        shields = super(s)
        weapontype_prov = []
        for weap in w 
            weapontype_prov << weap;
        end 
        
        weapon_prov = []
        for i in @weapons
            pos = arrayContainsType(weapontype_prov,i)
            if (pos != -1)
                weapon_prov << i
                weapontype_prov.delete_at(pos)
            end
        end
        return SpecificDamage.new(weapon_prov,shields)
    end


    def discardWeapon(w)  
        @weapons.delete(w.type)
    end

    def hasNoEffect
        return ((@weapons.length == 0) && (super))
    end
   
    def weapons 
        @weapons
    end
   
    def to_s
        array = "la coleccion de armas"
        if (@weapons.length > 0)
            super + array + " es #{@weapons.join(", ")}"
        else
            super + array + " está vacía"
        end
    end
   
   
        end 

end