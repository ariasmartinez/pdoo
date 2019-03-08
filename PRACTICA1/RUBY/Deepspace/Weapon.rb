class Weapon

  def initialize(name,type,uses)
    @name=name #string
    @type=type #WeaponType
    @uses=uses #int
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

  def self.newCopy(orig)
    new(orig.name, orig.type, orig.uses)
  end


  def power
    @type.power()
  end



  def useIt

    if (@uses > 0)
      @uses=@uses-1
      return power
    else
      return 1.0
    end

  end


end
