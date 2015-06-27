package jp.co.airhands2.welcomehome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.*;

import jp.co.airhands2.welcomehome.application.service.JpaDaoSupport;
import jp.co.airhands2.welcomehome.model.Home;

@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class HomeService extends JpaDaoSupport{

	 /**
     * 扱う対象のHomeクラス
     */
    public HomeService(){
        super(Home.class);
    }

    public List<Home> catchResult(String whereGo)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Home> query = cb.createQuery(Home.class);
        Root<Home> r = query.from(Home.class);
        List<Predicate> preds = new ArrayList<Predicate>();
        preds.add(cb.like(r.get("location").as(String.class), "%" + whereGo + "%"));
        preds.add(cb.like(r.get("address").as(String.class), "%" + whereGo +"%"));
        query.select(r).where(cb.and((Predicate[])preds.toArray(new Predicate[]{})));
        List<Home> homeList = em.createQuery(query).getResultList();
        return homeList;
    }

    private static final long serialVersionUID = 0x5381c3bdc743d996L;
}
