package ma.fstm.ilisi.model.servise;

import ma.fstm.ilisi.model.bo.Produit;
import ma.fstm.ilisi.model.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitServise {
    @Autowired
private ProduitRepository pro;

    public List<Produit> listAll(){
        return pro.findAll();

    }
    public void save(Produit product) {
        pro.save(product);
    }

    public void delete(long id) {
        pro.deleteById(id);
    }
    public Optional<Produit> get(long id) {
        return pro.findById(id);
    }


}
