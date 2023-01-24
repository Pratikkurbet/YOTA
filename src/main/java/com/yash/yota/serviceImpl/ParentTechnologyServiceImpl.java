package com.yash.yota.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yota.exception.ParentTechnologyException;
import com.yash.yota.exception.ParentTechnologyNotFoundException;
import com.yash.yota.model.ParentTechnology;
import com.yash.yota.repository.ParentTechnologyRepository;
import com.yash.yota.service.ParentTechnologyService;
/**
 * 
 * @author pankaj.ssharma
 *
 */
@Service
public class ParentTechnologyServiceImpl implements ParentTechnologyService{
	
	@Autowired
	private ParentTechnologyRepository parentTechnologyRepository;

	
	@Override
	public ParentTechnology save(ParentTechnology technology) {
		try {
			technology.setName(technology.getName().toUpperCase());
			return parentTechnologyRepository.save(technology);
		} catch (Exception e) {
			throw new ParentTechnologyException("Technology : "+technology.getName().toUpperCase()+" already exists!!");
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
			throw new ParentTechnologyException("Technology with ID :"+id+" does not exist");
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
			throw new ParentTechnologyNotFoundException("Technology with name : "+name+" does not exist");
		}
		return technology;
	}

	@Override
	public List<ParentTechnology> searchTech(String keyword) {
		List<ParentTechnology> list=parentTechnologyRepository.getByNameContaining(keyword.toUpperCase());
		if (list.isEmpty()) {
			throw new ParentTechnologyNotFoundException("Technology containing keyword  : "+keyword+" does not exist");
		}
		return parentTechnologyRepository.getByNameContaining(keyword.toUpperCase());
	}

}
