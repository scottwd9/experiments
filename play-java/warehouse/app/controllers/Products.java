package controllers;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.details;

import java.util.List;

public class Products extends Controller {

    private static final Form<Product> productForm = Form.form(Product.class);

    public Result list() {
        List<Product> products = Product.findAll();
        return ok(views.html.products.list.render(products));
    }

    public Result newProduct() {
        return ok(details.render(productForm));
    }

    public Result details(String ean) {
        return TODO;
    }

    public Result save() {
        Form<Product> boundForm = productForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest(details.render(boundForm));
        }

        Product product = boundForm.get();
        product.save();
        flash("success", String.format("Saved product %s", product));
        return redirect(routes.Products.list());
    }

}
