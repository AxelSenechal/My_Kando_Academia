package com.my_kando_academia.my_kando_academia.repository;

import com.my_kando_academia.my_kando_academia.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
}
