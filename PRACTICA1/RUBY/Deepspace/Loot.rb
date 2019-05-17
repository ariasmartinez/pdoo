#encoding:utf-8
require './LootToUI'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class Loot

  def initialize (nSupplies,nWeapons,nShields,nHangars,nMedals, ef=false, city=false)
    @nSupplies = nSupplies   #int
    @nWeapons = nWeapons    #int
    @nShields = nShields #int
    @nHangars = nHangars #int
    @nMedals = nMedals #int
    @efficient = ef  #boolean
    @spaceCity = city  #boolean
  end

  def getUIversion
    LootToUI.new(self)
  end

  def nSupplies
    @nSupplies
  end

  def nWeapons
    @nWeapons
  end

  def nShields
    @nShields
  end

  def nHangars
    @nHangars
  end

  def nMedals
    @nMedals
  end

  def efficient
    @efficient
  end

  def spaceCity
    @spaceCity
  end 

  def to_s
    return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nHangars}, Get Efficient: #{@efficient}, Space City: #{@spaceCity}"
  end
end

end
