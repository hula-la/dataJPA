package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Team;
import study.datajpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    public Team save(Team Team) {
        em.persist(Team);
        return Team;
    }

    public void delete(Team Team) {
        em.remove(Team);
    }

    public List<Team> findAll() {
        return em.createQuery("select m from Team m", Team.class).getResultList();
    }

    public Optional<Team> findById(Long id) {
        Team Team = em.find(Team.class, id);
        return Optional.ofNullable(Team);
    }

    public long count() {
        return em.createQuery("select count(m) from Team m", Long.class).getSingleResult();
    }

    public Team find(Long id) {
        return em.find(Team.class, id);
    }
}
