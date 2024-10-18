package org.sh.jpapro.repository;

import org.sh.jpapro.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
