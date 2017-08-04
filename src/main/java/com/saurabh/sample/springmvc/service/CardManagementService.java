/**
 * 
 */
package com.saurabh.sample.springmvc.service;

import com.saurabh.sample.springmvc.entity.CardDetailsEntity;
import com.saurabh.sample.springmvc.json.object.Staff;
import com.saurabh.sample.springmvc.json.object.StaffMembers;

/**
 * @author Singh.Saurabh
 *
 */
public interface CardManagementService {

	CardDetailsEntity addCardDetails(StaffMembers staffMembers);
	
	CardDetailsEntity updateCardDetails(Staff staff);

	void deleteCardDetails(Staff staff);

	CardDetailsEntity getCardDetails(Staff staff);
}
