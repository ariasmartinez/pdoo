#encoding:utf-8

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class Hangar

def initialize(capacity)
  @maxElements = capacity
  @weapons = Array.new
  @shieldBoosters = Array.new

end

def self.newCopy(h)
  new(h.maxElements)
end

def getUIversion
  HangarToUI.new(self)
end

def spaceAvailable()
  (@weapons.length + @shieldBoosters.length) < @maxElements
end

def addWeapon(w)
  if (spaceAvailable)
    @weapons << w
    return true
  else
    return false
  end
end

def addShieldBooster (s)
  if (spaceAvailable)
    @shieldBoosters << s
    return true
  else
    return false
  end
end

def maxElements
  @maxElements
end

def shieldBoosters
  @shieldBoosters
end

def weapons
  @weapons
end

def removeShieldBooster(s)
  if (@shieldBoosters[s] != nil)
    potenEscudo = @shieldBoosters[s]
    @shieldBoosters.delete_at(s)
    return potenEscudo
  else
    return nil
  end
end

def removeWeapon(w)
  if (@weapons[w] != nil)
    arma = @weapons[w]
    @weapons.delete_at(w)
    return arma
  else
    return nil
  end
end

# Esto lo he puesto igual que el HangarToUI
def to_s
  return "Max Elements: #{@maxElements}, Weapons: [#{@weapons.join(", ")}], Shields: [#{@shieldBoosters.join(", ")}]"
end

end
end
