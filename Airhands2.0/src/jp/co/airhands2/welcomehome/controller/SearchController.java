// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SearchController.java

package jp.co.airhands2.welcomehome.controller;


import java.util.*;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import jp.co.airhands2.welcomehome.application.controller.BaseController;
import jp.co.airhands2.welcomehome.model.Home;
import jp.co.airhands2.welcomehome.model.Photo;
import jp.co.airhands2.welcomehome.service.HomeService;

@Named(value = "searchController")
@ManagedBean
@SessionScoped
public class SearchController extends BaseController {
	private static final long serialVersionUID = 0x8ec952b014bed59bL;

	private Home home;

	private String whereGo;

	private Date checkIn;

	private Date checkOut;

	private List<Home> homeList;

	@Inject
	private HomeService homeService;

	private Photo photo;

	// ------------------------
	// Accessors.

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public String getWhereGo() {
		return whereGo;
	}

	public void setWhereGo(String whereGo) {
		this.whereGo = whereGo;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public List<Home> getHomeList() {
		return homeList;
	}

	public void setHomeList(List<Home> homelist) {
		homeList = homelist;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	/*
	 * method
	 */
	public String homeSearch() {
		if (whereGo != null) {
			homeList = homeService.catchResult(whereGo);

			for (Home home : homeList) {
				List<Photo> photos = new ArrayList<Photo>();
				photos = home.getPhotos();
				for (Photo photo : photos) {
					UploadedFile photoFile = photo.getPhotoFile();
				}

			}

		}
		return redirectTo("/home/home_renting/searchResult");
	}

	public void upload() {
		if (photo.getPhotoFile() != null) {
			FacesMessage message = new FacesMessage("Succesful",
					photo.getPhotoName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			if (photo.getPhotoFile() == null) {
				addErrorMessage("画像を選んでください", "");
			}
		}

	}
}
