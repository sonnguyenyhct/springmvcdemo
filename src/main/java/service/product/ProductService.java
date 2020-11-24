package service.product;

import model.Customer;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductRepository;

public class ProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> selectAll() {
        return productRepository.fillAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remote(Long id) {
        productRepository.remove(id);
    }
}
