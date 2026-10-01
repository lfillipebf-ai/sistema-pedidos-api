package br.com.luisfillipe.pedidos.repository;
import br.com.luisfillipe.pedidos.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
 List<OrderEntity> findByCustomerId(Long customerId);
}
