class Weapon

  def initialize(name,type,uses)
    @name=name
    @type=type
    @uses=uses
  end

  def name
    @name
  end

  def type
    @type
  end

  def uses
    @uses
  end

  def self.newCopy
    copy=Weapon.new(self.name, self.type, self.uses)
    return copy
  end

  # No se si está bien pero gueno
  def power
    return Deepspace::WeaponType::type.power()
  end

  def uses=usos
    @uses=usos
  end

  def useIt

    if (uses > 0)
      uses=uses-1
      return power
    else
      return 1.0
    end

  end


end
