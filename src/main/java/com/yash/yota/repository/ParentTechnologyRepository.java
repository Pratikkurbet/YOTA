package com.yash.yota.repository;
/**
 * Repository layer will communicate with DB layer
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.yota.model.ParentTechnology;

/**
 * ParentTechnologyRepository will perform all the CRUD Operations on ParentTechnology. 
 * In case if any customization is required on CRUD operations, it can be done here and 
 * Always extend JPARepository with Type,SerialVersionId
 * @author pankaj.ssharma
 *
 */
public interface ParentTechnologyRepository extends JpaRepository<ParentTechnology, Long>{

	/**
	 * deleteByName method will delete the ParentTechnology by name
	 * @param name of the technology to be deleted
	 * @return true if ParentTechnology is deleted, otherwise should throw exception
	 */
	boolean deleteByName(String name);

	/**
	 * getByName method will give the ParentTechnology detail by name.
	 * @param name of the ParentTechnology to be searched
	 * @return ParentTechnology object if found otherwise null
	 */
	ParentTechnology getByName(String name);

	/**
	 * getByNameContaining method will be used to search ParentTechnology based on the keyword provided
	 * @param keyword to be searched in ParentTechnology
	 * @return List of ParentTechnologies if found otherwise null
	 */
	List<ParentTechnology> getByNameContaining(String keyword);

}
