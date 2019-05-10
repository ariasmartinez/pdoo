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

    def fire 

    end 

    def protection

    end 

    def setLoot(loot)

    end
end 

end