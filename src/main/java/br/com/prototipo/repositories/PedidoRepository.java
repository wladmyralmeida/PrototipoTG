package br.com.prototipo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.prototipo.domain.Pedido;
import br.com.prototipo.domain.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Transactional(readOnly = true)
	Page<Pedido> findByUsuario(Usuario usuario, Pageable pageRequest);

}
