#encoding:utf-8
require './SpaceCityToUI'
module Deepspace
# @author Lucía Salamanca López, Celia Arias Martínez
class SpaceCity < SpaceStation
    def initialize(base, rest)   #base es SpaceStation original y rest es Array de SpaceStation (las demás estaciones)
        copy(base)  
        @collaborators = rest #array de SpaceStation, queremos el puntero
    end 

    def collaborators 
        @collaborators
    end

    
    def fire 
        suma = super.fire   #creo que es lo mismo que super.fire
        for f in collaborators
            suma+=f.fire
        end
        return suma
    end 

    
    def protection
        suma = super.protection  #creo que es lo mismo que super.protection
        for pr in collaborators
            suma+=pr.protection
        end
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
        "La estación espacial original es \n" + super.to_s + "\n y las estaciones espaciales colaboradoras son\n #{@collaborators.join("\n ")}."
    end
end 

end