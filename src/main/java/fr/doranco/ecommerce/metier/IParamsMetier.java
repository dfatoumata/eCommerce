package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entity.pojo.Params;

public interface IParamsMetier {

	void addParams(Params params) throws Exception;
	Params getParamsById(Integer id) throws Exception;
	void updateParams(Params params) throws Exception;
	void removeParams(Params params) throws Exception;
}
