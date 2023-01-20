package com.yash.yota.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yota.model.ParentTechnology;
import com.yash.yota.repository.ParentTechnologyRepository;
import com.yash.yota.service.ParentTechnologyService;

@Service
public class ParentTechnologyServiceImpl implements ParentTechnologyService{
	
	@Autowired
	private ParentTechnologyRepository parentTechnologyRepository;

	//TODO : @Valid annotation should be used on Controller level
	@Override
	public ParentTechnology save(@Valid ParentTechnology technology) {
		return parentTechnologyRepository.save(technology);
	}

	@Override
	public List<ParentTechnology> getAllTechs() {
		return parentTechnologyRepository.findAll();
	}

	@Override
	@Transactional
	public boolean removeTech(String name) {
		ParentTechnology existParentTechnology=parentTechnologyRepository.getByName(name);
		if (existParentTechnology!=null) {
			
			parentTechnologyRepository.deleteByName(name);
			return true;
		}
		return false;
		
	}

	@Override
	@Transactional
	public ParentTechnology updateTech(@Valid ParentTechnology technology) {
		ParentTechnology existParentTechnology=parentTechnologyRepository.getByName(technology.getName());
		if (existParentTechnology==null) {
			return parentTechnologyRepository.save(technology);
		} else {
			existParentTechnology.setName(technology.getName());
			existParentTechnology.setShortDescription(technology.getShortDescription());
			existParentTechnology.setStatus(technology.isStatus());
			parentTechnologyRepository.save(existParentTechnology);
		}
		return technology;
	}

	@Override
	public ParentTechnology getTech(String name) {
		return parentTechnologyRepository.getByName(name);
	}

	@Override
	public List<ParentTechnology> searchTech(String keyword) {
		return parentTechnologyRepository.getByNameContaining(keyword);
	}

}
