package com.eblocadmin.backend.units;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.entity.UnitInfo;
import com.eblocadmin.backend.units.entity.UnitInventory;
import com.eblocadmin.backend.units.entity.UnitLink;
import com.eblocadmin.backend.units.repository.UnitsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UnitsService {

	private UnitsRepository unitsRepository;

	public UnitsService(UnitsRepository unitsRepository) {
		this.unitsRepository = unitsRepository;
	}

	// Retrieve all data from eba_units_details table
	public List<Unit> retrieveAllUnit() {
		return unitsRepository.retrieveAllUnit();
	}

	// Retrieve specific data from eba_units_details table
	public List<Unit> retrieveSpecificUnitByEbaId(Unit unit) {
		return unitsRepository.retrieveSpecificUnitByEbaId(unit);
	}

	// Insert all units in eba_units_details table
	public void insertUnit(Unit unit) {
		unitsRepository.insertUnit(unit);
	}

	// Delete a unit row from eba_units_details
	public void deleteSpecificUnitByEbaId(Unit unit) {
		unitsRepository.deleteSpecificUnitByEbaId(unit);
	}

	// Retrieve all data from eba_units_info table
	public List<UnitInfo> retrieveAllUnitInfo() {
		return unitsRepository.retrieveAllUnitInfo();
	}

	// Retrieve specific data from eba_units_info table
	public List<UnitInfo> retrieveSpecificUnitInfoByUnitId(UnitInfo unitInfo) {
		return unitsRepository.retrieveSpecificUnitInfoByUnitId(unitInfo);
	}

	// Insert all unit info in eba_units_info table
	public void insertUnitInfo(UnitInfo unitInfo) {
		unitsRepository.insertUnitInfo(unitInfo);
	}

	// Delete a unitInfo row from eba_units_info
	public void deleteSpecificUnitInfoByUnitId(UnitInfo unitInfo) {
		unitsRepository.deleteSpecificUnitInfoByUnitId(unitInfo);
	}

	// Retrieve all data from eba_units_inventory table
	public List<UnitInventory> retrieveAllUnitInventory() {
		return unitsRepository.retrieveAllUnitInventory();
	}

	// Retrieve specific data from eba_units_inventory table
	public List<UnitInventory> retrieveSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {
		return unitsRepository.retrieveSpecificUnitInventoryByUnitId(unitInventory);
	}

	// Insert all unit inventories in eba_units_inventory table
	public void insertUnitInventory(UnitInventory unitInventory) {
		unitsRepository.insertUnitInventory(unitInventory);
	}

	// Delete a unitInventory row from eba_units_inventory
	public void deleteSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {
		unitsRepository.deleteSpecificUnitInventoryByUnitId(unitInventory);
	}

	// Retrieve all data from eba_units_link table
	public List<UnitLink> retrieveAllUnitLink() {
		return unitsRepository.retrieveAllUnitLink();
	}

	// Retrieve specific data from eba_units_link table
	public List<UnitLink> retrieveSpecificUnitLinkByEbaId(UnitLink unitLink) {
		return unitsRepository.retrieveSpecificUnitLinkByEbaId(unitLink);
	}

	// Insert all unit links in eba_units_link table
	public void insertUnitLink(UnitLink unitLink) {
		unitsRepository.insertUnitLink(unitLink);
	}

	// Delete a unitInventory row from eba_units_inventory
	public void deleteSpecificUnitLinkByEbaId(UnitLink unitLink) {
		unitsRepository.deleteSpecificUnitLinkByEbaId(unitLink);
	}
}
