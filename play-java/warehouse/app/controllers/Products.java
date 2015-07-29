package controllers;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Products extends Controller {

    public Result list() {
        List<Product> products = Product.findAll();
        return ok(views.html.products.list.render(products));
    }

    public Result newProduct() {
        return TODO;
    }

    public Result details(String ean) {
        return TODO;
    }

    public Result save() {
        return TODO;
    }

}
