package sample.di.dataaccess;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductDao;

public class ProductDaoImpl implements ProductDao {
	
	public Product getProduct() {
		return new Product("연필", 100);
	}
}
