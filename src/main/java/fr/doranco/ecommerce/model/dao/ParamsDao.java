package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.pojo.Params;

public class ParamsDao extends AbstractEntityFacade<Params> implements IParamsDao {

	@Override
	public Params get(Class<Params> entity, Integer id) throws Exception {
		super.get(entity, id);
		return super.get(entity, id);
	}
}
