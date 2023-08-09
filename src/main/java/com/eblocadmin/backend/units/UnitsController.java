package com.eblocadmin.backend.units;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.entity.UnitInfo;
import com.eblocadmin.backend.units.entity.UnitInventory;
import com.eblocadmin.backend.units.entity.UnitLink;

@RestController
@RequestMapping(value = "/api/units")
public class UnitsController {

	private UnitsService unitsService;

	public UnitsController(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	@GetMapping(value="/retrieveAllUnit")
	public List<Unit> retrieveAllUnit() {
		return unitsService.retrieveAllUnit();
	}

	@GetMapping(value="/retrieveSpecificUnitByEbaId")
	public List<Unit> retrieveSpecificUnitByEbaId(Unit unit) {
		return unitsService.retrieveSpecificUnitByEbaId(unit);
	}

	@PostMapping(value="/insertUnit")
	public void insertUnit(Unit unit) {
		unitsService.insertUnit(unit);
	}

	@PostMapping(value="/deleteSpecificUnitByEbaId")
	public void deleteSpecificUnitByEbaId(Unit unit) {
		unitsService.deleteSpecificUnitByEbaId(unit);
	}

	@GetMapping(value="/retrieveAllUnitInfo")
	public List<UnitInfo> retrieveAllUnitInfo() {
		return unitsService.retrieveAllUnitInfo();
	}

	@GetMapping(value="/retrieveSpecificUnitInfoByUnitId")
	public List<UnitInfo> retrieveSpecificUnitInfoByUnitId(UnitInfo unitInfo) {
		return unitsService.retrieveSpecificUnitInfoByUnitId(unitInfo);
	}

	@PostMapping(value="/insertUnitInfo")
	public void insertUnitInfo(UnitInfo unitInfo) {
		unitsService.insertUnitInfo(unitInfo);
	}

	@PostMapping(value="/deleteSpecificUnitInfoByUnitId")
	public void deleteSpecificUnitInfoByUnitId(UnitInfo unitInfo) {
		unitsService.deleteSpecificUnitInfoByUnitId(unitInfo);
	}

	@GetMapping(value="/retrieveAllUnitInventory")
	public List<UnitInventory> retrieveAllUnitInventory() {
		return unitsService.retrieveAllUnitInventory();
	}

	@GetMapping(value="/retrieveSpecificUnitInventoryByUnitId")
	public List<UnitInventory> retrieveSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {
		return unitsService.retrieveSpecificUnitInventoryByUnitId(unitInventory);
	}

	@PostMapping(value="/insertUnitInventory")
	public void insertUnitInventory(UnitInventory unitInventory) {
		unitsService.insertUnitInventory(unitInventory);
	}

	@PostMapping(value="/deleteSpecificUnitInventoryByUnitId")
	public void deleteSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {
		unitsService.deleteSpecificUnitInventoryByUnitId(unitInventory);
	}

	@GetMapping(value="/retrieveAllUnitLink")
	public List<UnitLink> retrieveAllUnitLink() {
		return unitsService.retrieveAllUnitLink();
	}

	@GetMapping(value="/retrieveSpecificUnitLinkByEbaId")
	public List<UnitLink> retrieveSpecificUnitLinkByEbaId(UnitLink unitLink) {
		return unitsService.retrieveSpecificUnitLinkByEbaId(unitLink);
	}

	@PostMapping(value="/insertUnitLink")
	public void insertUnitLink(UnitLink unitLink) {
		unitsService.insertUnitLink(unitLink);
	}

	@PostMapping(value="/deleteSpecificUnitLinkByEbaId")
	public void deleteSpecificUnitLinkByEbaId(UnitLink unitLink) {
		unitsService.deleteSpecificUnitLinkByEbaId(unitLink);
	}

}
