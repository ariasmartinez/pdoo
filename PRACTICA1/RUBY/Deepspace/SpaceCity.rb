#encoding:utf-8
module Deepspace
# @author Lucía Salamanca López, Celia Arias Martínez
class SpaceCity < SpaceStation
    def initialize(base, rest)   #base es SpaceStation original y rest es Array de SpaceStation (las demás estaciones)
        copy(base)
        @base = base #SpaceStation 
        @collaborators = rest #array de SpaceStation, queremos el puntero
    end 

    def collaborators 
        @collaborators
    end

    #no se si es con ammoPower o con fire
    def fire 
        suma = @base.ammoPower
        for f in collaborators
            suma+=f.ammoPower
        end
        return suma
    end 

    def protection
        suma = @base.shieldPower
        for pr in collaborators
            suma+=pr.shieldPower
        end 
        return suma
    end 

    def setLoot(loot)  #no se si hay que poner algo?

    end

    def to_s  #no se puede poner @base.super ?
        "La estación espacial original es \n" + @base.to_s + "\n y las estaciones espaciales colaboradoras son\n #{@collaborators.join("\n ")}."
    end
end 

end