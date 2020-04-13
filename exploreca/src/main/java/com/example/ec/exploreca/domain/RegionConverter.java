package com.example.ec.exploreca.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class RegionConverter implements AttributeConverter<Region, String>{

	@Override
	public String convertToDatabaseColumn(Region region) {
		return region.getLabel();
	}

	@Override
	public Region convertToEntityAttribute(String dbValue) {
		return Region.findByLabel(dbValue);
	}

}
