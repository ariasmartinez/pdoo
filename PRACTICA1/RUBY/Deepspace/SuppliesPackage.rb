class SuppliesPackage
  def initialize(ammoPower,fuelUnits,shieldPower)
    @ammoPower = ammoPower
    @fuelUnits = fuelUnits
    @shieldPower = shieldPower
  end

  def ammoPower
    @ammoPower
  end

  def fuelUnits
    @fuelUnits
  end

  def shieldPower
    @shieldPower
  end

  def self.newCopy(orig)
    new(orig.ammoPower, orig.fuelUnits, orig.shieldPower)
  end

end
