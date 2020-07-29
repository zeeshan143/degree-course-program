package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.DegreeDAO;
import zee.cms.entity.Degree;

@Service
public class DegreeServiceImpl implements DegreeService {

	private DegreeDAO degreeDAO;

	@Autowired
	public DegreeServiceImpl(DegreeDAO degreeDAO) { this.degreeDAO = degreeDAO; }

	@Override
	@Transactional
	public List<Degree> findAll() { return degreeDAO.findAll(); }

	@Override
	@Transactional
	public Degree findById(long id) { return degreeDAO.findById(id); }

	@Override
	@Transactional
	public void save(Degree degree) { degreeDAO.save(degree); }

	@Override
	@Transactional
	public void deleteById(long id) { degreeDAO.deleteById(id); }

}
