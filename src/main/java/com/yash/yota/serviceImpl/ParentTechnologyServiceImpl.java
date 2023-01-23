package com.yash.yota.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yota.exception.TechnologyException;
import com.yash.yota.model.ParentTechnology;
import com.yash.yota.repository.ParentTechnologyRepository;
import com.yash.yota.service.ParentTechnologyService;

@Service
public class ParentTechnologyServiceImpl implements ParentTechnologyService{
	
	@Autowired
	private ParentTechnologyRepository parentTechnologyRepository;

	//TODO : @Valid annotation should be used on Controller level
	@Override
	public ParentTechnology save(ParentTechnology technology) {
		try {
			technology.setName(technology.getName().toUpperCase());
			return parentTechnologyRepository.save(technology);
		} catch (Exception e) {
			throw new TechnologyException("Technology : "+technology.getName().toUpperCase()+" already exists!!");
		}
	}

	@Override
	public List<ParentTechnology> getAllTechs() {
		return parentTechnologyRepository.findAll();
	}

	@Override
	@Transactional
	public void removeTech(long id) {
		ParentTechnology parentTechnology=parentTechnologyRepository.findById(id).get();
		if (parentTechnology==null) {
			throw new TechnologyException("Technology with ID :"+id+" does not exist");
		}
		parentTechnologyRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public ParentTechnology updateTech(ParentTechnology technology) {
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
		ParentTechnology technology=parentTechnologyRepository.getByName(name);
		if (technology==null) {
			throw new TechnologyException("Technology with name : "+name+" does not exist");
		}
		return technology;
	}

	@Override
	public List<ParentTechnology> searchTech(String keyword) {
		return parentTechnologyRepository.getByNameContaining(keyword);
	}

}
