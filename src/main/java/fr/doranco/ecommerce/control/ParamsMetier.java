package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;

public class ParamsMetier implements IParamsMetier{

	IParamsDao paramsDao = new ParamsDao();
	@Override
	public void addParams(Params params) throws Exception {
		paramsDao.add(params);
		
	}

	@Override
	public Params getParamsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return paramsDao.get(Params.class, id);
	}



	@Override
	public void updateParams(Params params) throws Exception {
		paramsDao.update(params);
		
	}

	@Override
	public void removeParams(Params params) throws Exception {
		paramsDao.remove(params);
		
	}

}
