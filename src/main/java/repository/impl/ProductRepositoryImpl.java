package repository.impl;

import model.Product;
import repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> fillAll() {
        TypedQuery<Product> query = em.createQuery("select c from Product c",Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {

        TypedQuery<Product> query = em.createQuery("select c from Product c where c.id=:id",Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Product product) {
        if (product.getIdProduct() != null){
            em.merge(product);
        }else {
            em.persist(product);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = findById(id);
        if (product != null){
            em.remove(id);
        }
    }
}
