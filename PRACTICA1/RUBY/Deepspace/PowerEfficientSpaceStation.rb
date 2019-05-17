#encoding:utf-8
require './PowerEfficientSpaceStationToUI'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class PowerEfficientSpaceStation < SpaceStation
    @EFFICIENCYFACTOR = 1.1 #float  #poner como atributo de instancia de la clase?
    def initialize(estacion)  #SpaceStation
        copy(estacion)   #mirar
    end
    
    def setLoot(loot)  #mirar si hay que poner algo
        super 
        if loot.efficient 
            return Transformation::GETEFFICIENT
        else
            return Transformation::NOTRANSFORM
        end
    end

    #mirar
    def fire    #devuelve un float
        return PowerEfficientSpaceStation.efficiencyFactor*super
    end
    #mirar
    def protection 
        return PowerEfficientSpaceStation.efficiencyFactor*super
    end

    def self.efficiencyFactor 
        @EFFICIENCYFACTOR
    end

    def getUIversion
        PowerEfficientSpaceStationToUI.new(self)
      end

    def to_s
        out = "Estación espacial eficiente: "
        out += super
    end

end 
end