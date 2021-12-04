package persistence;

import model.Cliente;
import persistence.commons.GenericDAO;

public interface ClienteDAO extends GenericDAO<Cliente> {

	public abstract int update(Cliente t);

	public abstract Cliente findClientePorID(int id_cliente);

}
