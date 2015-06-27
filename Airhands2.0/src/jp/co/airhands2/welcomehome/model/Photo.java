// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Photo.java

package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.primefaces.model.UploadedFile;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name="Photo")
public class Photo extends PersistenceEntity{

	    private static final long serialVersionUID = 0xf5c54dc7afe602f9L;

    @Id
    @Column(name = "photo_id")
    private String photoId;
        
	@Column(name = "photo_name")
    private String photoName;
    
    @Column(name = "photo_file")
    private UploadedFile photoFile;
    
    @ManyToMany(mappedBy = "photos")
    private List<Home> homes;
    
    public String getPhotoId()
    {
        return photoId;
    }

    public void setPhotoId(String photoId)
    {
        this.photoId = photoId;
    }

    public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
    
    public UploadedFile getPhotoFile()
    {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile)
    {
        this.photoFile = photoFile;
    }

    public List<Home> getHomes()
    {
        return homes;
    }

    public void setHomes(List<Home> homes)
    {
        this.homes = homes;
    }

    
}
