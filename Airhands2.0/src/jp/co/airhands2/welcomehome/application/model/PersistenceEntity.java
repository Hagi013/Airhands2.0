package jp.co.airhands2.welcomehome.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * ユーザマスタ関連画面に対応するコントローラクラスです。
 * @author u103531
 * @version 1.0
 * @since 1.0
 */

@MappedSuperclass
public abstract class PersistenceEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -29584304435794929L;

	//--------------------
    // Entity Fields.
    /**
     * 作成日時
     */
    @Column(name = "sakusei_Nichiji")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date sakuseiNichiji;

    /**
     * 作成者
     */
    @Column(name = "sakusei_User")
    private String sakuseiUser;

    /**
     * 作成更新日時
     */
    @Column(name = "saishu_Koushin_Nichiji")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date saishuKoushinNichiji;

    /**
     * 最終更新者
     */
    @Column(name = "saishu_Koushin_User")
    private String saishuKoushinUser;

    /**
     * 削除フラグ
     */
    @Column(name = "sakujo_Flag")
    private String sakujoFlag;

  //--------------------
    // Entity Lifecycle Methods.


    /**
     * 更新直前に実行される処理です。
     */
    @PreUpdate
    protected void preUpdate() {
        setSaishuKoushinNichiji(new Date());
    };

    /**
     * 保存直前に実行される処理です。
     */
    @PrePersist
    protected void prePersist() {
        setSakuseiNichiji(new Date());
    }

    /**
     * 保存済みのEntityかどうかを判定します。
     * @return 保存済みのEntityの場合 True，それ以外の場合False
     */
    public boolean isNew() {
        return sakuseiNichiji == null;
    }

    /**
     *
     * @return 作成日時
     */
    public Date getSakuseiNichiji() {
        return new Date(sakuseiNichiji.getTime());
    }

    /**
     *
     * @param sakuseiNichiji 作成日時
     */
    public void setSakuseiNichiji(Date sakuseiNichiji) {
        this.sakuseiNichiji = new Date(sakuseiNichiji.getTime());
    }

    /**
     *
     * @return 作成者
     */
    public String getSakuseiUser() {
        return sakuseiUser;
    }

    /**
     *
     * @param sakuseiUser 作成者
     */
    public void setSakuseiUser(String sakuseiUser) {
        this.sakuseiUser = sakuseiUser;
    }

    /**
     *
     * @return 最終更新日時
     */
    public Date getSaishuKoushinNichiji() {
        return new Date(saishuKoushinNichiji.getTime());
    }

    /**
     *
     * @param saishuKoushinNichiji 最終更新日時
     */
    public void setSaishuKoushinNichiji(Date saishuKoushinNichiji) {
        this.saishuKoushinNichiji = new Date(saishuKoushinNichiji.getTime());
    }

    /**
     *
     * @return 最終更新者
     */
    public String getSaishuKoushinUser() {
        return saishuKoushinUser;
    }

    /**
     *
     * @param saishuKoushinUser 最終更新者
     */
    public void setSaishuKoushinUser(String saishuKoushinUser) {
        this.saishuKoushinUser = saishuKoushinUser;
    }

    /**
     *
     * @return 削除フラグ
     */
    public String getSakujoFlag() {
        return sakujoFlag;
    }

    /**
     *
     * @param sakujoFlag 削除フラグ
     */
    public void setSakujoFlag(String sakujoFlag) {
        this.sakujoFlag = sakujoFlag;
    }

}
