package br.com.guerreirosdosertao.GuerreirosDoSertao.Repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
