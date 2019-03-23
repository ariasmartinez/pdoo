class Damage

def initialize(w,s)
  @nShields = s
  @nWeapons = w
end

def self.newNumericWeapons()

end

def self.newSpecificWeapons(wl,s)

end

def self.newCopy(d)
  new(d.nWeapons, d.nShields)
end

def getUIversion
  DamageToUI.new(self)
end

def arrayContainsType(w,t)

end

def adjust(w,s)

end

def discardWeapon(w)

end

def discardShieldBooster

end

def hasNoEffect

end

def nShields
  @nShields
end

def getNWeapons
  @nWeapons
end

def getWeapons

end

def to_s

end

end
