package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService{
    private static final List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"xe dap",390000,"New","vietnam"));
        products.add(new Product(2,"xe may",300000,"New","vietnam"));
        products.add(new Product(3,"xe oto",290000,"New","vietnam"));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    public int findProductById(int id){
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Product findById(int id) {
        int index = findProductById(id);
        if (index != -1){
            return products.get(index);
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void updateById(int id, Product product) {
        int index = findProductById(id);
        products.set(index, product);
    }

    @Override
    public void removeById(int id) {
        int index = findProductById(id);
        products.remove(index);
    }
}
