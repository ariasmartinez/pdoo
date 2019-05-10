
#encoding:utf-8

module Deepspace

require_relative "NumericDamageToUI"
        
        # @author Lucía Salamanca López, Celia Arias Martínez
        
class NumericDamage < Damage
    def initialize(n,s)  #n numero de weapons, s numero de shield
        super(s)
        @nWeapons = n
    end

    def copy
        NumericDamage.new(@nWeapons, @nShields)
    end

    def getUIversion
        NumericDamageToUI.new(self)
    end

    def adjust(w,s)  #w es array de weapons, s array de shieldbooster
        shields = super(s)
        if (@nWeapons > w.length)
            return NumericDamage.new(w.length,shields)
        else
            return NumericDamage.new(@nWeapons,shields)
        end
    end

    def discardWeapon(w)
        if (@nWeapons > 0)
            @nWeapons = @nWeapons-1
        end
    end

    def hasNoEffect
        return ((@nWeapons == 0) && (super))
    end

    def nWeapons
        @nWeapons
    end

    def to_s
        super + "#{@nWeapons} armas."  
    end
end

end