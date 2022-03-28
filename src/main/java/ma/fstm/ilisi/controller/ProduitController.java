package ma.fstm.ilisi.controller;

import ma.fstm.ilisi.model.bo.Produit;
import ma.fstm.ilisi.model.servise.ProduitServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    private ProduitServise service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Produit> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Produit product) {
        service.save(product);
        return "redirect:/";
    }
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Produit product = new Produit();
        model.addAttribute("product", product);
        return "new_product";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Produit product = service.get(id).get();
        mav.addObject("product", product);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
