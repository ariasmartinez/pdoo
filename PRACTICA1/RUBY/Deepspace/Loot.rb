#encoding:utf-8
require './LootToUI'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class Loot

  def initialize (nSupplies,nWeapons,nShields,nHangars,nMedals)
    @nSupplies = nSupplies   #int
    @nWeapons = nWeapons    #int
    @nShields = nShields #int
    @nHangars = nHangars #int
    @nMedals = nMedals #int
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

  def to_s
    "El botín tiene "+@nSupplies.to_s+" suministros, "+@nWeapons.to_s+" armas, "+@nShields.to_s+" escudos, "+@nHangars.to_s+" hangares y "+@nMedals.to_s+" medallas"
  end
end

end
