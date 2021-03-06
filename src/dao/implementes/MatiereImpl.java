package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.MatiereInterface;
import model.Matiere;

public class MatiereImpl implements MatiereInterface {
	private EntityManagerFactory emfactory;

	public MatiereImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");

	}

	@Override
	public void insertMatiere(Matiere matiere) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(matiere);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateMatiere(Matiere matiere) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(matiere);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteMatiere(Matiere matiere) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(matiere));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Matiere findByIdMatiere(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Matiere matiere = entitymanager.find(Matiere.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return matiere;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matiere> getAllMatiere() {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		List<Matiere> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT m from Matiere m");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

}
