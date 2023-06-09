package com.jobmii.JobMii.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

// import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.Vacancy;
// import com.jobmii.JobMii.repositories.PositionVacancyRepository;
import com.jobmii.JobMii.repositories.VacancyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacancyService {
	@Autowired
	private VacancyRepository vacancyRepository;

	public List<Vacancy> getAll() {
		return vacancyRepository.findAll();
	}

	public int countVacancy() {
		return vacancyRepository.countVacancy();
	}

	public int countMyVacancy(Integer id) {
		return vacancyRepository.countMyVacancy(id);
	}

	public List<Vacancy> getMyVacancy(Integer id) {
		return vacancyRepository.getMyVacancy(id);
	}

	public Vacancy getByid(Integer id) {
		return vacancyRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacancy not found!!"));
	}

	public Vacancy create(Vacancy vacancy) {

		// List<Position> positions = new ArrayList<>();
		// positions.add(positionService.getById(vacancy.getPositions()));
		return vacancyRepository.save(vacancy);
	}

	public Vacancy update(Integer id, Vacancy vacancy) {
		getByid(id);
		vacancy.setId(id);
		return vacancyRepository.save(vacancy);
	}

	public Vacancy delete(Integer id) {
		Vacancy vacancy = getByid(id);
		vacancyRepository.delete(vacancy);
		return vacancy;
	}
}
