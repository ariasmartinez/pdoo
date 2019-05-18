#encoding:utf-8
require './BetaPowerEfficientSpaceStationToUI.rb'
module Deepspace


    # @author Lucía Salamanca López, Celia Arias Martínez
class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
    @EXTRAEFFICIENCY=1.2  #float, atributo de instancia de la clase

    def initialize(estacion)  #SpaceStation
        copy(estacion)
    end 

    def fire   #devuelve un float
        if (@dice.extraEfficient)
            return super*self.class.extraefficiency
        else
            return super 
        end
    end

    def self.extraefficiency
        @EXTRAEFFICIENCY
    end

    def getUIversion
        BetaPowerEfficientSpaceStationToUI.new(self)
    end

    def  to_s 
        out = "Estación espacial eficiente beta: "
        out+= super
    end
end 
end