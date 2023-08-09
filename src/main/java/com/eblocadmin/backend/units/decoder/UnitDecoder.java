package com.eblocadmin.backend.units.decoder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Stream;

import com.eblocadmin.backend.units.entity.Unit;

public class UnitDecoder {
	
//	private Unit unit;
//	
//	public UnitDecoder(Unit unit) {
//		this.unit = unit;
//	}
	
	public StringBuilder getNotNullFieldsFromUnit (Unit unit) {
		
		List<Field> fieldNameList = new ArrayList<>();
		
		for(Field field : unit.getClass().getDeclaredFields()) {
			fieldNameList.add(field);
		}
		
//		fieldNameList.stream().filter(field -> field.equals(null)).collect(Collect);
		
		return null;
	}

}
