package be.vdab.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BrouwerBeginnaam;

@Repository
class JdbcBrouwerRepository implements BrouwerRepository {
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	private static final String BEGIN_SQL = "select id, naam, postcode, gemeente, " + 
			"omzet, straat, huisnr from brouwers ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
	private static final String SQL_FIND_BY_NAAM = BEGIN_SQL + "where naam like ? order by naam";
 	private final RowMapper<Brouwer> rowMapper = (resultSet, rowNum) -> 
		new Brouwer(resultSet.getLong("id"), resultSet.getString("naam"), 
				resultSet.getInt("omzet"), new Adres(resultSet.getString("straat"), 
						resultSet.getString("huisNr"), resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
	public JdbcBrouwerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}
	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisnr", brouwer.getAdres().getHuisNr());
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
		brouwer.setId(id.longValue());
	}
	@Override
	public List<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}
	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, rowMapper, beginNaam + '%');
	}
	@Override
	public List<Brouwer> findByBeginnaam(BrouwerBeginnaam beginnaam) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, rowMapper, beginnaam.getBeginnaam() + '%');
	}
}