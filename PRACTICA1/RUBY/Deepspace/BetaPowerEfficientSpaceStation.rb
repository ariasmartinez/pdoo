#encoding:utf-8
require './BetaPowerEfficientSpaceStation.rb'
module Deepspace


    # @author Lucía Salamanca López, Celia Arias Martínez
class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
    @EXTRAEFFICIENCY=1.2  #float, atributo de instancia de la clase

    def initialize(estacion)  #SpaceStation
        super
    end 

    #mirar que funciona
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
end 
end