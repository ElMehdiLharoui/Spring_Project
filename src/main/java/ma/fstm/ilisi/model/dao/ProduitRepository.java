package ma.fstm.ilisi.model.dao;

import ma.fstm.ilisi.model.bo.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
