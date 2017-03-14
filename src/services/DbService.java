package services;

import java.sql.Connection;
import java.sql.DriverManager;

import DAL.OwnerRepository;
import DAL.PageRepository;
import DAL.RelationRepository;
import models.Page;

public class DbService {
	
	private OwnerRepository ownerRepo;
	private PageRepository pageRepo;
	private RelationRepository relationRepo;

	
	public DbService(){
		this.ownerRepo = new OwnerRepository();
		this.pageRepo = new PageRepository();
		this.relationRepo = new RelationRepository();

	}

	public boolean addPageWithOwner(Page page, String owner) {
		int ownerId = ownerRepo.addOwner(owner);
		int pageId = pageRepo.addPage(page);
		boolean success = relationRepo.addRelation_owns(ownerId, pageId);
		return success;
	}
	
	
	
	
}
