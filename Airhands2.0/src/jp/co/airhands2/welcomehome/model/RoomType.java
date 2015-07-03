// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RoomType.java

package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name = "room_type" )
public class RoomType extends PersistenceEntity{

    private static final long serialVersionUID = 0x9580fb5e6c8a03dfL;

    @Id
    @Column(name = "room_type_id")
    private String roomTypeId;
    
    @Column(name = "room_type_name")
    private String roomTypeName;
    
    @OneToMany(targetEntity = Home.class, mappedBy = "roomType", cascade = CascadeType.ALL)
    @JoinColumn(name = "roomTypeId")
    private List<Home> roomTypeIds;

	
	
    public String getRoomTypeId()
    {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId)
    {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName()
    {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName)
    {
        this.roomTypeName = roomTypeName;
    }

    public List<Home> getRoomTypeIds()
    {
        return roomTypeIds;
    }

    public void setRoomTypeIds(List<Home> roomTypeIds)
    {
        this.roomTypeIds = roomTypeIds;
    }

}
