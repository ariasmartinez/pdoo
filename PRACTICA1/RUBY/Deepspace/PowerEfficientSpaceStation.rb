#encoding:utf-8
require './PowerEfficientSpaceStation'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class PowerEfficientSpaceStation < SpaceStation
    @EFFICIENCYFACTOR = 1.1 #float  #poner como atributo de instancia de la clase?
    def initialize(estacion)  #SpaceStation
        copy(estacion)   #mirar
    end
    
    def setLoot(loot)  #mirar si hay que poner algo

    end

    #mirar
    def fire 
        return PowerEfficientSpaceStation*super
    end
    #mirar
    def protection 
        return PowerEfficientSpaceStation*super
    end

    def self.efficiencyFactor 
        @EFFICIENCYFACTOR
    end

end 
end