package sample.di.dataaccess;

import org.springframework.stereotype.Component;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductDao;

@Component
public class ProductDaoImpl implements ProductDao {
	
	public Product findProduct() {
		return new Product("연필", 100);
	}
}
