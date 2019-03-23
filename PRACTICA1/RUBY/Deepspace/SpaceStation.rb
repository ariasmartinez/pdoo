class SpaceStation
  @@MAXFUEL = 100
  @@SHIELDLOSSPERUNITSHOT = 0.1

 # las medallas como coño se saben
  def initialize(n, supplies)
    @ammoPower = supplies.ammoPower
    @fuelUnits = supplies.fuelUnits
    @name = n
    @nMedals
    @shieldPower = supplies.shieldPower
    @hangar = nil # ???
    @pendingDamage = nil # ???
    @shieldBoosters = Array.new
    @weapons = Array.new
  end

  def assignFuelValue(f)
    if (f <= @@MAXFUEL)
      @fuelUnits = f
    end
  end

  def cleanPendingDamage
    if (pendingDamage.hasNoEffect)
      @pendingDamage = nil
    end
  end

# SI PETA ES ESTO
  def cleanUpMountedItems
    for w in weapons do
      if (w.uses == 0)
        @weapons.delete(w)
      end
    end

    for sb in shieldBoosters do
      if (sb.uses == 0)
        @shieldBoosters.delete(w)
      end
    end
  end

  def discardHangar
    @hangar = nil
  end

  def discardShieldBooster(i)
    #siguiente práctica
  end

  def discardShieldBoosterinHangar(i)
    if (@hangar != nil)
      @hangar.removeShieldBooster(i)
  end

  def discardWeapon(i)
    #siguiente práctica
  end

  def discardWeaponinHangar(i)
    if (@hangar != nil)
      @hangar.removeWeapon(i)
  end

  def fire
    #práctica siguiente
  end

  def ammoPower
    @ammoPower
  end

  def fuelUnits
    @fuelUnits
  end

  def hangar
    @hangar
  end

  def name
    @name
  end

  def nMedals
    @nMedals
  end

  def pendingDamage
    @pendingDamage
  end

  def shieldBoosters
    @shieldBoosters
  end

  def shieldPower
    @shieldPower
  end

  def getSpeed
    fuelUnits/@@MAXFUEL
  end

  def getUIversion
    SpaceStationToUI.new(self)
  end

  def weapons
    @weapons
  end

  def mountShieldBooster(i)
    if (hangar != nil)
      potenEscudo= @hangar.removeShieldBooster(i)
      if (potenEscudo != nil)
        @shieldBoosters << potenEscudo
      end
    end
  end

  def mountWeapon(i)
    if (hangar != nil)
      arma = @hangar.removeWeapon(i)
      if (arma != nil)
        @weapons << arma
      end
    end
  end

  def move
    if ((fuelUnits - getSpeed) > 0)
      @fuelUnits = fuelUnits-getSpeed()
    else
      @fuelUnits = 0
    end
  end

  def protection
    #siguiente práctica
  end

  def receiveHangar(h)
    if (hangar == nil)
      @hangar = h
    end
  end

  def receiveShieldBooster(s)
    if (hangar != nil)
      return @hangar.addShieldBooster(s)
    else
      return false
    end
  end

  def receiveShot(shot)
    #siguiente práctica
  end

  def receiveSupplies(s)
    @fuelUnits += s.fuelUnits
    @ammoPower += s.ammoPower
    @shieldPower += s.shieldPower
  end

  def receiveWeapon(w)
    if (hangar != nil)
      return @hangar.addWeapon(w)
    else
      return false
    end
  end

  def setLoot(loot)
    # Siguiente práctica
  end

  def setPendingDamage(d)
    @pendingDamage = d.adjust(weapons, shieldBoosters)
  end

  def validState
    cleanPendingDamage
    if (@pendingDamage != nil)
        return true
    else
      false
    end
  end

  def to_s
    out="Space Station - Name: #{@name}\n"
    out+="\tnMedals: #{@nMedals}, Fuel units: #{@fuelUnits.round(2)}, Power: #{@ammoPower}, Shields: #{@shieldPower}\n"
    out+="\tWeapons: [#{@weapons.join(', ')}]\n"
    out+="\tShieldBooster: [#{@shieldBoosters.join(', ')}]\n"
    out+="\tHangars: #{@hangar}\n"
    out+="\tPendingDamage: #{@pendingDamage}\n"
    out+="------- end of Space Station >> #{@name} << -------"
    return out
  end
end
