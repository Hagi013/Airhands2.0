package jp.co.airhands2.welcomehome.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name="reservation")
public class Reservation extends PersistenceEntity{

    private static final long serialVersionUID = 0xd51d8d633d07315fL;
    
    @Id
    @Column(name = "resebation_no")
    private String reservationNo;
    
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    
    @ManyToOne(targetEntity = Home.class)
    @JoinColumn(name = "home_id", insertable = false, updatable = false)
    private Home home;
    
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_from", nullable= false)
    private Date dateFrom;
    
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_to", nullable= false)
    private Date dateTo;

    @Column(name = "cansel_flag", nullable= false)
    private String cancelFlag;
	
    public String getReservationNo()
    {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Home getHome()
    {
        return home;
    }

    public void setHomeId(Home home)
    {
        this.home = home;
    }

    public Date getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    public String getCancelFlag()
    {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag)
    {
        this.cancelFlag = cancelFlag;
    }


}
