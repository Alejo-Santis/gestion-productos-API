package ProductosREST.com.gestion.productos.repository;

import ProductosREST.com.gestion.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Producto, Integer> {
}
