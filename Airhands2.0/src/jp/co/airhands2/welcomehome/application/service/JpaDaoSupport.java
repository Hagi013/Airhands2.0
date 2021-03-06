package jp.co.airhands2.welcomehome.application.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;



/**
 * Jpaを使用したGenericDaoクラスです。
 * @author u103531
 * @version 1.0
 * @since 1.0
 * @param <K> 扱う対象のEntityに対するキークラス
 * @param <E> 扱う対象のEntityクラス
 */

public class JpaDaoSupport<K extends Serializable, E extends PersistenceEntity> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4059973236338994761L;

	/** 対象のEntityクラス */
    private Class<E> entityClass;

    /** 永続化コンテキスト */
    @PersistenceContext(unitName = "Airhands2.0")
    protected EntityManager em;

    /**
     * このクラスがインスタンかされるときに呼び出されます。
     * @param entityClass 扱う対象のEntityクラス
     */
    public JpaDaoSupport(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

   //-----------------------
    // Methods for reference.

    /**
     * 全件取得します。
     * @return 取得結果
     */
    public List<E> findAll() {
        CriteriaQuery<E> query = em.getCriteriaBuilder().createQuery(entityClass);
        return em.createQuery(query.select(query.from(entityClass))).getResultList();
    }

    /**
     * キーをもとに1件取得します。
     * @param id キー
     * @return 取得結果
     */
    public E findByKey(K id) {
        if (id == null) {
            return null;
        } else {
            return em.find(entityClass, id);
        }
    }

    /**
     * NamedQueryを指定して取得します。
     * @param queryName クエリ名
     * @return 取得結果
     */
    public List<E> findByNamedQuery(String queryName) {
        return em.createNamedQuery(queryName, entityClass).getResultList();
    }

    /**
     * NamedQueryを取得します。
     * @param queryName クエリ名
     * @return 指定されたNamedQueryオブジェクト
     */
    public TypedQuery<E> getNamedQuery(String queryName) {
        return getNamedQuery(queryName, entityClass);
    }

    /**
     * NameQueryを取得します。
     * @param queryName クエリ名
     * @param clazz 取得結果クラス
     * @param <T> 対象クラス
     * @return 指定されたNameQueryオブジェクト
     */
    public <T> TypedQuery<T> getNamedQuery(String queryName, Class<T> clazz) {
        return em.createNamedQuery(queryName, clazz);
    }

    /**
     * 全件の行数カウントを実行します。
     * @return 全件行数
     */
    public Long countAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        query.select(builder.count(query.from(entityClass)));
        return em.createQuery(query).getSingleResult();
    }

    //-----------------------
    // Methods for create, update, delete.

    /**
     * 新規Entityを保存します。
     * @param key 保存対象Entityのキー
     * @param entity 保存対象のEntity
     * @return 保存結果
     */
    public E save(K key, E entity) {
        E existing = findByKey(key);
        if (existing == null) {
            return persist(entity);
        } else {
            throw new RuntimeException("Duplicate key entry. -> " + key);
        }
    }

    /**
     * Entityを更新します。
     * @param entity 更新対象のEntity
     * @return 更新結果
     */
    public E update(E entity) {
        E result = em.merge(entity);
        return result;
    }

    /**
     * Entityを削除します。
     * @param key 削除対象Entityのキー
     */
    public void remove(K key) {
        E exisiting = findByKey(key);
        em.remove(exisiting);
    }

    /**
     * テーブルの全レコードを削除します。
     */
    public void removeAll() {
        for (E entity : findAll()) {
            em.remove(entity);
        }
    }

    //--------------------------
    // Others.
    /**
     * Entityを空にします。
     * @param entity 扱う対象のエンティティ
     */
    public void refresh(E entity) {
        em.refresh(entity);
    }

    /**
     * 新規Entityを永続化します。
     * @param entity 永続化対象Entity
     * @return 永続化結果
     */
    protected E persist(E entity) {
        if (entity.isNew()) {
            em.persist(entity);
            return entity;

        } else {
            return entity;
        }
    }

}