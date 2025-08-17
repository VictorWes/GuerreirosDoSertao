package br.com.guerreirosdosertao.GuerreirosDoSertao.repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
