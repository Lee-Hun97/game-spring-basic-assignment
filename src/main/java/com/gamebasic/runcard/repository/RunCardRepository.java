package com.gamebasic.runcard.repository;

import com.gamebasic.game.entity.Game;
import com.gamebasic.runcard.dto.DeckCount;
import com.gamebasic.runcard.entity.RunCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RunCardRepository extends JpaRepository<RunCard, Long> {
    List<RunCard> findAllByGameOrderByIdAsc(Game game);

    void deleteAllByGame(Game game);

    // TODO (Lv 11): @Query 작성
//    List<DeckCount> countByGames(List<Game> games);

    @Query("""
    SELECT new com.gamebasic.runcard.dto.DeckCount(g.id, COUNT(rc))
    FROM Game g
    LEFT JOIN g.runCards rc
    GROUP BY g.id
    """)
    List<DeckCount> countByGames();

    @Query("""
    SELECT COUNT(rc)
    FROM Game g
    LEFT JOIN g.runCards rc
    WHERE g.id = :gameId
    GROUP BY g.id
    """)
    Long countByGame(@Param("gameId") Long gameId);
}
