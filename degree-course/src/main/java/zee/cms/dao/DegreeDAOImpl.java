package zee.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.Degree;

@Repository
public class DegreeDAOImpl implements DegreeDAO{

	private EntityManager entityManager;

	@Autowired
	public DegreeDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<Degree> findAll() {
		Query theQuery=entityManager.createQuery("FROM Degree");
		List<Degree> degrees=theQuery.getResultList();
		return degrees;
	}

	@Override
	public Degree findById(long id) {
		Degree degree=entityManager.find(Degree.class, id);
		return degree;
	}

	@Override
	public void save(Degree degree) {
		degree.setName(degree.getName().trim());
		Degree theDegree=entityManager.merge(degree);
		degree.setId(theDegree.getId());
	}

	@Override
	public void deleteById(long id) {
		Query theQuery=entityManager.createQuery("DELETE FROM Degree where id=:degreeId");
		theQuery.setParameter("degreeId", id);
		theQuery.executeUpdate();
	}

}
