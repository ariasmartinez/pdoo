#encoding:utf-8

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class ShieldBooster
  def initialize(name,boost,uses)
    @name = name #string
    @boost = boost #float
    @uses = uses #int
  end

  def name
    @name
  end

  def boost
    @boost
  end

  def uses
    @uses
  end

  def self.newCopy(orig)
    new(orig.name, orig.boost, orig.uses)
  end




  #pongo el @ antes de los atributos
  def useIt

    if (@uses > 0)
      @uses = @uses -1
      return @boost
    else
      return 1.0
    end

  end

end

end
