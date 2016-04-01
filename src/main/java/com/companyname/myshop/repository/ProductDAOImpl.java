package com.companyname.myshop.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyname.myshop.domain.Product;

@Repository(value = "productDao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
    private SessionFactory sessionFactory;

    /*
     * Sets the session factory.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
    	Session session = this.sessionFactory.openSession();
        List<Product> productList = session.createQuery("from Product").list();
        session.close();
        return productList;
    }

    public void saveProduct(Product prod) {
    	Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(prod);
        tx.commit();
        session.close();
    }

}