package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name = "user")
public class User extends PersistenceEntity{

	 private static final long serialVersionUID = 0xc7f98d73b960e23cL;
	 
	 @Id
	 @NotBlank(message = "ユーザIDを入力して下さい。")
	 @Pattern(regexp = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$", message = "ユーザIDのフォーマットが間違っています。")
	 @Column(name = "user_id", nullable = false, length = 10, unique = true)
	 private String userId;
	 
	 @NotBlank(message = "パスワードを入力して下さい。")
	 @Column(name = "user_pass", nullable = false, length = 10, unique = true)
	 private String userPass;
	  
	 @NotBlank(message = "名を入力してください")
	 @Column(name = "first_name", nullable = false)
	 private String firstName;
	    
	 @NotBlank(message = "性を入力してください")
	 @Column(name = "family_name", nullable = false)	 
	 private String familyName;
	    
	 @NotBlank(message = "性別を入力してください")
	 @Column(name = "sex", nullable = false)	 
	 private String sex;
	 
	 @NotBlank(message = "メールアドレスを入力してください")
	 @Column(name = "mail_address", nullable = false)	 
	 private String mailAddress;
	 
	 @NotBlank(message = "携帯番号を入力してください")
	 @Column(name = "phone1", nullable = false)	 
	 private String phone1;
	 
	 @Column(name = "phone2")
	 private String phone2;
	 
	 @Column(name = "location")	 
	 private String location;
	 
	 @Column(name = "introduce")	
	 private String introduction;
	 
	@OneToMany(mappedBy = "user")
	 private List<Home> homeId;
	
	 
	 
/*	getter,setter
*/	 
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserPass()
    {
        return userPass;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getMailAddress()
    {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress)
    {
        this.mailAddress = mailAddress;
    }

    public String getPhone1()
    {
        return phone1;
    }

    public void setPhone1(String phone1)
    {
        this.phone1 = phone1;
    }

    public String getPhone2()
    {
        return phone2;
    }

    public void setPhone2(String phone2)
    {
        this.phone2 = phone2;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public List<Home> getHomeId() {
		return homeId;
	}

	public void setHomeId(List<Home> homeId) {
		this.homeId = homeId;
	}

   
}
