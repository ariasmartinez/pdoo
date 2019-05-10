#encoding:utf-8

module Deepspace

require_relative "DamageToUI"

# @author Lucía Salamanca López, Celia Arias Martínez

class Damage

  def initialize(s)
    @nShields = s #int
  end

  def getUIversion
    DamageToUI.new(self)
  end

  
  def adjust(s)  #w es array de Weapons y s array de SHieldbooster
    if (nShields > s.length)
      shields = s.length
    else
      shields = nShields
    end
    return shields
  end
  

  def discardShieldBooster
    if (@nShields != 0)
      @nShields = @nShields-1
    end
  end

  def hasNoEffect
    return (nShields == 0)
  end

  def nShields
    @nShields
  end

  def to_s
   "El daño es #{@nShields} escudos, "
  end


end

end
