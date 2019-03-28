#encoding:utf-8

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
module WeaponType
  class Type
    def initialize(power)
      @power = power
    end

    def power
      @power
    end
    
    def to_s
      if (power == 2)
        return "LASER"
      elsif (power == 3)
        return "MISSILE"
      else 
        return "PLASMA"
      end 
    end 
    
  end

  LASER = Type.new(2.0)
  MISSILE = Type.new(3.0)
  PLASMA = Type.new(4.0)




end
end
