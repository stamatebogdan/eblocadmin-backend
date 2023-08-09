package com.eblocadmin.backend.units.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eblocadmin.backend.dbconnection.config.PostgresDataSourceConfig;
import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.entity.UnitInfo;
import com.eblocadmin.backend.units.entity.UnitInventory;
import com.eblocadmin.backend.units.entity.UnitLink;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UnitsRepository {

	private final PostgresDataSourceConfig postgresDataSourceConfig;

	public UnitsRepository(PostgresDataSourceConfig postgresDataSourceConfig) {
		this.postgresDataSourceConfig = postgresDataSourceConfig;
	}

	// Retrieve all data from eba_units_details table
	public List<Unit> retrieveAllUnit() {

		List<Unit> unitList = new ArrayList<>();

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		String select = "SELECT * FROM units_group.eba_units_details";

		unitList = postgresNamedParameterJdbcTemplate.query(select, new UnitRowMapper());

		return unitList;
	}

	// Retrieve specific data from eba_units_details table
	public List<Unit> retrieveSpecificUnitByEbaId(Unit unit) {

		List<Unit> unitList = new ArrayList<>();

		String searchQuery = "SELECT * FROM units_group.eba_units_details WHERE eba_id = :ebaId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", unit.getEbaId());

		unitList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter, new UnitRowMapper());

		return unitList;
	}

	// Insert all units in eba_units_details table
	public void insertUnit(Unit unit) {

		String insertQueryString = "INSERT INTO units_group.eba_units_details(unit_name, unit_type, "
				+ "eba_owner_id, eba_tenant_id, unit_street, unit_street_number, unit_block, "
				+ "unit_entrance, unit_floor, unit_apart_number, unit_postal_code, unit_region, unit_city, "
				+ "unit_country, unit_rooms, unit_bathrooms, unit_useful_area, unit_constructed_area, "
				+ "unit_land_area, unit_construction_date, unit_purchase_price, unit_market_value, "
				+ "unit_parking_spot, unit_additional_note, unit_useful_links, inserted_date, last_change_date) "
				+ "	VALUES (:unit_name, :unit_type, :eba_owner_id, :eba_tenant_id, :unit_street, "
				+ ":unit_street_number, :unit_block, :unit_entrance, :unit_floor, :unit_apart_number, "
				+ ":unit_postal_code, :unit_region, :unit_city, :unit_country, :unit_rooms, "
				+ ":unit_bathrooms, :unit_useful_area, :unit_constructed_area, :unit_land_area, "
				+ ":unit_construction_date, :unit_purchase_price, :unit_market_value, "
				+ ":unit_parking_spot, :unit_additional_note, :unit_useful_links, "
				+ ":inserted_date, :last_change_date);";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("unit_name", unit.getUnitName());
		parameters.addValue("unit_type", unit.getUnitType());
		parameters.addValue("eba_owner_id", unit.getOwnerId());
		parameters.addValue("eba_tenant_id", unit.getTenantId());
		parameters.addValue("unit_street", unit.getUnitStreet());
		parameters.addValue("unit_street_number", unit.getUnitStreetNumber());
		parameters.addValue("unit_block", unit.getUnitBlock());
		parameters.addValue("unit_entrance", unit.getUnitEntrance());
		parameters.addValue("unit_floor", unit.getUnitFloor());
		parameters.addValue("unit_apart_number", unit.getUnitApartNumber());
		parameters.addValue("unit_postal_code", unit.getUnitPostalCode());
		parameters.addValue("unit_region", unit.getUnitRegion());
		parameters.addValue("unit_city", unit.getUnitCity());
		parameters.addValue("unit_country", unit.getUnitCountry());
		parameters.addValue("unit_rooms", unit.getUnitRoom());
		parameters.addValue("unit_bathrooms", unit.getUnitBathrooms());
		parameters.addValue("unit_useful_area", unit.getUnitUsefulArea());
		parameters.addValue("unit_constructed_area", unit.getUnitConstructedArea());
		parameters.addValue("unit_land_area", unit.getUnitLandArea());
		parameters.addValue("unit_construction_date", unit.getUnitConstructionDate());
		parameters.addValue("unit_purchase_price", unit.getUnitPurchasePrice());
		parameters.addValue("unit_market_value", unit.getUnitMarketValue());
		parameters.addValue("unit_parking_spot", unit.getUnitParkingSpot());
		parameters.addValue("unit_additional_note", unit.getUnitAdditionalNote());
		parameters.addValue("unit_useful_links", unit.getUnitUsefulLinks());
		parameters.addValue("inserted_date", LocalDateTime.now());
		parameters.addValue("last_change_date", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		postgresNamedParameterJdbcTemplate.update(insertQueryString, parameters);

	}

	// Delete a unit row from eba_units_details
	public void deleteSpecificUnitByEbaId(Unit unit) {

		String deleteQuery = "DELETE FROM units_group.eba_units_details WHERE eba_id = :ebaId;";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", unit.getEbaId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}

	// Retrieve all data from eba_units_info table
	public List<UnitInfo> retrieveAllUnitInfo() {

		List<UnitInfo> unitInfoList = new ArrayList<>();

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		String select = "SELECT * FROM units_group.eba_units_info";

		unitInfoList = postgresNamedParameterJdbcTemplate.query(select, new UnitInfoRowMapper());

		return unitInfoList;
	}

	// Retrieve specific data from eba_units_info table
	public List<UnitInfo> retrieveSpecificUnitInfoByUnitId(UnitInfo unitInfo) {

		List<UnitInfo> unitInfoList = new ArrayList<>();

		String searchQuery = "SELECT * FROM units_group.eba_units_info WHERE unit_id = :unitId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("unitId", unitInfo.getUnitId());

		unitInfoList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter, new UnitInfoRowMapper());

		return unitInfoList;
	}

	// Insert all unit info in eba_units_info table
	public void insertUnitInfo(UnitInfo unitInfo) {

		String insertQuery = "INSERT INTO units_group.eba_units_info(unit_id, unit_name, "
				+ "unit_purchase_price, unit_warranty, unit_warranty_due_date, unit_notes, "
				+ "unit_photo_1, unit_photo_2, unit_photo_3, unit_photo_4, unit_photo_5, "
				+ "unit_photo_6, unit_photo_7, unit_photo_8, unit_photo_9, unit_photo_10, "
				+ "unit_document_1, unit_document_2, unit_document_3, unit_document_4, "
				+ "unit_document_5, unit_document_6, unit_document_7, unit_document_8, "
				+ "unit_document_9, unit_document_10, inserted_date, last_change_date) "
				+ "VALUES (:unit_id, :unit_name, :unit_purchase_price, :unit_warranty, "
				+ ":unit_warranty_due_date, :unit_notes, :unit_photo_1, :unit_photo_2, "
				+ ":unit_photo_3, :unit_photo_4, :unit_photo_5, :unit_photo_6, :unit_photo_7, "
				+ ":unit_photo_8, :unit_photo_9, :unit_photo_10, "
				+ ":unit_document_1, :unit_document_2, :unit_document_3, :unit_document_4, "
				+ ":unit_document_5, :unit_document_6, :unit_document_7, :unit_document_8, "
				+ ":unit_document_9, :unit_document_10, :inserted_date, :last_change_date);";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("unit_id", unitInfo.getUnitId());
		parameters.addValue("unit_name", unitInfo.getUnitName());
		parameters.addValue("unit_purchase_price", unitInfo.getUnitPurchasePrice());
		parameters.addValue("unit_warranty", unitInfo.getUnitWarranty());
		parameters.addValue("unit_warranty_due_date", unitInfo.getUnitWarrantyDueDate());
		parameters.addValue("unit_notes", unitInfo.getUnitNotes());
		parameters.addValue("unit_photo_1", unitInfo.getUnitPhoto1());
		parameters.addValue("unit_photo_2", unitInfo.getUnitPhoto2());
		parameters.addValue("unit_photo_3", unitInfo.getUnitPhoto3());
		parameters.addValue("unit_photo_4", unitInfo.getUnitPhoto4());
		parameters.addValue("unit_photo_5", unitInfo.getUnitPhoto5());
		parameters.addValue("unit_photo_6", unitInfo.getUnitPhoto6());
		parameters.addValue("unit_photo_7", unitInfo.getUnitPhoto7());
		parameters.addValue("unit_photo_8", unitInfo.getUnitPhoto8());
		parameters.addValue("unit_photo_9", unitInfo.getUnitPhoto9());
		parameters.addValue("unit_photo_10", unitInfo.getUnitPhoto10());
		parameters.addValue("unit_document_1", unitInfo.getUnitDocument1());
		parameters.addValue("unit_document_2", unitInfo.getUnitDocument2());
		parameters.addValue("unit_document_3", unitInfo.getUnitDocument3());
		parameters.addValue("unit_document_4", unitInfo.getUnitDocument4());
		parameters.addValue("unit_document_5", unitInfo.getUnitDocument5());
		parameters.addValue("unit_document_6", unitInfo.getUnitDocument6());
		parameters.addValue("unit_document_7", unitInfo.getUnitDocument7());
		parameters.addValue("unit_document_8", unitInfo.getUnitDocument8());
		parameters.addValue("unit_document_9", unitInfo.getUnitDocument9());
		parameters.addValue("unit_document_10", unitInfo.getUnitDocument10());
		parameters.addValue("inserted_date", LocalDateTime.now());
		parameters.addValue("last_change_date", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		postgresNamedParameterJdbcTemplate.update(insertQuery, parameters);

	}

	// Delete a unitInfo row from eba_units_info
	public void deleteSpecificUnitInfoByUnitId(UnitInfo unitInfo) {

		String deleteQuery = "DELETE FROM units_group.eba_units_info WHERE unit_id = :unitId;";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("unitId", unitInfo.getUnitId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}

	// Retrieve all data from eba_units_inventory table
	public List<UnitInventory> retrieveAllUnitInventory() {

		List<UnitInventory> unitInventoryList = new ArrayList<>();

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		String select = "SELECT * FROM units_group.eba_units_inventory";

		unitInventoryList = postgresNamedParameterJdbcTemplate.query(select, new UnitInventoryRowMapper());

		return unitInventoryList;
	}

	// Retrieve specific data from eba_units_inventory table
	public List<UnitInventory> retrieveSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {

		List<UnitInventory> unitInventoryList = new ArrayList<>();

		String searchQuery = "SELECT * FROM units_group.eba_units_inventory WHERE unit_id = :unitId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("unitId", unitInventory.getUnitId());

		unitInventoryList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter,
				new UnitInventoryRowMapper());

		return unitInventoryList;
	}

	// Insert all unit inventories in eba_units_inventory table
	public void insertUnitInventory(UnitInventory unitInventory) {

		String insertQuery = "INSERT INTO units_group.eba_units_inventory(unit_id, unit_name, air_conditioner, smoke_detector, "
				+ "gas_oven, electric_oven, microwave_oven, electric_stove, thermal_plant, "
				+ "water_meter, wifi, refrigerator, vacuum_cleaner, mop, couch, bed, mattress, "
				+ "inserted_date, last_change_date) "
				+ "VALUES (:unit_id, :unit_name, :air_conditioner, :smoke_detector, :gas_oven, :electric_oven, "
				+ ":microwave_oven, :electric_stove, :thermal_plant, :water_meter, :wifi, :refrigerator, "
				+ ":vacuum_cleaner, :mop, :couch, :bed, :mattress, :inserted_date, :last_change_date);";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("unit_id", unitInventory.getUnitId());
		parameters.addValue("unit_name", unitInventory.getUnitName());
		parameters.addValue("air_conditioner", unitInventory.getAirConditioner());
		parameters.addValue("smoke_detector", unitInventory.getSmokeDetector());
		parameters.addValue("gas_oven", unitInventory.getGasOven());
		parameters.addValue("electric_oven", unitInventory.getElectricOven());
		parameters.addValue("microwave_oven", unitInventory.getMicrowaveOven());
		parameters.addValue("electric_stove", unitInventory.getElectricStove());
		parameters.addValue("thermal_plant", unitInventory.getThermalPlant());
		parameters.addValue("water_meter", unitInventory.getWaterMeter());
		parameters.addValue("wifi", unitInventory.getWifi());
		parameters.addValue("refrigerator", unitInventory.getRefrigerator());
		parameters.addValue("vacuum_cleaner", unitInventory.getVacuumCleaner());
		parameters.addValue("mop", unitInventory.getMop());
		parameters.addValue("couch", unitInventory.getCouch());
		parameters.addValue("bed", unitInventory.getBed());
		parameters.addValue("mattress", unitInventory.getMattress());
		parameters.addValue("inserted_date", LocalDateTime.now());
		parameters.addValue("last_change_date", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		postgresNamedParameterJdbcTemplate.update(insertQuery, parameters);

	}

	// Delete a unitInventory row from eba_units_inventory
	public void deleteSpecificUnitInventoryByUnitId(UnitInventory unitInventory) {

		String deleteQuery = "DELETE FROM units_group.eba_units_inventory WHERE unit_id = :unitId;";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("unitId", unitInventory.getUnitId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}

	// Retrieve all data from eba_units_link table
	public List<UnitLink> retrieveAllUnitLink() {

		List<UnitLink> unitLinkList = new ArrayList<>();

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		String select = "SELECT * FROM units_group.eba_units_link";

		unitLinkList = postgresNamedParameterJdbcTemplate.query(select, new UnitLinkRowMapper());

		return unitLinkList;
	}

	// Retrieve specific data from eba_units_link table
	public List<UnitLink> retrieveSpecificUnitLinkByEbaId(UnitLink unitLink) {

		List<UnitLink> unitLinkList = new ArrayList<>();

		String searchQuery = "SELECT * FROM units_group.eba_units_link WHERE eba_id = :ebaId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", unitLink.getEbaId());

		unitLinkList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter, new UnitLinkRowMapper());

		return unitLinkList;
	}

	// Insert all unit links in eba_units_link table
	public void insertUnitLink(UnitLink unitLink) {

		String insertQuery = "INSERT INTO units_group.eba_units_link("
				+ "eba_primary_unit_id, eba_primary_unit_name, eba_secondary_unit_id, "
				+ "eba_secondary_unit_name, inserted_date, last_change_date) "
				+ "VALUES (:eba_primary_unit_id, :eba_primary_unit_name, :eba_secondary_unit_id, "
				+ ":eba_secondary_unit_name, :inserted_date, :last_change_date);";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("eba_primary_unit_id", unitLink.getEbaPrimaryUnitId());
		parameters.addValue("eba_primary_unit_name", unitLink.getEbaPrimaryUnitName());
		parameters.addValue("eba_secondary_unit_id", unitLink.getEbaSecondaryUnitId());
		parameters.addValue("eba_secondary_unit_name", unitLink.getEbaSecondaryUnitName());
		parameters.addValue("inserted_date", LocalDateTime.now());
		parameters.addValue("last_change_date", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		postgresNamedParameterJdbcTemplate.update(insertQuery, parameters);

	}

	// Delete a unitInventory row from eba_units_inventory
	public void deleteSpecificUnitLinkByEbaId(UnitLink unitLink) {

		String deleteQuery = "DELETE FROM units_group.eba_units_link WHERE eba_id = :ebaId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", unitLink.getEbaId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}

}
