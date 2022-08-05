package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime,Long> {
}
