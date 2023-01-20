package com.yash.yota.service;

import java.util.List;

import javax.validation.Valid;

import com.yash.yota.model.ParentTechnology;

/**
 * ParentTechnologyService will be performing business logic related to ParentTechnology
 * @author pankaj.ssharma
 *
 */
public interface ParentTechnologyService {

	/**
	 * save method will save the ParentTechnology. If same technology is already available then it should throw relevant exception.
	 * @param technology to be saved
	 * @return Saved ParentTechnology, it should hold the id of the new ParentTechnology saved in DB
	 */
	ParentTechnology save(ParentTechnology technology);

	/**
	 * getAllTechs method will fetch all ParentTechnologies from DB
	 * @return List of ParentTechnology
	 */
	List<ParentTechnology> getAllTechs();

	/**
	 * removeTech method will remove the technology that is mentioned
	 * @param name of the ParentTechnology to be removed
	 * @return true if removed, otherwise false, in case technology is not available then it should throw appropriate exception.
	 */
	boolean removeTech(String name);

	/**
	 * this updateTech method will update the technology detail of the existing technology
	 * @param technology to be updated
	 * @return Updated ParentTechnology
	 */
	ParentTechnology updateTech(@Valid ParentTechnology technology);

	
	ParentTechnology getTech(String name);

	List<ParentTechnology> searchTech(String keyword);

}
