package com.yash.yota.service;

import java.util.List;

import javax.validation.Valid;

import com.yash.yota.model.ParentTechnology;

public interface ParentTechnologyService {

	ParentTechnology save(ParentTechnology technology);

	List<ParentTechnology> getAllTechs();

	boolean removeTech(String name);

	ParentTechnology updateTech(@Valid ParentTechnology technology);

	ParentTechnology getTech(String name);

	List<ParentTechnology> searchTech(String keyword);

}
