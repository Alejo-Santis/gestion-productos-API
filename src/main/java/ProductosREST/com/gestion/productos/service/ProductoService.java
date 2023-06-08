package ProductosREST.com.gestion.productos.service;

import ProductosREST.com.gestion.productos.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProductosREST.com.gestion.productos.repository.IProductRepository;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private IProductRepository repository;

    public List<Producto> listarProductos(){
        return repository.findAll();
    }

    public void guardarProducto(Producto producto) {
        repository.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void eliminarProducto(Integer id) {
        repository.deleteById(id);
    }
}
