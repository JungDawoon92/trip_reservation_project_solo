package sample.di.business.service;

import sample.di.business.domain.Product;

public class ProductServiceImpl  implements ProductService {
	
	private ProductDao productDao;

	public Product getProduct() {
		return productDao.getProduct();
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
