#encoding:utf-8
require './SpaceCityToUI'
module Deepspace
# @author Lucía Salamanca López, Celia Arias Martínez
class SpaceCity < SpaceStation
    def initialize(base, rest)   #base es SpaceStation original y rest es Array de SpaceStation (las demás estaciones)
        

        copy(base)
        @base=base
        @collaborators=Array.new
        rest.each{|station|
            if station.name != base.name
            @collaborators << station
            end
        }
    
    end 

    def collaborators 
        @collaborators
    end

    
    def fire 
         
        suma = @base.fire
        @collaborators.each{ |f| 
            suma+=f.fire
        }
        return suma
    end 

    
    def protection
        suma = super  
        @collaborators.each{ |pr|
            suma+=pr.protection
        }
        return suma
    end 

    def setLoot(loot)  
        super
        return Transformation::NOTRANSFORM
    end

    def getUIversion
        SpaceCityToUI.new(self)
    end

    def to_s  
        "La estación espacial original es \n" + super + "\n y las estaciones espaciales colaboradoras son\n #{@collaborators.join("\n ")}."
    end
end 

end