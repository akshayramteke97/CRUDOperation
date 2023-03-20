package in.Crud.Method;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ICrudMethod {
	public Connection getCrudConnection() throws IOException,SQLException;
	public void insert() throws IOException, SQLException;
	public void select() throws IOException,SQLException;
	public void update() throws IOException, SQLException;
	public void delete() throws IOException, SQLException;
}
