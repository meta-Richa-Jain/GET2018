package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionManager;
import entity.Advertisement;

public class MYSQLAdvertisementDao implements AdvertisementDao {
	private static MYSQLAdvertisementDao mysqlAdvertisementDao = new MYSQLAdvertisementDao();

	public static MYSQLAdvertisementDao getInstance() {
		return mysqlAdvertisementDao;
	}

	@Override
	
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	@Override
	public void create(Advertisement entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Advertisement t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Advertisement> getAllById(int id) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT_BY_ID;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Advertisement advertisement = new Advertisement();
			while (resultSet.next()) {
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	@Override
	public void updateName(String name, int id) {
		String query = Query.UPDATE_NAME;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
