#encoding:utf-8
require './LootToUI'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class Loot

  def initialize (nSupplies,nWeapons,nShields,nHangars,nMedals, getEfficient=false, spaceCity=false)
    @nSupplies = nSupplies   #int
    @nWeapons = nWeapons    #int
    @nShields = nShields #int
    @nHangars = nHangars #int
    @nMedals = nMedals #int
    @efficient = getEfficient  #boolean
    @spaceCity = spaceCity  #boolean
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
    "El botín tiene "+@nSupplies.to_s+" suministros, "+@nWeapons.to_s+" armas, "+@nShields.to_s+" escudos, "+@nHangars.to_s+" hangares "+@nMedals.to_s+" medallas, valor de eficiencia "+@getEfficient.to_s  + " y opción de convertirse en una ciudad espacial "+@spaceCity.to_s+"."
  end
end

end
