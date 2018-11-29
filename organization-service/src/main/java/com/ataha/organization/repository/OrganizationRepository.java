package com.ataha.organization.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ataha.organization.model.Organization;

public class OrganizationRepository {

	private List<Organization> organizations = new ArrayList<>();

	public Organization add(Organization organization) {

		organizations.add(organization);
		return organization;
	}

	public Organization findById(Long id) {

		Optional<Organization> optionalOrganization = organizations.stream()
				.filter(organization -> organization.id.equals(id)).findFirst();

		if (optionalOrganization.isPresent()) {
			return optionalOrganization.get();
		} else {
			return null;
		}
	}

	public List<Organization> findAll() {
		
		return organizations;
	}

}
