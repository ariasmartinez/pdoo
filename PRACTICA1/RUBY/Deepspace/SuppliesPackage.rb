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
  # ni puta idea de si es así
  def self.newCopy
    new(self.ammoPower, self.fuelUnits, self.shieldPower)
  end

end
